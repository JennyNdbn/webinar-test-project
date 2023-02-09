package ru.nadobnaya.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    public MainPage openSideMenu() {
         $(".header-bottom").$(".menu__dropdown").click();
         return this;
    }

    public MainPage openVacancyWindow() {
        $(".sidebar__inner").$(byText("Вакансии")).click();
        switchTo().window(1);
        return this;
    }

    public MainPage verifyVacancyWindowOpened() {
        $("[data-hook-content=covercontent]").shouldHave(text("Webinar Group - не просто успешная IT-компания."));
        return this;
    }

    public MainPage openCVWindow() {
        $("[data-hook-content=covercontent]").$(byText("Отправить резюме")).click();
        switchTo().window(2);
        return this;
    }

    public MainPage verifyCVWindowOpened() {
        $("header").shouldHave(text("Привет! Ты в двух шагах от работы мечты. Расскажи подробнее о себе"));
        return this;
    }

    public MainPage openBlog() {
        $(".header-top__links-link", 0).click();
        switchTo().window(1);
        return this;
    }

    public MainPage verifyBlogHeader() {
        $(".header-inner").shouldHave(text("Про онлайн-технологии для бизнеса, работы и образования от компании Webinar Group"));
        return this;
    }

    public MainPage verifyBlogArticle() {
        $("#article").shouldHave(text("Популярное"));
        return this;
    }

    public MainPage verifyBlogFooter() {
        $(".footer").shouldHave(text("pr@webinar.ru"));
        return this;
    }

    public MainPage headerHover(String value) {
        $(".header-bottom").$(byText(value)).hover();
        return this;
    }

    public MainPage openCOMDIProduct() {
        //$(".header-bottom").$(byText("Продукты")).hover();
        $(".header-popup.header-popup--products").$(byText("COMDI")).click();
        return this;
    }

    public MainPage openRequestPopup() {
        $("body").$(byText("Оставьте заявку")).click();
        return this;
    }

    public MainPage verifyRequestPopupOpen() {
        $(".t-popup.t-popup_show").shouldHave(text("Я хочу провести онлайн-мероприятие"));
        return this;
    }

    public MainPage closeRequestPopup() {
        $(".t-popup__close-icon").click();
        return this;
    }

    public MainPage openDetailsWindow() {
        $("body").$(byText("Подробнее")).click();
        switchTo().window(1);
        return this;
    }

    public MainPage verifyDetailsWindowOpen() {
        $(".promo-content").shouldHave(text("Оставайтесь на связи с сотрудниками и клиентами"));
        return this;
    }

    public MainPage openStudentStudyTask() {
        $(".header-popup.header-popup--tasks").$(byText("Обучение студентов вузов")).click();
        return this;
    }

    public MainPage openDateAndTimeChoiceWindow() {
        $("body").$(byText("Выбрать время")).click();
        switchTo().window(1);
        return this;
    }

    public MainPage verifyDateAndTimeChoiceWindowOpen() {
        $(".c-event-info-aside__title").shouldHave(text("Индивидуальное демо по Webinar Group"));
        return this;
    }

    public MainPage openRates() {
        $(".menu__list").$(byText("Тарифы")).click();
        return this;
    }

    public MainPage verifyRatesOpen() {
        $(".block-title.tariffs__title").shouldHave(text("Тарифы"));
        return this;
    }

    public MainPage openRatesForEducation() {
        $(".tab-common__list").$(byText("Для обучения")).click();
        return this;
    }

    public MainPage verifyRatesForEducationOpen() {
        $("#tab-webinar").shouldHave(text("Pro 150"));
        return this;
    }

    public MainPage openRatesTooltip() {
        $("#tab-webinar.tab-common.active").$(".title__info-payment", 10).$(withText("месяц")).click();
        return this;
    }

    public MainPage selectPeriod(int value) {
        $(".tooltip-body__row-month", value).click();
        return this;
    }

    public MainPage verifyRateChange(String value) {
        $(".title__info-price-number", 10).shouldHave(text(value));
        return this;
    }

















}

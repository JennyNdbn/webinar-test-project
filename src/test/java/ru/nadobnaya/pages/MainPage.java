package ru.nadobnaya.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage openPage() {
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











}

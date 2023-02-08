package ru.nadobnaya.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WebinarTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    @Test
    @Disabled
    void googleSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("вебинар").pressEnter();
        $("[#search]").shouldHave(text("Webinar Group — российская экосистема сервисов для встреч, " +
                "онлайн‑мероприятий, обучения и вебинаров."));
    }

    @Test
    void vacancyTest() {
        open("https://webinar.ru/");
        $(".header-bottom").$(".menu__dropdown").click();
        $(".sidebar__inner").$(byText("Вакансии")).click();
        //sleep(5000);
        switchTo().window(1);
        $("[data-hook-content=covercontent]").shouldHave(text("Webinar Group - не просто успешная IT-компания."));
        $("[data-hook-content=covercontent]").$(byText("Отправить резюме")).click();
        switchTo().window(2);
        $("header").shouldHave(text("Привет! Ты в двух шагах от работы мечты. Расскажи подробнее о себе"));
    }

    @Test
    void blogTest() {
        open("https://webinar.ru/");
        $(".header-top__links-link", 0).click();
        switchTo().window(1);
        $(".header-inner").shouldHave(text("Про онлайн-технологии для бизнеса, работы и образования от компании Webinar Group"));
        $("#article").shouldHave(text("Популярное"));
        $(".footer").shouldHave(text("pr@webinar.ru"));
    }

    @Test
    void productComdiTest() {
        open("https://webinar.ru/");
        $(".header-bottom").$(byText("Продукты")).hover();
        $(".header-popup.header-popup--products").$(byText("COMDI")).click();
        $("body").$(byText("Оставьте заявку")).click();
        $(".t-popup.t-popup_show").shouldHave(text("Я хочу провести онлайн-мероприятие"));
        $(".t-popup__close-icon").click();
        $("body").$(byText("Подробнее")).click();
        switchTo().window(1);
        $(".promo-content").shouldHave(text("Оставайтесь на связи с сотрудниками и клиентами"));
    }

    @Test
    void tasksEducationTest() {
        open("https://webinar.ru/");
        $(".header-bottom").$(byText("Задачи")).hover();
        $(".header-popup.header-popup--tasks").$(byText("Обучение студентов вузов")).click();
        $("body").$(byText("Выбрать время")).click();
        switchTo().window(1);
        $(".c-event-info-aside__title").shouldHave(text("Индивидуальное демо по Webinar Group"));
    }

    @Test
    void priceChangingTest(){
        open("https://webinar.ru/");
        $(".menu__list").$(byText("Тарифы")).click();
        $(".block-title.tariffs__title").shouldHave(text("Тарифы"));
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");

        $(".tab-common__list").$(byText("Для обучения")).click();
        $("#tab-webinar").shouldHave(text("Pro 150"));

        $("#tab-webinar.tab-common.active").$(".title__info-payment", 10).$(withText("месяц")).click();
        $(".tooltip-body__row-month", 0).click();
        $(".title__info-price-number", 10).shouldHave(text("13 195"));

        $("#tab-webinar.tab-common.active").$(".title__info-payment", 10).$(withText("месяц")).click();
        $(".tooltip-body__row-month", 1).click();
        $(".title__info-price-number", 10).shouldHave(text("11 875"));

        $("#tab-webinar.tab-common.active").$(".title__info-payment", 10).$(withText("месяц")).click();
        $(".tooltip-body__row-month", 2).click();
        $(".title__info-price-number", 10).shouldHave(text("10 556"));
    }


}

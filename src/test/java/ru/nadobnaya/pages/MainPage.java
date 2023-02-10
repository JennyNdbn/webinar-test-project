package ru.nadobnaya.pages;

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

    public MainPage openWindowFromSidebar(String value) {
        $(".sidebar__inner").$(byText(value)).click();
        switchTo().window(1);
        return this;
    }

    public MainPage openBlog() {
        $(".header-top__links-link", 0).click();
        switchTo().window(1);
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

    public MainPage openStudentStudyTask() {
        $(".header-popup.header-popup--tasks").$(byText("Обучение студентов вузов")).click();
        return this;
    }

    public MainPage openRates() {
        $(".menu__list").$(byText("Тарифы")).click();
        return this;
    }

}

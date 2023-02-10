package ru.nadobnaya.tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebinarTests extends TestBase {



    @Test
    @Disabled
    void googleSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("вебинар").pressEnter();
        $("[#search]").shouldHave(text("Webinar Group — российская экосистема сервисов для встреч, " +
                "онлайн‑мероприятий, обучения и вебинаров."));
    }

    @Test
    @Tag("remote")
    void vacancyTest() {
        mainPage.openPage()
                .openSideMenu()
                .openWindowFromSidebar("Вакансии");
        vacancyPage.verifyVacancyWindowOpened();
        vacancyPage.openCVWindow();
        cvPage.verifyCVWindowOpened();
    }

    @Test
    @Tag("remote")
    void blogTest() {
        mainPage.openPage()
                .openBlog();
        blogPage.verifyBlogHeader();
        blogPage.verifyBlogArticle();
        blogPage.verifyBlogFooter();
    }

    @Test
    @Tag("remote")
    void productComdiTest() {
        mainPage.openPage()
                .headerHover("Продукты")
                .openCOMDIProduct();
        productComdiPage.openRequestPopup();
        productComdiPage.verifyRequestPopupOpen();
        productComdiPage.closeRequestPopup();
        productComdiPage.openDetailsWindow();
        comdiPage.verifyDetailsWindowOpen();
    }

    @Test
    @Tag("remote")
    void tasksEducationTest() {
        mainPage.openPage()
                .headerHover("Задачи")
                .openStudentStudyTask();
        studyTaskPage.openDateAndTimeChoiceWindow();
        studentEnrollPage.verifyDateAndTimeChoiceWindowOpen();
    }

    @Test
    @Tag("remote")
    void priceChangingTest(){
        mainPage.openPage()
                .openRates();
        ratesPage.verifyRatesOpen();
        ratesPage.openRatesForEducation();
        ratesPage.openRatesTooltip()
                .selectPeriod(0)
                .verifyRateChange("13 195");
        ratesPage.openRatesTooltip()
                .selectPeriod(1)
                .verifyRateChange("11 875");
        ratesPage.openRatesTooltip()
                .selectPeriod(2)
                .verifyRateChange("10 556");
    }

}

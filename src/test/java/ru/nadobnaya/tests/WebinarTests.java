package ru.nadobnaya.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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
    @DisplayName("Testing of opening vacancy and CV windows")
    @Owner("Evgeniia Nadobnaia")
    @Feature("Testing of webinar.ru")
    @Story("Testing of opening vacancy window from side menu and CV window from vacancy page")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("remote")
    void vacancyTest() {
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Open side menu", () -> {
            mainPage.openSideMenu();
        });
        step("Open vacancy window", () -> {
            mainPage.openWindowFromSidebar("Вакансии");
        });
        step("Verify that vacancy window has opened", () -> {
            vacancyPage.verifyVacancyWindowOpened();
        });
        step("Open CV window", () -> {
            vacancyPage.openCVWindow();
        });
        step("Verify that CV window has opened", () -> {
            cvPage.verifyCVWindowOpened();
        });
    }

    @Test
    @DisplayName("Testing of blog opening")
    @Owner("Evgeniia Nadobnaia")
    @Feature("Testing of webinar.ru")
    @Story("Testing of opening blog window from header and verifying blog header, article and footer")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("remote")
    void blogTest() {
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Open blog page from header", () -> {
            mainPage.openBlog();
        });
        step("Verify blog header", () -> {
            blogPage.verifyBlogHeader();
        });
        step("Verify blog article", () -> {
            blogPage.verifyBlogArticle();
        });
        step("Verify blog footer", () -> {
            blogPage.verifyBlogFooter();
        });
    }

    @Test
    @DisplayName("Testing of COMDI product page")
    @Owner("Evgeniia Nadobnaia")
    @Feature("Testing of webinar.ru")
    @Story("Testing of opening COMDI page from header by using hover action. Testing request popup and details button on COMDI page")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("remote")
    void productComdiTest() {
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Open COMDI page from products popup", () -> {
            mainPage.headerHover("Продукты")
                .openCOMDIProduct();
        });
        step("Open request popup on COMDI page", () -> {
            productComdiPage.openRequestPopup();
        });
        step("Verify that request popup has opened on COMDI page", () -> {
            productComdiPage.verifyRequestPopupOpen();
        });
        step("Close request popup on COMDI page", () -> {
            productComdiPage.closeRequestPopup();
        });
        step("Click details button on COMDI page", () -> {
            productComdiPage.openDetailsWindow();
        });
        step("Verify that COMDI site has opened", () -> {
            comdiPage.verifyDetailsWindowOpen();
        });
    }

    @Test
    @Tag("remote")
    void tasksEducationTest() {
        mainPage.openPage();
        mainPage.headerHover("Задачи");
        mainPage.openStudentStudyTask();
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

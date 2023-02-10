package ru.nadobnaya.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class VacancyPage {

    public VacancyPage verifyVacancyWindowOpened() {
        $("[data-hook-content=covercontent]").shouldHave(text("Webinar Group - не просто успешная IT-компания."));
        return this;
    }

    public VacancyPage openCVWindow() {
        $("[data-hook-content=covercontent]").$(byText("Отправить резюме")).click();
        switchTo().window(2);
        return this;
    }



}

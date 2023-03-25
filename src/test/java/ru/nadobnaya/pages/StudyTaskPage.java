package ru.nadobnaya.pages;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class StudyTaskPage {

    public StudyTaskPage openDateAndTimeChoiceWindow() {
        $("body").$(byTagAndText("a", "Выбрать время")).click();
        switchTo().window(1);
        return this;
    }

}

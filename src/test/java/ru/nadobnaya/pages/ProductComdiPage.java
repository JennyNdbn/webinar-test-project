package ru.nadobnaya.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProductComdiPage {

    public ProductComdiPage openRequestPopup() {
        $("body").$(byText("Оставьте заявку")).click();
        return this;
    }

    public ProductComdiPage verifyRequestPopupOpen() {
        $(".t-popup.t-popup_show").shouldHave(text("Я хочу провести онлайн-мероприятие"));
        return this;
    }

    public ProductComdiPage closeRequestPopup() {
        $(".t-popup__close-icon").click();
        return this;
    }

    public ProductComdiPage openDetailsWindow() {
        $("body").$(byText("Подробнее")).click();
        switchTo().window(1);
        return this;
    }


}

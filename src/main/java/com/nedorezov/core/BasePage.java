package com.nedorezov.core;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
//    private static final String NOT_VISIBLE_REQUIRED_PAGE_ELEMENT = "Не отображается один из обязательных элементов страницы.";
//    private final List<By> requiredPageElements;

//    protected BasePage(List<By> requiredPageElements) {
//        this.requiredPageElements = requiredPageElements;
//        checkPage();
//    }

//    public void checkPage() {
//        requiredPageElements.forEach(el -> $(el).shouldBe(visible.because(NOT_VISIBLE_REQUIRED_PAGE_ELEMENT)));
//    }

    public void refreshPage() {
        Selenide.refresh();
    }
}

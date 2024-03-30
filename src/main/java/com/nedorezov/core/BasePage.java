package com.nedorezov.core;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public abstract class BasePage {
    private final List<SelenideElement> requiredPageElements;

    protected BasePage(List<SelenideElement> requiredPageElements) {
        this.requiredPageElements = requiredPageElements;
        checkPage();
    }

    public void checkPage() {
        requiredPageElements.forEach(el -> el.shouldBe(visible));
    }

    public void refreshPage() {
        Selenide.refresh();
    }
}

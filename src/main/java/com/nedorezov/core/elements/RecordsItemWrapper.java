package com.nedorezov.core.elements;

import com.codeborne.selenide.SelenideElement;

public class RecordsItemWrapper {
    private final SelenideElement item;
    public RecordsItemWrapper(SelenideElement item) {
        this.item = item;
    }
}

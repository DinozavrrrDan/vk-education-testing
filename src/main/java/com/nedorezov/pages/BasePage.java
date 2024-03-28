package com.nedorezov.pages;

import com.codeborne.selenide.Selenide;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BasePage {
    private String pageUrl;

    public void open() {
        Selenide.open(pageUrl);
    }
}

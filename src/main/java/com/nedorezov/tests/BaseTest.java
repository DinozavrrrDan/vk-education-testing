package com.nedorezov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.nedorezov.config.Config.BROWSER;
import static com.nedorezov.config.Config.BROWSER_SIZE;

public abstract class BaseTest {
    public static void setUp() {
        Configuration.browser = BROWSER;
        Configuration.browserSize = BROWSER_SIZE;
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @AfterEach
    public void close() {
        Selenide.closeWebDriver();
    }
}

package com.nedorezov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @AfterAll
    public static void close() {
        Selenide.closeWebDriver();
    }
}

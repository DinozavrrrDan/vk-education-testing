package com.nedorezov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.nedorezov.model.TestBot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.nedorezov.config.Config.*;

public abstract class BaseTest {

    protected static final TestBot BOT = new TestBot(LOGIN, PASSWORD);
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

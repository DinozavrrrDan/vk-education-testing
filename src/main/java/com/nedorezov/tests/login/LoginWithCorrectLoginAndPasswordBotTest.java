package com.nedorezov.tests.login;

import com.nedorezov.core.pages.login.LoginPage;
import com.nedorezov.core.pages.main.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.nedorezov.config.Config.PASSWORD;
import static com.nedorezov.config.Config.LOGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginWithCorrectLoginAndPasswordBotTest extends LoginPageBaseTest {

    private static final String ASSERTION_FAIL_MESSAGE = "Имя пользователя на сранице не совпало с именем " +
            "с помощью которог необходимо было зайти." +
            " P.S. Этот тест предназначен для ботов, т.к. у них дублируются имена";

    /**
     * Тест предназначен для ботов т.к. у них дублируется имя
     */
    @Test
    @Tag("login")
    @DisplayName("Login with correct login and password test")
    public void testLoginWithCorrectLoginAndPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage.login(LOGIN, PASSWORD);
        MainPage mainPage = new MainPage();

        assertEquals(LOGIN + " " + LOGIN, mainPage.getUserNameFromNavigationBlock(),
                ASSERTION_FAIL_MESSAGE);
    }
}

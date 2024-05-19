package com.nedorezov.tests.login;

import com.nedorezov.core.pages.login.LoginPage;
import com.nedorezov.core.pages.main.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginWithCorrectLoginAndPasswordBotTest extends LoginPageBaseTest {

    /**
     * Тест предназначен для ботов т.к. у них дублируется имя
     */
    @Test
    @Tag("login")
    @DisplayName("Login with correct login and password test")
    @Timeout(value = 60)
    public void testLoginWithCorrectLoginAndPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(BOT.name(), BOT.password());
        MainPage mainPage = new MainPage();
        assertEquals(BOT.name() + " " + BOT.name(), mainPage.getUserNameFromNavigationMenu(),
                "Имя пользователя на сранице не совпало с именем " +
                        "с помощью которог необходимо было зайти." +
                        " P.S. Этот тест предназначен для ботов, т.к. у них дублируются имена");
    }
}

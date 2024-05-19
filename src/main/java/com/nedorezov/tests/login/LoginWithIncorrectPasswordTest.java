package com.nedorezov.tests.login;

import com.nedorezov.core.pages.login.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.nedorezov.config.Config.LOGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginWithIncorrectPasswordTest extends LoginPageBaseTest {
    @ParameterizedTest(name = "Login with incorrect password test")
    @ValueSource(strings = "incorrect password")
    @Tag("login")
    @Timeout(value = 60)
    public void testLoginInWithIncorrectPassword(String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(BOT.name(), password);

        assertEquals("Неправильно указан логин и/или пароль", loginPage.getTextFromFailLoginBlock(),
                "Сообщение об ошибке при неправильном вводе пароля не совпадает с ожидаемой.");
    }
}

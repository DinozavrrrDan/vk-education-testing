package com.nedorezov.tests.login;

import com.nedorezov.core.pages.login.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.concurrent.TimeUnit;

import static com.nedorezov.config.Config.LOGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginWithEmptyPasswordFieldTest extends LoginPageBaseTest {

    @ParameterizedTest(name = "Login with empty password field test")
    @EmptySource
    @Tag("login")
    @Timeout(value = 60)
    public void testLoginWithEmptyPasswordField(String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(BOT.name(), password);

        assertEquals("Введите пароль", loginPage.getTextFromFailLoginBlock(),
                "Сообщение об ошибке при вводе пустого пароля не совпадает с ожидаемой.");
    }
}


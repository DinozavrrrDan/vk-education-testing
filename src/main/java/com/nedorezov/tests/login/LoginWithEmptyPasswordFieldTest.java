package com.nedorezov.tests.login;

import com.nedorezov.core.pages.login.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static com.nedorezov.config.Config.LOGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginWithEmptyPasswordFieldTest extends LoginPageBaseTest {


    public static final String ASSERTION_FAIL_MESSAGE =
            "Сообщение об ошибке при вводе пустого пароля не совпадает с ожидаемой.";
    private static final String EMPTY_PASSWORD_ERROR_MESSAGE = "Введите пароль";

    @ParameterizedTest(name = "Login with empty password field test")
    @EmptySource
    @Tag("login")
    public void testLoginWithEmptyPasswordField(String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(LOGIN, password);

        assertEquals(EMPTY_PASSWORD_ERROR_MESSAGE, loginPage.getTextFromFailLoginBlock(),
                ASSERTION_FAIL_MESSAGE);
    }
}


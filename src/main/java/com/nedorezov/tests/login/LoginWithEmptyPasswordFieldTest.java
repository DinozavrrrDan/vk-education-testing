package com.nedorezov.tests.login;

import com.nedorezov.core.LoginPage;
import org.junit.jupiter.api.Test;

import static com.nedorezov.config.Config.LOGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginWithEmptyPasswordFieldTest extends LoginPageBaseTest {


    public static final String ASSERTION_FAIL_MESSAGE =
            "Сообщение об ошибке при вводе пустого пароля не совпадает с ожидаемой.";
    private static final String EMPTY_PASSWORD_ERROR_MESSAGE = "Введите пароль";
    private static final String EMPTY_PASSWORD = "";

    @Test
    public void testLoginWithEmptyPasswordField() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(LOGIN, EMPTY_PASSWORD);

        assertEquals(EMPTY_PASSWORD_ERROR_MESSAGE, loginPage.getTextFromFailLoginBlock(),
                ASSERTION_FAIL_MESSAGE);
    }
}


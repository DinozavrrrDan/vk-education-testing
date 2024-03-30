package com.nedorezov.tests.login;

import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.nedorezov.config.Config.LOGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginWithIncorrectPasswordTest extends LoginPageBaseTest {
    private static final SelenideElement failLogInTextField = $(By.xpath(".//*[@class='form_i form_i__error']"));
    private static final String INCORRECT_USER_NAME_OR_PASSWORD_ERROR_MESSAGE = "Неправильно указан логин и/или пароль";
    private static final String INCORRECT_PASSWORD = "INCORRECT PASSWORD";
    private static final String ASSERTION_FAIL_MESSAGE = "Сообщение об ошибке при неправильном вводе пароля не совпадает с ожидаемой.";

    @Test
    public void testLoginInWithIncorrectPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage.login(LOGIN, INCORRECT_PASSWORD);
        failLogInTextField.shouldBe(visible);

        assertEquals(INCORRECT_USER_NAME_OR_PASSWORD_ERROR_MESSAGE, failLogInTextField.getText(),
                ASSERTION_FAIL_MESSAGE);
    }
}

package com.nedorezov.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.nedorezov.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.nedorezov.Config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageTest extends BaseTest {

    private static final SelenideElement failLOgInTextField = $(By.xpath("//div[@class=\"form_i form_i__error\"]"));

    private static final SelenideElement mainPage = $(By.xpath("/html"));
    public static final String INCORRECT_USER_NAME_OR_PASSWORD_ERROR_MESSAGE = "Неправильно указан логин и/или пароль";
    public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "Введите пароль";
    public static final String INCORRECT_PASSWORD = "INCORRECT PASSWORD";

    @Test
    public void testLoginInWithCorrectData() {
        LoginPage loginPage = new LoginPage(BASE_URL);
        loginPage.open();
        loginPage.login(LOGIN, PASSWORD);
        mainPage.shouldBe(attributeMatching("data-initial-state-id", "userMain"));
    }

    @Test
    public void testLoginInWithIncorrectPassword() {
        LoginPage loginPage = new LoginPage(BASE_URL);
        loginPage.open();
        loginPage.login(LOGIN, INCORRECT_PASSWORD);
        failLOgInTextField.shouldBe(visible);
        assertEquals(INCORRECT_USER_NAME_OR_PASSWORD_ERROR_MESSAGE, failLOgInTextField.getText());
    }

    @Test
    public void testLoginInWithEmptyPasswordField() {
        LoginPage loginPage = new LoginPage(BASE_URL);
        loginPage.open();
        loginPage.login(LOGIN, "");
        failLOgInTextField.shouldBe(visible);
        assertEquals(EMPTY_PASSWORD_ERROR_MESSAGE, failLOgInTextField.getText());
    }
}

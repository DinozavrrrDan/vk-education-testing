package com.nedorezov.core;

import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    public static final String NOT_VISIBLE_PASSWORD_FIELD = "Не видно поля ввода пароля.";
    private static final SelenideElement loginField =
            $(By.xpath(".//*[@name='st.email' and @id='field_email']"));
    private static final SelenideElement passwordField =
            $(By.xpath(".//*[@name='st.password' and @id='field_password']"));
    private static final SelenideElement signInButton =
            $(By.xpath(".//input[@value='Войти в Одноклассники']"));
    private static final SelenideElement failLoginBlock =
            $(By.xpath(".//*[@class='form_i form_i__error']"));
    private static final String NOT_VISIBLE_LOGIN_FIELD = "Не видно поля ввода логина.";
    private static final String NOT_VISIBLE_SIGN_IN_BUTTON = "Не видна кнопка \"Зайти в одноклассники\".";
    private static final String NOT_VISIBLE_ERROR_LOGIN_MESSAGE = "Не видно сообщения об ошибке во время логина.";

    public LoginPage() {
        super(List.of(loginField, passwordField, signInButton));
    }

    public void login(String email, String password) {
        loginField.shouldBe(visible.because(NOT_VISIBLE_LOGIN_FIELD)).setValue(email);
        passwordField.shouldBe(visible.because(NOT_VISIBLE_PASSWORD_FIELD)).setValue(password);
        signInButton.shouldBe(visible.because(NOT_VISIBLE_SIGN_IN_BUTTON)).click();
    }

    public String getTextFromFailLoginBlock() {
        return failLoginBlock.shouldBe(visible.because(NOT_VISIBLE_ERROR_LOGIN_MESSAGE)).getText();
    }
}

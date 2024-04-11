package com.nedorezov.core.pages.login;

import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.nedorezov.core.pages.login.LoginPageInfoMessages.*;

public class LoginPage extends BasePage {

    private static final By loginField =
            By.xpath(".//*[@name='st.email' and @id='field_email']");
    private static final By passwordField =
            By.xpath(".//*[@name='st.password' and @id='field_password']");
    private static final By signInButton =
            By.xpath(".//input[@value='Войти в Одноклассники']");
    private static final By failLoginBlock =
            By.xpath(".//*[@class='form_i form_i__error']");

    public LoginPage() {
        super(List.of(loginField, passwordField, signInButton));
    }

    public void login(String email, String password) {
        $(loginField).shouldBe(visible.because(NOT_VISIBLE_LOGIN_FIELD)).setValue(email);
        $(passwordField).shouldBe(visible.because(NOT_VISIBLE_PASSWORD_FIELD)).setValue(password);
        $(signInButton).shouldBe(visible.because(NOT_VISIBLE_SIGN_IN_BUTTON)).click();
    }

    public String getTextFromFailLoginBlock() {
        return $(failLoginBlock).shouldBe(visible.because(NOT_VISIBLE_ERROR_LOGIN_MESSAGE)).getText();
    }
}

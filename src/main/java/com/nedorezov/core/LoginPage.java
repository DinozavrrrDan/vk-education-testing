package com.nedorezov.core;

import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    private static final SelenideElement loginField =
            $(By.xpath(".//*[@name='st.email' and @id='field_email']"));
    private static final SelenideElement passwordField =
            $(By.xpath(".//*[@name='st.password' and @id='field_password']"));
    private static final SelenideElement signInButton =
            $(By.xpath(".//input[@value='Войти в Одноклассники']"));
    private static final SelenideElement failLoginBlock =
            $(By.xpath(".//*[@class='form_i form_i__error']"));

    public LoginPage() {
        super(List.of(loginField, passwordField, signInButton));
    }

    public void login(String email, String password) {
        loginField.shouldBe(visible).setValue(email);
        passwordField.shouldBe(visible).setValue(password);
        signInButton.shouldBe(visible).click();
    }

    public String getTextFromFailLoginBlock() {
        return failLoginBlock.shouldBe(visible).getText();
    }
}

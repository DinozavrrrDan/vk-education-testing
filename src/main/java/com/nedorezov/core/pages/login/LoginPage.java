package com.nedorezov.core.pages.login;

import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final By LOGIN_FIELD =
            By.xpath(".//*[@name='st.email']");
    private static final By PASSWORD_FIELD =
            By.xpath(".//*[@name='st.password']");
    private static final By SIGN_IN_BUTTON =
            By.xpath(".//input[@value='Войти в Одноклассники']");
    private static final By FAIL_LOGIN_BLOCK =
            By.xpath(".//*[@class='form_i form_i__error']");

    public LoginPage() {
        check();
    }

    public boolean check() {
        $(LOGIN_FIELD)
                .shouldBe(visible.because("Не видно поля ввода логина."));
        $(PASSWORD_FIELD)
                .shouldBe(visible.because("Не видно поля ввода пароля."));
        $(SIGN_IN_BUTTON)
                .shouldBe(visible.because("Не видна кнопка \"Зайти в одноклассники\"."));
        return true;
    }

    public void login(String login, String password) {
        enterLogin(login)
                .enterPassword(password)
                .clickSubmitButton();
    }

    public LoginPage enterLogin(String login) {
        $(LOGIN_FIELD).shouldBe(visible.because("Не видно поля ввода логина."))
                .setValue(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(PASSWORD_FIELD).shouldBe(visible.because("Не видно поля ввода пароля."))
                .setValue(password);
        return this;
    }

    public LoginPage clickSubmitButton() {
        $(SIGN_IN_BUTTON).shouldBe(visible.because("Не видна кнопка \"Зайти в одноклассники\"."))
                .click();
        return this;
    }

    public String getTextFromFailLoginBlock() {
        return $(FAIL_LOGIN_BLOCK).shouldBe(visible.because("Не видно сообщения об ошибке во время логина.")).getText();
    }
}

package com.nedorezov.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    public SelenideElement loginField = $(By.xpath("//*[@id=\"field_email\"]"));
    public SelenideElement passwordField = $(By.xpath("//*[@id=\"field_password\"]"));
    public SelenideElement signInButton = $(By.xpath("/html/body/div[11]/div[5]/div[2]/div[1]/div/div/div/div[2]/div[3]/div[3]/div/div/main/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/input"));
    public SelenideElement okPage = $(By.xpath("/html/body"));

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    public String login(String email, String password) {
        loginField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        String[] data = Objects.requireNonNull(okPage.getAttribute("data-l")).split(",");
        return data[data.length - 1];
    }
}

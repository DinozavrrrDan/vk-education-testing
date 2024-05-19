package com.nedorezov.core.pages.user.myUser;

import com.nedorezov.core.pages.user.BaseUserPage;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyUserPage extends BaseUserPage {

    private static final By userSettingsButton = By.xpath(".//*[contains(@data-l, 'settings,t,settings')]");
    private static final By userShareButton = By.xpath(".//*[contains(@data-l, 'share')]");
    private static final By recordsButton = By.xpath(".//*[@data-l='t,userStatuses']");

    public MyUserPage() {
        super(List.of(userSettingsButton, userShareButton));
    }

    public void navigateToRecordsPage() {
        $(recordsButton).shouldBe(visible.because("Не отображается кнопка \"Записи\" в навигационном меню")).click();
    }


}

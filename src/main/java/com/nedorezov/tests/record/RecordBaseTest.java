package com.nedorezov.tests.record;

import com.codeborne.selenide.Selenide;
import com.nedorezov.core.pages.login.LoginPage;
import com.nedorezov.core.pages.main.MainPage;
import com.nedorezov.core.pages.records.RecordsPage;
import com.nedorezov.core.pages.user.myUser.MyUserPage;
import com.nedorezov.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;

import static com.nedorezov.config.Config.*;

public abstract class RecordBaseTest extends BaseTest {
    @BeforeEach
    void logInAndOpenRecordsPage() {
        Selenide.open(BASE_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.login(LOGIN, PASSWORD);

        MainPage mainPage = new MainPage();
        mainPage.openMyUserPage();

        MyUserPage myUserPage = new MyUserPage();
        myUserPage.navigateToRecordsPage();
    }
}

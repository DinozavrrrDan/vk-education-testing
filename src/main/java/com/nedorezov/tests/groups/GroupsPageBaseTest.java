package com.nedorezov.tests.groups;

import com.codeborne.selenide.Selenide;
import com.nedorezov.core.LoginPage;
import com.nedorezov.core.MainPage;
import com.nedorezov.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;

import static com.nedorezov.config.Config.*;

public class GroupsPageBaseTest extends BaseTest {
    @BeforeEach
    void logIn() {
        Selenide.open(BASE_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.login(LOGIN, PASSWORD);

        MainPage mainPage = new MainPage();
        mainPage.openGroupsPageFromNavigationBlock();
    }
}

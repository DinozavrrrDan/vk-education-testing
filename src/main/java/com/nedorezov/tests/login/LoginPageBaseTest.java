package com.nedorezov.tests.login;

import com.codeborne.selenide.Selenide;
import com.nedorezov.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;

import static com.nedorezov.Config.*;

public class LoginPageBaseTest extends BaseTest {
    @BeforeEach
    void openLoginPage() {
        Selenide.open(BASE_URL);
    }
}

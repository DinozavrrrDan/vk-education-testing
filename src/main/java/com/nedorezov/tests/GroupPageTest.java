package com.nedorezov.tests;

import com.nedorezov.pages.GroupPage;
import com.nedorezov.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static com.nedorezov.Config.BASE_URL;
import static com.nedorezov.Config.LOGIN;
import static com.nedorezov.Config.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GroupPageTest extends BaseTest {
    private static final String PROFILE_URL = "/profile";
    private static final String GROUPS_URL = "/groups";
    public static final String SLASH = "/";

    @Test
    public void testSearchGroup() {
        LoginPage loginPage = new LoginPage(BASE_URL);
        loginPage.open();
        String userId = loginPage.login(LOGIN, PASSWORD);

        GroupPage groupPage = new GroupPage(BASE_URL + PROFILE_URL + SLASH + userId + GROUPS_URL);
        groupPage.open();

        String findGroupName = groupPage.getRandomGroupName();
        String searchResultGroupName = groupPage.searchForGroup(findGroupName);
        assertEquals(findGroupName, searchResultGroupName);
    }

}

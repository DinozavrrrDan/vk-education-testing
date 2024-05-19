package com.nedorezov.core.pages.main;

import com.nedorezov.core.BasePage;
import com.nedorezov.core.elements.NavigationMenuWrapper;
import com.nedorezov.core.pages.groups.GroupsPage;
import com.nedorezov.core.pages.user.myUser.MyUserPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final By mainPageFeed =
            By.xpath(".//*[contains(@class, 'main-feed portlet')]");
    private static final By mainPageBlockOfAlternativeContent =
            By.xpath(".//*[contains(@class, 'alternative-content-block')]");

    private static final NavigationMenuWrapper navigationBlock = new NavigationMenuWrapper();
    public MainPage() {
        check();
    }

    public boolean check() {
        $(mainPageFeed)
                .shouldBe(visible.because("Не видно фида."));
        $(mainPageBlockOfAlternativeContent)
                .shouldBe(visible.because("Не видно блока альтернативного контента."));
        return true;
    }

    public String getUserNameFromNavigationMenu() {
        return navigationBlock.getUserName();
    }

    public MyUserPage openMyUserPage() {
        return navigationBlock.openMyUserPage();
    }
    public GroupsPage openGroupsPage() {
        return navigationBlock.openGroupsPage();
    }


}

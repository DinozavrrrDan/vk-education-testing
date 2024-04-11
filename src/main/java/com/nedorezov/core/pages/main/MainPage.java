package com.nedorezov.core.pages.main;

import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.nedorezov.core.pages.main.MainPageInfoMessages.*;

public class MainPage extends BasePage {

    private static final By mainPageFeed =
            By.xpath(".//*[contains(@class, 'main-feed portlet')]");
    private static final By mainPageBlockOfAlternativeContent =
            By.xpath(".//*[contains(@class, 'alternative-content-block')]");
    private static final By groupsButtonInNavigationBlock =
            By.xpath(".//*[@data-l='t,userAltGroup' and contains(@class, 'nav-side_i')]");
    private static final By myUserPageButtonInNavigationBlock =
            By.xpath(".//*[@data-l='t,userPage' and contains(@class, 'nav-side_i')]");
    private static final By myUserPageNameInNavigationBlock =
            By.xpath(".//*[@data-l='t,userPage' and contains(@class, 'nav-side_i')]/div[@class='tico ellip']");


    public MainPage() {
        super(List.of(mainPageFeed, mainPageBlockOfAlternativeContent));
    }

    public void openGroupsPageFromNavigationBlock() {
        $(groupsButtonInNavigationBlock)
                .shouldBe(visible.because(NOT_VISIBLE_GROUP_BUTTON_ON_NAVIGATION_PANEL))
                .click();
    }

    public void openMyUserPageFromNavigationBlock() {
        $(myUserPageButtonInNavigationBlock)
                .shouldBe(visible.because(NOT_VISIBLE_MY_USERNAME_BUTTON_ON_NAVIGATION_PANEL))
                .click();
    }

    public String getUserNameFromNavigationBlock() {
        return $(myUserPageNameInNavigationBlock)
                .shouldBe(visible.because(NOT_VISIBLE_USERNAME_ON_NAVIGATION_PANEL))
                .getText();
    }
}

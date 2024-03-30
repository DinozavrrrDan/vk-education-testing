package com.nedorezov.core;

import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final SelenideElement mainPageFeed =
            $(By.xpath(".//*[contains(@class, 'main-feed portlet')]"));
    private static final SelenideElement mainPageBlockOfAlternativeContent =
            $(By.xpath(".//*[contains(@class, 'alternative-content-block')]"));
    private static final SelenideElement groupsButtonInNavigationBlock =
            $(By.xpath(".//*[@data-l='t,userAltGroup' and contains(@class, 'nav-side_i')]"));
    private static final SelenideElement userPageNameInNavigationBlock =
            $(By.xpath(".//*[@data-l='t,userPage' and contains(@class, 'nav-side_i')]/div[@class='tico ellip']"));

    public MainPage() {
        super(List.of(mainPageFeed, mainPageBlockOfAlternativeContent));
    }

    public void openGroupsPageFromNavigationBlock() {
        groupsButtonInNavigationBlock.shouldBe(visible).click();
    }

    public String getUserNameFromNavigationBlock() {
        return userPageNameInNavigationBlock.shouldBe(visible).getText();
    }
}

package com.nedorezov.core.pages.groups;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.nedorezov.core.pages.groups.GroupsPageInfoMessages.*;

public class GroupsPage extends BasePage {
    private static final By searchGroupField =
            By.xpath(".//input[@type='search']");
    private static final By allGroupsOnRecommendedGroupsPage =
            By.xpath(".//*[@data-l='groupCard,POPULAR_GROUPS.popularTop']");
    private static final By groupCatalogHeader =
            By.xpath(".//*[@class='groups-catalog-header']");
    private static final By groupCatalog =
            By.xpath(".//*[@class='portlet groups-catalog']");
    private static final By goToGroupButton =
            By.xpath(".//*[contains(@class, 'group-main-layer-content_top_ac')]/a[text()='Перейти']");
    private static final By groupName =
            By.xpath(".//*[@class='group-detailed-card_name']");
    private static final By groupPhotoBlock =
            By.xpath(".//*[@data-l='t,visit']");


    public GroupsPage() {
        super(List.of(groupCatalogHeader, groupCatalog));
    }

    public String searchForGroup(String groupName) {
        $(searchGroupField).shouldBe(visible.because(NOT_VISIBLE_GROUP_SEARCH_FIELD))
                .setValue(groupName);
        $(searchGroupField).shouldBe(visible.because(NOT_VISIBLE_GROUP_SEARCH_FIELD))
                .sendKeys(Keys.ENTER);
        return getNameOfFirstGroupOnGroupsPage();
    }

    private String getGroupName(SelenideElement group) {
        return group.find(groupName).shouldBe(visible.because(NOT_VISIBLE_GROUP))
                .getText();
    }

    public String getNameOfFirstGroupOnGroupsPage() {
        return getGroupName($$(allGroupsOnRecommendedGroupsPage)
                .shouldHave(CollectionCondition.sizeGreaterThan(0).because(NOT_FOUND_GROUPS_ON_PAGE))
                .first().shouldBe(visible.because(NOT_VISIBLE_GROUP)));
    }

    public void navigateToGroup(String groupName) {
        $$(allGroupsOnRecommendedGroupsPage).findBy(text(groupName)).shouldBe(visible.because(NOT_VISIBLE_GROUP))
                .find(groupPhotoBlock).shouldBe(visible.because(NOT_VISIBLE_GROUP_PHOTO))
                .click();
        $(goToGroupButton).shouldBe(visible.because(NOT_VISIBLE_GO_TO_GROUP_BUTTON)).click();
    }


}

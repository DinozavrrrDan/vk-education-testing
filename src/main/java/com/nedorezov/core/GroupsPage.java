package com.nedorezov.core;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GroupsPage extends BasePage {
    private static final SelenideElement searchGroupField =
            $(By.xpath(".//input[@type='search']"));
    private static final ElementsCollection allGroupsOnRecommendedGroupsPage =
            $$(By.xpath(".//*[@data-l='groupCard,POPULAR_GROUPS.popularTop']"));
    private static final SelenideElement groupCatalogHeader =
            $(By.xpath(".//*[@class='groups-catalog-header']"));
    private static final SelenideElement groupCatalog =
            $(By.xpath(".//*[@class='portlet groups-catalog']"));
    private static final SelenideElement goToGroupButton =
            $(By.xpath(".//*[contains(@class, 'group-main-layer-content_top_ac')]/a[text()='Перейти']"));
    private static final By groupName =
            By.xpath(".//*[@class='group-detailed-card_name']");
    private static final By groupPhotoBlock =
            By.xpath(".//*[@data-l='t,visit']");

    public GroupsPage() {
        super(List.of(groupCatalogHeader, groupCatalog));
    }

    public String searchForGroup(String groupName) {
        searchGroupField.shouldBe(visible).setValue(groupName);
        searchGroupField.shouldBe(visible).sendKeys(Keys.ENTER);
        return getNameOfFirstGroupOnGroupsPage();
    }

    public String getGroupName(SelenideElement group) {
        return group.find(groupName).getText();
    }

    public String getNameOfFirstGroupOnGroupsPage() {
        return getGroupName(allGroupsOnRecommendedGroupsPage
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .first());
    }

    public void navigateToGroup(String groupName) {
        allGroupsOnRecommendedGroupsPage.findBy(text(groupName))
                .find(groupPhotoBlock)
                .shouldBe(visible).click();
        goToGroupButton.shouldBe(visible).click();
    }


}

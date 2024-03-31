package com.nedorezov.core;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage {

    private static final SelenideElement groupFeedList =
            $(By.xpath(".//*[contains(@class, 'feed-list')]"));
    private static final SelenideElement groupHeaderBlock =
            $(By.xpath(".//*[@id='hook_Block_AltGroupHeader']"));
    private static final SelenideElement groupColumnBlock =
            $(By.xpath(".//*[@class='layout-sticky-column']"));
    private static final SelenideElement groupNameFromHeaderBlock =
            $(By.xpath(".//*[@class='group-name_h']"));
    private static final String NOT_VISIBLE_GROUP_NAME = "Название группы не отображается.";

    public GroupPage() {
        super(List.of(groupFeedList, groupHeaderBlock, groupColumnBlock));
    }

    public String getGroupName() {
        return groupNameFromHeaderBlock.shouldBe(visible.because(NOT_VISIBLE_GROUP_NAME)).getText();
    }

}

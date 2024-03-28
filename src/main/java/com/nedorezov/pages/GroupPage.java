package com.nedorezov.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage {
    private final SelenideElement searchGroupField = $(By.xpath("//*[@id=\"hook_Block_UserGroupSearch2QueryBlock\"]/group-search-input/div/div/div/label/input"));
    private final SelenideElement firstGroupOnPage = $(By.xpath("/html/body/div[10]/div[5]/div[4]/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[2]/main/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a"));

    public GroupPage(String pageUrl) {
        super(pageUrl);
    }

    public String searchForGroup(String groupName) {
        searchGroupField.shouldBe(visible).setValue(groupName);
        searchGroupField.shouldBe(visible).sendKeys(Keys.ENTER);
        return firstGroupOnPage.getText();
    }

    public String getRandomGroupName() {
        return firstGroupOnPage.getText();
    }

}

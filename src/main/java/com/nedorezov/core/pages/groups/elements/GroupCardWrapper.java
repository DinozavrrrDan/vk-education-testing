package com.nedorezov.core.pages.groups.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class GroupCardWrapper {

    private final SelenideElement item;
    private static final By ITEM_PICTURE = By.xpath(".//*[@class='photo_img']");

    private static final By GROUP_NAME =
            By.xpath(".//*[@class='group-detailed-card_name']");

    public GroupCardWrapper(SelenideElement item) {
        this.item = item;
    }

    public PopUpGroupLayer clickOnGroupCard() {
        item.hover()
                .find(ITEM_PICTURE)
                .shouldBe(visible.because("Нет элемента с картинкой группы"))
                .click();
        return new PopUpGroupLayer();
    }

    public String getGroupName() {
        return item.hover().
                find(GROUP_NAME).shouldBe(visible.because("Не отображается группа."))
                .getText();
    }
}

package com.nedorezov.core.pages.groups.elements;

import com.nedorezov.core.pages.group.GroupPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PopUpGroupLayer {
    private static final By GO_TO_GROUP_BUTTON =
            By.xpath(".//*[contains(@class, 'group-main-layer-content_top_ac')]/a[text()='Перейти']");

    public GroupPage navigateToGroupPage() {
        $(GO_TO_GROUP_BUTTON)
                .shouldBe(visible.because("Не отображается кнопка перехода в группу."))
                .click();
        return new GroupPage();
    }

}

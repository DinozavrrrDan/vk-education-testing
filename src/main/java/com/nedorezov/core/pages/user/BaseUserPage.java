package com.nedorezov.core.pages.user;

import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseUserPage extends BasePage {

    private static final By userHeaderBlock = By.xpath(".//*[@data-module='MainContentHeader' and @data-l='t,main-content-header']");
    private static final By userFeed = By.xpath(".//*[@class='user-feed']");
    private static final By blockAboutUser = By.xpath(".//*[@id='hook_Block_AboutUserRB']");

    protected BaseUserPage(List<By> requiredPageElements) {
//        super(createListOfRequiredPageElements(requiredPageElements));
    }

    private static List<By> createListOfRequiredPageElements(List<By> requiredPageElements) {
        List<By> list = new ArrayList<>(List.of(userHeaderBlock, userFeed, blockAboutUser));
        list.addAll(requiredPageElements);
        return list;
    }

}

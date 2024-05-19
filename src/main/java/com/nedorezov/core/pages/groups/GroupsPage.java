package com.nedorezov.core.pages.groups;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.BasePage;
import com.nedorezov.core.pages.group.GroupPage;
import com.nedorezov.core.pages.groups.elements.GroupCardWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GroupsPage extends BasePage {
    private static final By SEARCH_GROUP_FIELD =
            By.xpath(".//input[@type='search']");
    private static final By GROUPS_CARDS =
            By.xpath(".//*[@data-l='groupCard,POPULAR_GROUPS.popularTop']");
    private static final By GROUP_CATALOG_HEADER =
            By.xpath(".//*[@class='groups-catalog-header']");
    private static final By GROUP_CATALOG =
            By.xpath(".//*[@class='portlet groups-catalog']");
    private static final By USER_GROUPS_BLOCK =
            By.xpath(".//*[contains(@id, 'UserGroupsBlock')]");


    public GroupsPage() {
        check();
    }

    public boolean check() {
        $(GROUP_CATALOG_HEADER)
                .shouldBe(visible.because("Не видно хедр каталога групп."));
        $(GROUP_CATALOG)
                .shouldBe(visible.because("Не видно каталог групп."));
        return true;
    }

    public String searchForGroup(String groupName) {
        $(SEARCH_GROUP_FIELD).shouldBe(visible.because("Не отображается поле поиска группы."))
                .setValue(groupName);
        $(SEARCH_GROUP_FIELD).shouldBe(visible.because("Не отображается поле поиска группы."))
                .sendKeys(Keys.ENTER);
        return getNameOfFirstGroupOnGroupsPage();
    }

    public String getNameOfFirstGroupOnGroupsPage() {
        return getFirstGroupCardWrapper().getGroupName();
    }

    public GroupPage navigateToGroup(String groupName) {
        return findGroupByName(groupName).
                clickOnGroupCard().
                navigateToGroupPage();
    }

    public ElementsCollection getGroupCardCollection() {
        return $(USER_GROUPS_BLOCK)
                .shouldBe(visible.because("Не отображаеься меню с карточками групп."))
                .$$(GROUPS_CARDS)
                .shouldHave(CollectionCondition.sizeGreaterThan(0)
                        .because("Не найдено ни одной группы"));
    }


    public GroupCardWrapper getFirstGroupCardWrapper() {
        SelenideElement group = getGroupCardCollection()
                .first()
                .shouldBe(visible.because("Не отображается группа."));
        return new GroupCardWrapper(group);
    }

    public GroupCardWrapper findGroupByName(String groupName) {
        SelenideElement group = getGroupCardCollection()
                .findBy(text(groupName))
                .shouldBe(visible.because("Не отображается группа."));
        return new GroupCardWrapper(group);
    }


}

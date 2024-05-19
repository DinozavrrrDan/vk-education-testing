package com.nedorezov.core.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.pages.groups.GroupsPage;
import com.nedorezov.core.pages.user.myUser.MyUserPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NavigationMenuWrapper {

    private static final By navigationMenu =
            By.xpath(".//*[contains(@class, 'nav-side')]");
    private static final By groupsButtonInNavigationBlock =
            By.xpath(".//*[@data-l='t,userAltGroup' and contains(@class, 'nav-side_i')]");

    private static final By myUserPageButtonInNavigationBlock =
            By.xpath(".//*[@data-l='t,userPage' and contains(@class, 'nav-side_i')]");
    private static final By myUserPageNameInNavigationBlock =
            By.xpath(".//*[@data-l='t,userPage' and contains(@class, 'nav-side_i')]/div[@class='tico ellip']");

    public NavigationMenuWrapper() {
        check();
    }

    public boolean check() {
        $(navigationMenu)
                .shouldBe(visible.because("Не видно бокового навигационного меню"));
        return true;
    }

    public GroupsPage openGroupsPage() {
        $(groupsButtonInNavigationBlock)
                .shouldBe(visible.because("Не отображается кнопка \"Группы\" на боковой навигационной панели."))
                .click();
        return new GroupsPage();
    }

    public MyUserPage openMyUserPage() {
        $(myUserPageButtonInNavigationBlock)
                .shouldBe(visible.because("Не отображается кнопка с именем пользователя на боковой навигационной панели."))
                .click();
        return new MyUserPage();
    }

    public String getUserName() {
        return $(myUserPageNameInNavigationBlock)
                .shouldBe(visible.because("Не отображается имя пользователя на боковой навигационной панели."))
                .getText();
    }
}

package com.nedorezov.tests.groups;

import com.nedorezov.core.pages.group.GroupPage;
import com.nedorezov.core.pages.groups.GroupsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigateToGroupPageFromGroupsPageTest extends GroupsPageBaseTest {

    @Test
    @Tag("groups")
    @DisplayName("Navigate to group page from groups page test")
    @Timeout(value = 120)
    public void testNavigateToGroupPageFromGroupsPage() {
        GroupsPage groupsPage = new GroupsPage();
        String findGroupName = groupsPage.getNameOfFirstGroupOnGroupsPage();
        groupsPage.navigateToGroup(findGroupName);

        GroupPage groupPage = new GroupPage();

        assertEquals(groupPage.getGroupName(), findGroupName,
                "Имя группы в которую необходимо перейти не совпало с ожидаемым.");
    }
}

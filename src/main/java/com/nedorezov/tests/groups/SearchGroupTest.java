package com.nedorezov.tests.groups;

import com.nedorezov.core.pages.groups.GroupsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchGroupTest extends GroupsPageBaseTest {

    @Test
    @Tag("groups")
    @DisplayName("Search group test")
    @Timeout(value = 120)
    public void testSearchingGroup() {
        GroupsPage groupsPage = new GroupsPage();
        String findGroupName = groupsPage.getNameOfFirstGroupOnGroupsPage();
        assertEquals(findGroupName, groupsPage.searchForGroup(findGroupName),
                "При поиске группы ожидаемое и полученное название не совпали.");
    }

}

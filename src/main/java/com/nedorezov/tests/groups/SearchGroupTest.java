package com.nedorezov.tests.groups;

import com.nedorezov.core.pages.groups.GroupsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchGroupTest extends GroupsPageBaseTest {
    private static final String ASSERTION_FAIL_MESSAGE = "При поиске группы ожидаемое и полученное название не совпали.";

    @Test
    @Tag("groups")
    @DisplayName("Search group test")
    public void testSearchingGroup() {
        GroupsPage groupsPage = new GroupsPage();
        String findGroupName = groupsPage.getNameOfFirstGroupOnGroupsPage();
        assertEquals(findGroupName, groupsPage.searchForGroup(findGroupName), ASSERTION_FAIL_MESSAGE);
    }

}

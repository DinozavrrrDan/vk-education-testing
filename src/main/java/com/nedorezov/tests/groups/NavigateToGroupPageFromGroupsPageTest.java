package com.nedorezov.tests.groups;

import com.nedorezov.core.GroupPage;
import com.nedorezov.core.GroupsPage;
import com.nedorezov.core.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigateToGroupPageFromGroupsPageTest extends GroupsPageBaseTest {

    private static final String ASSERTION_FAIL_MESSAGE =
            "Имя группы в которую необходимо перейти не совпало с ожидаемым.";

    @Test
    public void testNavigateToGroupPageFromGroupsPage() {
        GroupsPage groupsPage = new GroupsPage();
        String findGroupName = groupsPage.getNameOfFirstGroupOnGroupsPage();
        groupsPage.navigateToGroup(findGroupName);

        GroupPage groupPage = new GroupPage();

        assertEquals(groupPage.getGroupName(), findGroupName, ASSERTION_FAIL_MESSAGE);
    }
}

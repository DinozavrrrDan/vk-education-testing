package com.nedorezov.suits;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All test with \"groups\" tag.")
@SelectPackages("com.nedorezov.tests")
@IncludeTags("groups")
public class AllUnitGroupsTest {
}

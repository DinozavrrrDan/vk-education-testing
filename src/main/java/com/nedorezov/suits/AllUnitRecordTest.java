package com.nedorezov.suits;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All test with \"records\" tag.")
@SelectPackages("com.nedorezov.tests")
@IncludeTags("records")
public class AllUnitRecordTest {
}

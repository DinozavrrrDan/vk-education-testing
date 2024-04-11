package com.nedorezov.tests.record;

import com.nedorezov.core.pages.records.RecordsPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublishRecordTest extends RecordBaseTest {

    public static final String ASSERTION_FAIL_MESSAGE =
            "При создании записи ожидаемый и полученный текст записи не совпали.";

    @ParameterizedTest(name = "Test publishing new record")
    @ValueSource(strings = {"text1", "текст1"})
    @Tag("records")
    public void publishingRecordTest(String text) {
        RecordsPage recordsPage = new RecordsPage();
        recordsPage.publishRecord(text);

        assertEquals(text, recordsPage.getLastRecordText(), ASSERTION_FAIL_MESSAGE);

        recordsPage.deleteLastRecord();
    }


}

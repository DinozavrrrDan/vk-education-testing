package com.nedorezov.tests.record;

import com.nedorezov.core.pages.records.RecordsPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublishRecordTest extends RecordBaseTest {

    @ParameterizedTest(name = "Test publishing new record")
    @ValueSource(strings = {"text1", "текст1"})
    @Tag("records")
    @Timeout(value = 120)
    public void publishingRecordTest(String text) {
        RecordsPage recordsPage = new RecordsPage();
        recordsPage.publishRecord(text);

        assertEquals(text, recordsPage.getLastRecordText(),
                "При создании записи ожидаемый и полученный текст записи не совпали.");

        recordsPage.deleteLastRecord();
    }


}

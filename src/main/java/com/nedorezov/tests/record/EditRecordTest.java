package com.nedorezov.tests.record;

import com.nedorezov.core.pages.records.RecordsPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditRecordTest extends RecordBaseTest {

    @ParameterizedTest(name = "Test editing record")
    @MethodSource("editingRecordParameters")
    @Tag("records")
    @Timeout(value = 120)
    public void editingRecordTest(String text, String editText) {
        RecordsPage recordsPage = new RecordsPage();
        recordsPage.publishRecord(text)
                .editLastRecord(editText)
                .refreshPage();

        assertEquals(editText, recordsPage.getLastRecordText(), "При изменении записи ожидаемый и полученный текст записи не совпали.");

        recordsPage.deleteLastRecord();
    }

    static Stream<Arguments> editingRecordParameters() {
        return Stream.of(
                Arguments.of("text1", "edit text1"),
                Arguments.of("текст1", "измененный текст1")
        );
    }
}

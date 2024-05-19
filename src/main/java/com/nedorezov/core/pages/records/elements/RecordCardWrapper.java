package com.nedorezov.core.pages.records.elements;

import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.pages.records.RecordsOption;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.nedorezov.core.pages.records.RecordsOption.DELETE;
import static com.nedorezov.core.pages.records.RecordsOption.EDIT;

public class RecordCardWrapper {
    private final SelenideElement item;
    private static final By RECORD_TEXT_FIELD =
            By.xpath(".//*[@class='media-text_cnt']");

    private static final By INPUT_TEXT_FIELD_IN_PUBLISH_RECORD_MENU =
            By.xpath(".//*[@data-module='postingForm/mediaText']/div");

    private static final By RECORD_SAVE_BUTTON =
            By.xpath(".//*[@title='Сохранить']");
    private static final By RECORD_OPTION_BUTTON =
            By.xpath(".//*[@class='feed_menu_ic']");

    private static final By RECORD_OPTION_MENU =
            By.xpath(".//*[contains(@class,'u-menu_li')]");

    public RecordCardWrapper(SelenideElement item) {
        this.item = item;
    }

    public String getRecordText() {
        return item.hover().
                find(RECORD_TEXT_FIELD).shouldBe(visible.because("Не текст записи."))
                .getText();
    }

    public void deleteRecord() {
        doRecordOption(DELETE);
    }

    public void editRecord(String textForEditing) {
        doRecordOption(EDIT);
        $(INPUT_TEXT_FIELD_IN_PUBLISH_RECORD_MENU).shouldBe(visible.because("Не отображается поле ввода текста записи."))
                .setValue(textForEditing);
        $(RECORD_SAVE_BUTTON).shouldBe(visible.because("Не отображается кнопка \"Сохранить\" в форме создания записи"))
                .click();

    }

    private void doRecordOption(RecordsOption option) {
        item.hover().find(RECORD_OPTION_BUTTON).shouldBe(visible.because("Не отображается кнопка с настройками записи"))
                .click();
        $$(RECORD_OPTION_MENU)
                .findBy(text(option.getOption())).shouldBe(visible.because("В настройках записи не отображается кнопка:" + option))
                .click();
    }
}

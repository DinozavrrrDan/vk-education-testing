package com.nedorezov.core.pages.records;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.BasePage;
import com.nedorezov.core.pages.records.elements.RecordCardWrapper;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.nedorezov.core.pages.records.RecordsOption.DELETE;
import static com.nedorezov.core.pages.records.RecordsOption.EDIT;

public class RecordsPage extends BasePage {

    private static final By createRecordForm =
            By.xpath(".//*[@id='hook_Block_PostingForm']");
    private static final By recordsMainFeed =
            By.xpath(".//*[contains(@class, 'media_feed')]");
    private static final By recordsFeed =
            By.xpath(".//*[@class='feed']");
    private static final By recordTopicDisplay =
            By.xpath(".//*[@id='hook_Block_MediaTopicDisplayTypeFilter']");


    private static final By RECORD_DELETE_INFO =
            By.xpath(".//*[contains(@class,'delete-stub_info')]");
    private static final By inputTextFieldInPublishRecordMenu =
            By.xpath(".//*[@data-module='postingForm/mediaText']/div");
    private static final By recordShareButton =
            By.xpath(".//*[contains(@class, 'posting_submit') and text()='Поделиться']");


    private static final By closeRecordButton =
            By.xpath(".//*[contains(@class, 'close-button-icon')]");

    public RecordsPage() {
        check();
    }

    public boolean check() {
        $(createRecordForm)
                .shouldBe(visible.because("Не отображается форма создания записи."));
        $(recordsMainFeed)
                .shouldBe(visible.because("Не отображается фид."));
        $(recordTopicDisplay)
                .shouldBe(visible.because("Не отображается дисплей записей."));
        return true;
    }

    public RecordsPage publishRecord(String text) {
        $(createRecordForm).shouldBe(visible.because("Не отображается форма создания записи."))
                .click();
        $(inputTextFieldInPublishRecordMenu)
                .shouldBe(visible.because("Не отображается поле ввода текста записи."))
                .shouldBe(empty.because("Поле ввода текста должно быть пустым"))
                .setValue(text);
        $(recordShareButton).shouldBe(visible.because("Не отображается кнопка \"Поделиться\" в форме создания записи"))
                .click();
        return this;
    }

    public String getLastRecordText() {
        return getLastRecordWrapper().getRecordText();
    }

    private RecordCardWrapper getLastRecordWrapper() {
        SelenideElement record = getGroupCardCollection()
                .first().shouldBe(visible.because("Не отображается полследняя запись на странице"));
        return new RecordCardWrapper(record);
    }

    public RecordsPage deleteLastRecord() {
        getLastRecordWrapper().deleteRecord();
        $(RECORD_DELETE_INFO).shouldBe(visible.because("Не отображается всплывающие поле \"Запись удалена\""));
        return this;
    }

    public RecordsPage editLastRecord(String textForEditing) {
        getLastRecordWrapper().editRecord(textForEditing);
        refreshPage();
        $(closeRecordButton).shouldBe(visible.because("Не отображается кнопка ( крестик ) для закрытия записи."))
                .click();
        return this;
    }

    public ElementsCollection getGroupCardCollection() {
        return $$(recordsFeed)
                .shouldHave(
                        CollectionCondition.sizeGreaterThan(0)
                                .because("Не найдено ни одной записи на странице."));
    }


}

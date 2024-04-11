package com.nedorezov.core.pages.records;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.nedorezov.core.BasePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.nedorezov.core.pages.records.RecordsPageInfoMessages.*;
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
    private static final By recordOptionButton =
            By.xpath(".//*[@class='feed_menu_ic']");
    private static final By recordOptionMenu =
            By.xpath(".//*[contains(@class,'u-menu_li')]");
    private static final By recordDeleteInfo =
            By.xpath(".//*[contains(@class,'delete-stub_info')]");
    private static final By inputTextFieldInPublishRecordMenu =
            By.xpath(".//*[@data-module='postingForm/mediaText']/div");
    private static final By recordShareButton =
            By.xpath(".//*[contains(@class, 'posting_submit') and text()='Поделиться']");
    private static final By recordSaveButton =
            By.xpath(".//*[@title='Сохранить']");
    private static final By recordTextField =
            By.xpath(".//*[@class='media-text_cnt']");
    private static final By closeRecordButton =
            By.xpath(".//*[contains(@class, 'svg-ico_close_thin_16 media-layer_close_ico-svg')]");

    public RecordsPage() {
        super(List.of(createRecordForm, recordsMainFeed, recordTopicDisplay));
    }

    public void publishRecord(String text) {
        $(createRecordForm).shouldBe(visible.because(NOT_VISIBLE_CREATION_RECORD_FORM))
                .click();
        $(inputTextFieldInPublishRecordMenu)
                .shouldBe(visible.because(NOT_VISIBLE_INPUT_FIELD_IN_RECORD))
                .shouldBe(empty.because(INPUT_TEXT_FIELD_SHOULD_BE_EMPTY))
                .setValue(text);
        $(recordShareButton).shouldBe(visible.because(NOT_VISIBLE_SHARE_BUTTON))
                .click();
    }

    public String getLastRecordText() {
        return getLastRecord()
                .find(recordTextField).shouldBe(visible.because(NOT_VISIBLE_RECORD_TEXT_FIELD))
                .getText();
    }

    private static SelenideElement getLastRecord() {
        return $$(recordsFeed)
                .shouldHave(CollectionCondition.sizeGreaterThan(0).because(NOT_FOUND_RECORDS_ON_PAGE))
                .first().shouldBe(visible.because(NOT_VISIBLE_LAST_RECORD));
    }

    public void deleteLastRecord() {
        openRecordOption(DELETE);
        $(recordDeleteInfo).shouldBe(visible.because(NOT_VISIBLE_RECORD_DELETE_BUTTON));
    }

    public void editLastRecord(String textForEditing) {
        openRecordOption(EDIT);
        $(inputTextFieldInPublishRecordMenu).shouldBe(visible.because(NOT_VISIBLE_INPUT_FIELD_IN_RECORD))
                .setValue(textForEditing);
        $(recordSaveButton).shouldBe(visible.because(NOT_VISIBLE_SAVE_BUTTON))
                .click();

        refreshPage();

        $(closeRecordButton).shouldBe(visible.because(NOT_VISIBLE_CLOSE_RECORD_BUTTON))
                .click();
    }

    private static void openRecordOption(RecordsOption option) {
        getLastRecord().find(recordOptionButton).shouldBe(visible.because(NOT_VISIBLE_OPTION_RECORD_BUTTON))
                .click();
        $$(recordOptionMenu)
                .findBy(text(option.getOption())).shouldBe(visible.because(NOT_VISIBLE_OPTION_BUTTON + option))
                .click();
    }

}

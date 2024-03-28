package com.nedorezov.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AlbumPage extends BasePage {

    private static final SelenideElement createAlbumButton = $(By.xpath("//*[@id=\"hook_Block_PhotoVitrineBlock\"]/div/div[1]/div/div/div/div/div/span[1]/a"));
    private static final SelenideElement createAlbumNameField = $(By.xpath("//*[@id=\"hook_Form_PopLayerCreateUserAlbumForm\"]/form/div[1]/div/div[1]/div[1]/textarea"));
    private static final SelenideElement creatingAlbumSubmitButton = $(By.xpath("//*[@id=\"hook_FormButton_button_album_create\"]"));

    public AlbumPage(String pageUrl) {
        super(pageUrl);
    }

    public void createAlbum(String albumName) {
        createAlbumButton.shouldBe(visible).click();
        createAlbumNameField.shouldBe(visible).setValue(albumName);
        creatingAlbumSubmitButton.shouldBe(visible).click();
    }

}

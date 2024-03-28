package com.nedorezov.tests;

import com.codeborne.selenide.ElementsCollection;
import com.nedorezov.pages.AlbumPage;
import com.nedorezov.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.nedorezov.Config.BASE_URL;
import static com.nedorezov.Config.LOGIN;
import static com.nedorezov.Config.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumPageTest {
    private static final String PROFILE_URL = "/profile";
    private static final String ALBUMS_ID = "/albums";
    public static final String TEST_ALBUM_NAME = "Test Album";
    public static final String SLASH = "/";
    private final ElementsCollection albums = $$(By.xpath("//*[@id=\"hook_Block_PhotoVitrineAlbumsBlock\"]/div/ul/li"));

    @Test
    public void testCreateAlbum() {
        LoginPage loginPage = new LoginPage(BASE_URL);
        loginPage.open();
        String userId = loginPage.login(LOGIN, PASSWORD);

        AlbumPage albumPage = new AlbumPage(BASE_URL + PROFILE_URL + SLASH + userId + ALBUMS_ID);
        albumPage.open();

        int sizeBeforeAddingAlbum = albums.filterBy(text(TEST_ALBUM_NAME)).size();

        albumPage.createAlbum(TEST_ALBUM_NAME);
        albumPage.open();

        int sizeAfterAddingAlbum = albums.filterBy(text(TEST_ALBUM_NAME)).size();

        assertEquals(sizeAfterAddingAlbum - 1, sizeBeforeAddingAlbum);
    }
}

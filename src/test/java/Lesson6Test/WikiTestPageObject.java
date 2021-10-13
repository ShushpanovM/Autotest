package Lesson6Test;

import Lesson6.Wiki.DraftHistoryPage;
import Lesson6.Wiki.DraftPage;
import Lesson6.Wiki.LoginPage;
import Lesson6.Wiki.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiTestPageObject {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get("https://ru.wikipedia.org/w/index.php?title=Служебная:Вход&returnto=Заглавная+страница");
    }

    @BeforeEach
    void Login() {
        new LoginPage(webDriver)
                .fillLogin("Tester9400")
                .fillPassword("@Q1w2e3r4")
                .submitLogin();
    }

    @Test
    void CheckLogin() {
        new MainPage(webDriver)
                .checkLogin();
    }

    @Test
    void CheckSearch() {
        new MainPage(webDriver)
                .searchInput()
                .searchButtonClick()
                .searchResultCheck();
    }

    @Test
    void CheckNewWriteDraft() {
        new MainPage(webDriver)
                .draftLinkClick();
        new DraftPage(webDriver)
                .editButtonClick()
                .draftTextAreaClear()
                .fillDraftTextArea("New Draft Write")
                .writeDraftButtonClick()
                .twoWriteDraftButtonClick();
    }

    @Test
    void CheckHistoryAdd() {
        new DraftHistoryPage(webDriver)
                .checkAddHistoryChange();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}

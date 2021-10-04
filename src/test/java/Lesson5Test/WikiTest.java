package Lesson5Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WikiTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    String WIKI_URL = "https://ru.wikipedia.org/w/index.php?title=Служебная:Вход&returnto=Заглавная+страница";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(WIKI_URL);
        login();
    }

    @Test
    void checkLoginTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Tester9400']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Tester9400']"))));
        String textLogin = driver.findElement(By.xpath("//a[.='Tester9400']")).getText();
        Assertions.assertEquals("Tester9400", textLogin);
    }

    @Test
    void searchTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("searchInput"))));
        driver.findElement(By.id("searchInput")).sendKeys("Geekbrains");

        driver.findElement(By.xpath("//input[@class='searchButton']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[.='GeekBrains']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//th[.='GeekBrains']"))));
        String textLogin = driver.findElement(By.xpath("//th[.='GeekBrains']")).getText();
        Assertions.assertEquals("GeekBrains", textLogin);
    }

    @Test
    void newWritingToTheDraft() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Черновик']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[.='Черновик']"))));
        driver.findElement(By.xpath("//span[.='Черновик']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("ca-ve-edit")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ca-ve-edit"))));
        driver.findElement(By.id("ca-ve-edit")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("mwAg")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("mwAg"))));
        driver.findElement(By.id("mwAg")).clear();
        driver.findElement(By.id("mwAg")).sendKeys("Hello World");

        driver.findElement(By.xpath("//a[@title='Записать страницу… Alt+Shift+S']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[.='Записать страницу']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/span[.='Записать страницу']"))));
        driver.findElement(By.xpath("//div/span[.='Записать страницу']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'postedit-content')]")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class, 'postedit-content')]"))));
        String textMessage = driver.findElement(By.xpath("//div[contains(@class, 'postedit-content')]")).getText();
        Assertions.assertEquals("Ваша правка была опубликована.", textMessage);
    }

    @Test
    void checkAddHistoryChange() {
        driver.get("https://ru.wikipedia.org/w/index.php?title=%D0%A3%D1%87%D0%B0%D1%81%D1%82%D0%BD%D0%B8%D0%BA:Tester9400/%D0%A7%D0%B5%D1%80%D0%BD%D0%BE%D0%B2%D0%B8%D0%BA&action=history");
        List<WebElement> lengthHistoryElement = driver.findElements(By.xpath("//*[@id=\"pagehistory\"]/li"));
        Assertions.assertEquals(7, lengthHistoryElement.size());
        // Очень хотелось создать переменную и добвалять к ней каждый запуск ++, но не получилось.
        // По этому прихотся в ручную перед каждым запуском !всех тестов менять значение.
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public void login() {
        WebElement element = driver.findElement(By.id("wpName1"));
        element.sendKeys("Tester9400");
        driver.findElement(By.id("wpPassword1")).sendKeys("@Q1w2e3r4");
        driver.findElement(By.xpath("//button[.='Войти']")).click();
    }
}

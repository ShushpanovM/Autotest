package Lesson3.Wiki;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
    private static WebDriver driver;
    private static final String CRM_URL = "https://ru.wikipedia.org/w/index.php?title=Служебная:Вход&returnto=Заглавная+страница";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("searchInput"))));
        driver.findElement(By.id("searchInput")).sendKeys("Geekbrains");

        driver.findElement(By.xpath("//input[@class='searchButton']")).click();
    }
}
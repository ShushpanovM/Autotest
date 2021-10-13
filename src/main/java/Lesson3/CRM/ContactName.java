package Lesson3.CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactName {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);

        login();

        //Thread.sleep(5000);

        List<WebElement> navMenuElements = driver.findElements(By.xpath("//div[@id='main-menu']/ul/li/a"));
        WebElement expenceElement = navMenuElements.stream().filter(e -> e.getText().equals("Контрагенты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expenceElement).build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать контактное лицо']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Создать контактное лицо']"))));
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_contact[lastName]")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("crm_contact[lastName]"))));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Applanatest1001");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_contact[firstName]")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("crm_contact[firstName]"))));
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Applanatest1001");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='«Все организации»']"))));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_contact[jobTitle]")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("crm_contact[jobTitle]"))));
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Tester1000");

        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();

        Thread.sleep(10000);

        driver.quit();

    }

    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}

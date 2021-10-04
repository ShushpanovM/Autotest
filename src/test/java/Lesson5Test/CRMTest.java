package Lesson5Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CRMTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    String CRM_URL = "https://crm.geekbrains.space";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(CRM_URL);
        login();
    }

    @Test
    void crmNewContractorTest() {
        List<WebElement> navMenuElements = driver.findElements(By.xpath("//div[@id='main-menu']/ul/li/a"));
        WebElement expenseElement = navMenuElements.stream().filter(e -> e.getText().equals("Контрагенты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expenseElement).build().perform();
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

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Контактное лицо сохранено']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Контактное лицо сохранено']"))));
        String textMessage = driver.findElement(By.xpath("//div[text()='Контактное лицо сохранено']")).getText();
        Assertions.assertEquals("Контактное лицо сохранено", textMessage);
    }

    @Test
    void crmNewProjectTest() {
        List<WebElement> navMenuElements = driver.findElements(By.xpath("//div[@id='main-menu']/ul/li/a"));
        WebElement expenceElement = navMenuElements.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expenceElement).build().perform();
        driver.findElement(By.xpath("//span[.='Все проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Создать проект']"))));
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_project_name')]")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]"))));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]")).sendKeys("projectTest1015");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='«Все организации»']"))));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        Select Priority = new Select(driver.findElement(By.name("crm_project[priority]")));
        Priority.selectByVisibleText("Низкий");

        Select FinanceSource = new Select(driver.findElement(By.name("crm_project[financeSource]")));
        FinanceSource.selectByVisibleText("Из средств заказчика");

        Select BusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        BusinessUnit.selectByVisibleText("Research & Development");

        Select Curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        Curator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select Rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        Rp.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select Manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        Manager.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");

        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Проект сохранен']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Проект сохранен']"))));
        String textMessage = driver.findElement(By.xpath("//div[text()='Проект сохранен']")).getText();
        Assertions.assertEquals("Проект сохранен", textMessage);
    }

    @AfterEach
        void tearDown() {
            driver.quit();
        }

    public void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}

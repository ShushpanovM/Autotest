package Lesson6Test;

import Lesson6.CRM.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMTestPageObject {
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
        webDriver.get("https://crm.geekbrains.space/");
    }

    @BeforeEach
    void Login() {
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
    }

    @Test
    void newContractorTest() {
        new MainPage(webDriver).navigationMenu.openNavigationSubMenuItems("Контрагенты");
        new NewContractorSubMenu(webDriver)
                .newContractorButtonClick()
                .createNewContractorButtonClick();

        new CreateNewContractorPage(webDriver)
                .fillLastName("Applanatest1001")
                .fillFirstName("Applanatest1001")
                .selectSpecifyOrganization()
                .selectAllOrganization()
                .fillJobTitle("Tester1000")
                .saveAndCloseButtonClick();

        webDriverWait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//div[@class='loader-frame well']"))));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//div[text()='Контактное лицо сохранено']")).isDisplayed());
    }

    @Test
    void newProject() {
        new MainPage(webDriver).navigationMenu.openNavigationSubMenuItems("Проекты");
        new NewProjectSubMenu(webDriver)
                .newProjectSubMenuButtonClick()
                .createNewProjectButtonClick();

        new CreateNewProjectPage(webDriver)
                .fillProjectName("projectTest1019")
                .selectSpecifyOrganization()
                .selectAllOrganization()
                .selectProjectPriority("Низкий")
                .selectFinanceSource("Из средств заказчика")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectRp("Applanatest1 Applanatest1 Applanatest1")
                .selectManager("Applanatest2 Applanatest2 Applanatest2")
                .saveAndCloseButtonClick();

        webDriverWait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//div[@class='loader-frame well']"))));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//div[text()='Проект сохранен']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}

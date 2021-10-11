package Lesson6.Wiki;

import Lesson6.CRM.CreateNewContractorPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[.='Tester9400']")
    public WebElement nameLogin;

    public MainPage checkLogin() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Tester9400']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(nameLogin));
        String textLogin = webDriver.findElement(By.xpath("//a[.='Tester9400']")).getText();
        Assertions.assertEquals("Tester9400", textLogin);
        return this;
    }

    @FindBy(id = "searchInput")
    public WebElement searchInputArea;

    public MainPage searchInput() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));
        webDriverWait.until(ExpectedConditions.visibilityOf(searchInputArea));
        searchInputArea.sendKeys("Geekbrains");
        return this;
    }

    @FindBy(xpath = "//input[@class='searchButton']")
    public WebElement searchButton;

    public MainPage searchButtonClick() {
        searchButton.click();
        return this;
    }

    @FindBy(xpath = "//th[.='GeekBrains']")
    public WebElement searchResult;

    public MainPage searchResultCheck() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[.='GeekBrains']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//th[.='GeekBrains']"))));
        String textSearch = webDriver.findElement(By.xpath("//th[.='GeekBrains']")).getText();
        Assertions.assertEquals("GeekBrains", textSearch);
        return this;
    }

    @FindBy(xpath = "//span[.='Черновик']")
    public WebElement draftLink;

    public void draftLinkClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Черновик']")));
        draftLink.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(DraftPage.editButtonCSSLocator)));
    }

}

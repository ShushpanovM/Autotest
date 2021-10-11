package Lesson6.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewProjectPage extends BaseView {
    public NewProjectPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = createNewProjectButtonXpathLocator)
    public WebElement createNewProjectButton;

    public void createNewProjectButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createNewProjectButtonXpathLocator)));
        createNewProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateNewProjectPage.projectNameXpathSelector)));
    }

    final static String createNewProjectButtonXpathLocator = "//a[.='Создать проект']";
}

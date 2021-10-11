package Lesson6.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContractorPage extends BaseView {
    public NewContractorPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = createNewContractorButtonXpathLocator)
    public WebElement createNewContractorButton;

    public void createNewContractorButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createNewContractorButtonXpathLocator)));
        createNewContractorButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(CreateNewContractorPage.contractorLastNameCSSLocator)));
    }

    final static String createNewContractorButtonXpathLocator = "//a[.='Создать контактное лицо']";
}

package Lesson6.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewContractorPage extends BaseView {
    public CreateNewContractorPage(WebDriver webDriver) {
        super(webDriver);
    }

    final static String contractorLastNameCSSLocator = "crm_contact[lastName]";
    @FindBy(name = contractorLastNameCSSLocator)
    public WebElement contractorLastName;

    public CreateNewContractorPage fillLastName(String lastName) {
        contractorLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement contractorFirstName;

    public CreateNewContractorPage fillFirstName(String firstName) {
        contractorFirstName.sendKeys(firstName);
        return this;
    }


    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement selectSpecifyOrganization;

    public CreateNewContractorPage selectSpecifyOrganization() {
        selectSpecifyOrganization.click();
        return this;
    }

    @FindBy(xpath = "//div[text()='«Все организации»']")
    public WebElement selectAllOrganization;

    public CreateNewContractorPage selectAllOrganization() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//div[text()='«Все организации»']"))));
        selectAllOrganization.click();
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement contractorJobTitle;

    public CreateNewContractorPage fillJobTitle(String jobTitle) {
        contractorJobTitle.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = "//button[contains(., 'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    public CreateNewContractorPage saveAndCloseButtonClick() {
        saveAndCloseButton.click();
        return this;
    }
}

package Lesson6.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjectPage extends BaseView {
    public CreateNewProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    final static String projectNameXpathSelector = "//input[contains(@id, 'crm_project_name')]";
    @FindBy(xpath = projectNameXpathSelector)
    public WebElement projectName;

    public CreateNewProjectPage fillProjectName(String ProjectName) {
        projectName.sendKeys(ProjectName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement selectSpecifyOrganization;

    public CreateNewProjectPage selectSpecifyOrganization() {
        selectSpecifyOrganization.click();
        return this;
    }

    @FindBy(xpath = "//div[text()='«Все организации»']")
    public WebElement selectAllOrganization;

    public CreateNewProjectPage selectAllOrganization() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//div[text()='«Все организации»']"))));
        selectAllOrganization.click();
        return this;
    }

    @FindBy(name = "crm_project[priority]")
    public WebElement projectPriority;

    public CreateNewProjectPage selectProjectPriority(String option) {
        new Select(projectPriority).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[financeSource]")
    public WebElement financeSource;

    public CreateNewProjectPage selectFinanceSource(String option) {
        new Select(financeSource).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnit;

    public CreateNewProjectPage selectBusinessUnit(String option) {
        new Select(businessUnit).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curator;

    public CreateNewProjectPage selectCurator(String option) {
        new Select(curator).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rp;

    public CreateNewProjectPage selectRp(String option) {
        new Select(rp).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement manager;

    public CreateNewProjectPage selectManager(String option) {
        new Select(manager).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//button[contains(., 'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    public CreateNewProjectPage saveAndCloseButtonClick() {
        saveAndCloseButton.click();
        return this;
    }

}

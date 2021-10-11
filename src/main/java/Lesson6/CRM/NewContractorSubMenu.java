package Lesson6.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContractorSubMenu extends BaseView {
    @FindBy(xpath = "//span[.='Контактные лица']")
    public WebElement createNewContractorButton;

    public NewContractorSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public NewContractorPage newContractorButtonClick() {
        createNewContractorButton.click();
        return new NewContractorPage(webDriver);
    }
}

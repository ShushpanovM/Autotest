package Lesson6.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProjectSubMenu extends BaseView {
    @FindBy(xpath = "//span[.='Все проекты']")
    public WebElement createNewProjectButton;

    public NewProjectSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public NewProjectPage newProjectSubMenuButtonClick() {
        createNewProjectButton.click();
        return new NewProjectPage(webDriver);
    }
}

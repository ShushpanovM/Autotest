package Lesson6.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenu extends BaseView {
    NewContractorSubMenu newContractorSubMenu;

    public NavigationMenu(WebDriver webDriver) {
        super(webDriver);
        newContractorSubMenu = new NewContractorSubMenu(webDriver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
    public List<WebElement> navigationMenuItems;

    public NewContractorSubMenu openNavigationSubMenuItems(String menuName) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(navigationMenuItems.stream().filter(element -> element.getText().equals(menuName))
                .findFirst().get()).build().perform();
        return new NewContractorSubMenu(webDriver);
    }
}

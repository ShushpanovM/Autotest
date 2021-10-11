package Lesson6.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {
    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonLogin;

    public WebElement test;

    public LoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage submitLogin() {
        buttonLogin.click();
        return new MainPage(webDriver);
    }

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
}

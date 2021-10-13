package Lesson6.Wiki;

import Lesson6.CRM.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView{
    @FindBy(id = "wpName1")
    public WebElement inputLogin;

    @FindBy(id = "wpPassword1")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Войти']")
    public WebElement buttonLogin;

    @Step("Вводим логин")
    public LoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Кликаем на кнопку войти")
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

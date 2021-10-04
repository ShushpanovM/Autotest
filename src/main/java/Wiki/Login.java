package Wiki;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private static WebDriver driver;
    private static final String CRM_URL = "https://ru.wikipedia.org/w/index.php?title=Служебная:Вход&returnto=Заглавная+страница";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);

        login();
    }

    public static void login() {
        WebElement element = driver.findElement(By.id("wpName1"));
        element.sendKeys("Tester9400");
        driver.findElement(By.id("wpPassword1")).sendKeys("@Q1w2e3r4");
        driver.findElement(By.xpath("//button[.='Войти']")).click();
    }
}


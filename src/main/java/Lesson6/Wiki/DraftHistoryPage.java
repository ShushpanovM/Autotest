package Lesson6.Wiki;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DraftHistoryPage extends BaseView{
    public DraftHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DraftHistoryPage checkAddHistoryChange() {
        webDriver.get("https://ru.wikipedia.org/w/index.php?title=%D0%A3%D1%87%D0%B0%D1%81%D1%82%D0%BD%D0%B8%D0%BA:Tester9400/%D0%A7%D0%B5%D1%80%D0%BD%D0%BE%D0%B2%D0%B8%D0%BA&action=history");
        List<WebElement> lengthHistoryElement = webDriver.findElements(By.xpath("//*[@id=\"pagehistory\"]/li"));
        Assertions.assertEquals(9, lengthHistoryElement.size());
        return this;
    }

}

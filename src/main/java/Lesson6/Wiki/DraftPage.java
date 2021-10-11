package Lesson6.Wiki;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DraftPage extends BaseView {
    public DraftPage(WebDriver webDriver) {
        super(webDriver);
    }

    final static String editButtonCSSLocator = "ca-ve-edit";
    @FindBy(id = editButtonCSSLocator)
    WebElement editButton;

    public DraftPage editButtonClick() {
        editButton.click();
        return this;
    }

    @FindBy(id = "mwAg")
    WebElement draftTextArea;

    public DraftPage draftTextAreaClear() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("mwAg")));
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("mwAg"))));
        draftTextArea.clear();
        return this;
    }

    public DraftPage fillDraftTextArea(String draftText) {
        draftTextArea.sendKeys(draftText);
        return this;
    }

    @FindBy(xpath = "//a[@title='Записать страницу… Alt+Shift+S']")
    WebElement writeDraftButton;

    public DraftPage writeDraftButtonClick() {
        writeDraftButton.click();
        return this;
    }

    @FindBy(xpath = "//div/span[.='Записать страницу']")
    WebElement twoWriteDraftButton;

    public DraftPage twoWriteDraftButtonClick() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[.='Записать страницу']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(twoWriteDraftButton));
        twoWriteDraftButton.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'postedit-content')]")));
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//div[contains(@class, 'postedit-content')]"))));
        String textMessage = webDriver.findElement(By.xpath("//div[contains(@class, 'postedit-content')]")).getText();
        Assertions.assertEquals("Ваша правка была опубликована.", textMessage);
        return this;
    }

}

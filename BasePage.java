package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(this.driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));
    }
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    protected void replaceText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.chord(Keys.CONTROL,"a"),text);
    }
    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    protected void clear(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
    }
    protected void scrollTo(By locator){
        WebElement it = driver.findElement(locator);
        WheelInput.ScrollOrigin scrollorg=WheelInput.ScrollOrigin.fromElement(it);
        action.scrollFromOrigin(scrollorg,0,60).perform();
    }
    protected Alert switchToAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
    protected void typeInAlert(String text){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }
}

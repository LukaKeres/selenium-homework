package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage{
    private By textBoxButton = By.xpath("//*[@href='#Textbox']");
    private By displayAlert = By.xpath("//*[@id=\"Textbox\"]/button");
    private By text = By.id("demo1");
    public AlertPage(WebDriver driver) {
        super(driver);
    }
    public AlertPage goToTextBox(){
        click(textBoxButton);
        return this;
    }
    public AlertPage showAlert(){
        click(displayAlert);
        return this;
    }
    public AlertPage enterName(String name){
        typeInAlert(name);
        return this;
    }
    public boolean checkText(String expected){
        return getText(text).equals(expected);
    }
}

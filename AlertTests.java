import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Alerts.html");
        WebElement alertButton = driver.findElement(By.xpath("//*[@href='#Textbox']"));
        alertButton.click();
        driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Luka Kereselidze");
        alert.accept();

        WebElement text = driver.findElement(By.id("demo1"));
        Assert.assertEquals(text.getText(), "Hello Luka Kereselidze How are you today");

    }
}

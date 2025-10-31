import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        button.click();
        wait.until(ExpectedConditions.elementToBeClickable(button));

        WebElement field=driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        if(driver.findElement(By.id("message")).getText().equals("It's enabled!") &&
        field.isEnabled() == true)
            System.out.println("Input field is enabled and text is visible");

        if(button.getText().equals("Disable"))
            System.out.println("Button text changed successfully");
        field.sendKeys("Bootcamp");
        field.clear();

        driver.navigate().to("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement A = driver.findElement(By.id("column-a"));
        WebElement B = driver.findElement(By.id("column-b"));
        if(A.getLocation().getY()!=B.getLocation().getY())
        System.out.println("Columns A and B are succesfully aligned");

        driver.quit();
    }
}

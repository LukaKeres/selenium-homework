import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class FormTests {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
    @Test
    public void formTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        Actions action = new Actions(driver);

        WebElement firstname = driver.findElement(By.id("firstName"));
        action.scrollToElement(firstname).perform();
        firstname.sendKeys("Luka");

        WebElement lastname = driver.findElement(By.id("lastName"));
        action.scrollByAmount(0,lastname.getRect().getY()).perform();
        lastname.sendKeys("Keres");

        WebElement email = driver.findElement(By.id("userEmail"));
        action.scrollToElement(email).perform();
        email.sendKeys("kerekere@gmail.com");

        WebElement gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        gender.click();

        WebElement phone = driver.findElement(By.id("userNumber"));
        action.scrollToElement(phone).perform();
        phone.sendKeys("5555555555");

        WebElement birth = driver.findElement(By.id("dateOfBirthInput"));
        action.scrollToElement(birth).perform();
        birth.click();
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select select =  new Select(month);
        select.selectByValue("6");
        select =  new Select(year);
        select.selectByValue("2005");
        driver.findElement(By.cssSelector("[aria-label='Choose Saturday, July 2nd, 2005']")).click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        action.scrollToElement(subjects).perform();
        subjects.sendKeys("Maths");
        driver.findElement(By.id("react-select-2-option-0")).click();
        //Thread.sleep(1000);
        subjects.sendKeys("Physics");
        driver.findElement(By.id("react-select-2-option-0")).click();

        driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();

        WebElement address= driver.findElement(By.id("currentAddress"));
        action.scrollToElement(address).perform();
        address.sendKeys("08 Negra Arroyo Lane, Albuquerque, New Mexico, 87104");


        action.scrollByAmount(0,100).perform();
        driver.findElement(By.id("react-select-3-input")).sendKeys("NCR");
        driver.findElement(By.id("react-select-3-option-0")).click();
        driver.findElement(By.id("react-select-4-input")).sendKeys("Gurgaon");
        driver.findElement(By.id("react-select-4-option-1")).click();

        WebElement submit= driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText(),"Luka Keres");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).getText(),"kerekere@gmail.com");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")).getText(),"Male");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")).getText(),"5555555555");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")).getText(),"02 July,2005");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")).getText(),"Maths, Physics");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")).getText(),"Sports");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")).getText(),"08 Negra Arroyo Lane, Albuquerque, New Mexico, 87104");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")).getText(),"NCR Gurgaon");



    }


}

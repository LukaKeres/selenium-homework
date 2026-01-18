package alert;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.FormPage;
import utils.DriverFactory;

public class AlertTests extends TestBase {
    String name = "Luka Kereselidze";
    @Test
    @Description("This test allows us to test text-box allerts")
    @Severity(SeverityLevel.MINOR)
    public void textBoxAlert(){
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Alerts.html");
        AlertPage alertBox = new AlertPage(DriverFactory.getDriver());
        Allure.step("Switch to the alert and enter the name");
        alertBox.goToTextBox()
                .showAlert()
                .enterName(name);
        Allure.step("Check the results");
        Assert.assertTrue(alertBox.checkText("Hello "+name+" How are you today"));

    }
}

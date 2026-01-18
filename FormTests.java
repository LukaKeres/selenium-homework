package form;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.DriverFactory;

public class FormTests extends TestBase {
    String firstName = "Luka";
    String lastName = "Keres";
    String email = "kerekere@gmail.com";
    String gender = "Male";
    String phone = "5555555555";
    String dob = "02 July,2005";
    String subjects = "Maths";
    String hobbies = "Sports";
    String address = "08 Negra Arroyo Lane, Albuquerque, New Mexico, 87104";
    String state = "NCR";
    String city = "Gurgaon";

    @Test
    @Epic("Web intrface")
    @Feature("Essential Features")
    @Story("Filling the form")
    @Description("This test attempts to complete the provided form and check if the information has been entered correctly using assertions.")
    @Severity(SeverityLevel.NORMAL)
    public void completeFormTest(){
        DriverFactory.getDriver().get("https://demoqa.com/automation-practice-form");
        FormPage form = new FormPage(DriverFactory.getDriver());
        Allure.step("Fill in the form");
        form.enterFirstname(firstName)
                .enterLastname(lastName)
                .enterEmail(email)
                .clickGender(gender)
                .enterPhone(phone)
                .enterDoB(dob)
                .enterSubjects(subjects)
                .enterHobbies(hobbies)
                .enterAddress(address)
                .enterState(state)
                .enterCity(city)
                .clickSubmit();

        Allure.step("Check results with assetions");
        Assert.assertTrue(form.isNameVisible(firstName+" "+lastName));
        Assert.assertTrue(form.isEmailVisible(email));
        Assert.assertTrue(form.isGenderVisible(gender));
        Assert.assertTrue(form.isMobileVisible(phone));
        Assert.assertTrue(form.isDoBVisible(dob));
        Assert.assertTrue(form.areSubjectsVisible(subjects));
        Assert.assertTrue(form.areHobbiesVisible(hobbies));
        Assert.assertTrue(form.isAddressVisible(address));
        Assert.assertTrue(form.areCityAndStateVisible(state+" "+city));



    }

}

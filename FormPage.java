package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage{
    private By firstname = By.id("firstName");
    private By lastname = By.id("lastName");
    private By email = By.id("userEmail");
    private By male = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private By female = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private By other = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label");

    private By phone = By.id("userNumber");
    private By birthdate = By.id("dateOfBirthInput");
    private By subjects = By.id("subjectsInput");
    private By confirmSubject = By.id("react-select-2-option-0");
    private By hobbiesSports = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label");
    private By hobbiesReading = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label");
    private By hobbiesMusic = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label");
    private By state = By.id("react-select-3-input");
    private By confirmState = By.id("react-select-3-option-0");
    private By city = By.id("react-select-4-input");
    private By confirmCity = By.id("react-select-4-option-1");
    private By address = By.id("currentAddress");
    private By submit = By.id("submit");

    private By submittedName=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private By submittedEmail=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[2]");
    private By submittedGender=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private By submittedMobile=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");
    private By submittedDoB=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[5]/td[2]");
    private By submittedSubjects=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[6]/td[2]");
    private By submittedHobbies=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[7]/td[2]");
    private By submittedAddress=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[9]/td[2]");
    private By submittedStateCity=By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[10]/td[2]");

    public FormPage(WebDriver driver){
        super(driver);
    }
    public FormPage enterFirstname(String name){
        scrollTo(firstname);
        type(firstname, name);
        return this;
    }
    public FormPage enterLastname(String lname){
        scrollTo(lastname);
        type(lastname, lname);
        return this;
    }
    public FormPage enterEmail(String eml){
        scrollTo(email);
        type(email, eml);
        return this;
    }
    public FormPage clickGender(String gend){
        scrollTo(male);
        if(gend.equals("Male")){
            click(male);
        } else if (gend.equals("Female")) {
            click(female);
        } else if (gend.equals("Other")) {
            click(other);
        }

        return this;
    }
    public FormPage enterPhone(String num){
        scrollTo(phone);
        type(phone,num);
        return this;
    }
    public FormPage enterDoB(String date){
        scrollTo(birthdate);
        replaceText(birthdate,date);
        return this;
    }
    public FormPage enterSubjects(String subject){
        scrollTo(subjects);
        type(subjects,subject);
        click(confirmSubject);
        return this;
    }
    public FormPage enterHobbies(String hobbie){
        scrollTo(hobbiesMusic);
        if(hobbie.equals("Sports")){
            click(hobbiesSports);
        }else if (hobbie.equals("Reading")){
            click(hobbiesReading);
        }else if (hobbie.equals("Music")){
            click(hobbiesMusic);
        }
        return this;
    }
    public FormPage enterAddress(String addr){
        scrollTo(address);
        type(address,addr);
        return this;
    }
    public FormPage enterState(String st){
        scrollTo(state);
        type(state,st);
        click(confirmState);
        return this;
    }
    public FormPage enterCity(String ct){
        scrollTo(city);
        type(city,ct);
        click(confirmCity);
        return this;
    }
    public FormPage clickSubmit(){
        scrollTo(submit);
        click(submit);
        return this;
    }
    public Boolean isNameVisible(String expected){
        return getText(submittedName).equals(expected);
    }
    public Boolean isEmailVisible(String expected){
        return getText(submittedEmail).equals(expected);
    }
    public Boolean isGenderVisible(String expected){
        return getText(submittedGender).equals(expected);
    }
    public Boolean isMobileVisible(String expected){
        return getText(submittedMobile).equals(expected);
    }
    public Boolean isDoBVisible(String expected){
        return getText(submittedDoB).equals(expected);
    }
    public Boolean areSubjectsVisible(String expected){
        return getText(submittedSubjects).equals(expected);
    }
    public Boolean areHobbiesVisible(String expected){
        return getText(submittedHobbies).equals(expected);
    }
    public Boolean isAddressVisible(String expected){
        return getText(submittedAddress).equals(expected);
    }
    public Boolean areCityAndStateVisible(String expected){
        return getText(submittedStateCity).equals(expected);
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Page{

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public By maleRadioButton(){
        return By.xpath("//input[@id=\"gender-male\"]");
    }

    public By femaleRadioButton(){
        return By.xpath("//input[@id=\"gender-female\"]");
    }

    public By firstNameTextBox(){
        return By.xpath("//input[@id=\"FirstName\"]");
    }

    public By lastNameTextBox(){
        return By.xpath("//input[@id=\"LastName\"]");
    }

    public By dateOfBirth(){
        return By.xpath("//select[@name=\"DateOfBirthDay\"]");
    }

    public By monthOfBirth(){
        return By.xpath("//select[@name=\"DateOfBirthMonth\"]");
    }

    public By yearOfBirth(){
        return By.xpath("//select[@name=\"DateOfBirthYear\"]");
    }

    public By emailTextBox(){
        return By.xpath("//input[@id=\"Email\"]");
    }

    public By companyTextBox(){
        return By.xpath("//input[@id=\"Company\"]");
    }

    public By passwordTextBox(){
        return By.xpath("//input[@id=\"Password\"]");
    }

    public By confirmPasswordTextBox(){
        return By.xpath("//input[@id=\"ConfirmPassword\"]");
    }

    public By registerButton(){
        return By.xpath("//button[@id=\"register-button\"]");
    }


    public By resultMessage(){
        return By.xpath("//div[@class=\"result\"]");
    }

    public By continueButton(){
        return By.xpath("//a[contains(@class,\"register-continue-button\")]");
    }

}

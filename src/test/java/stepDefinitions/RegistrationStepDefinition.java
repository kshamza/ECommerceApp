package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationStepDefinition {

    HomePage homePage;
    RegistrationPage registration;
    WebDriver driver;
    String emailAddress = "adamsandler";
    String password = "adamsandler";
    String dayOfBirth = "15";
    String monthOfBirth = "5";
    String yearOfBirth = "1975";
    String companyName = "Sandlers Inc.";

    @Given("user navigates to registration page")
    public void user_navigates_to_registration_page(){
        driver = SharedSteps.getDriver();
        homePage = new HomePage(driver);
        driver.findElement(homePage.registerLink()).click();
        registration = new RegistrationPage(driver);
    }

    @And("user selects gender")
    public void user_selects_gender(){
        driver.findElement(registration.maleRadioButton()).click();
    }

    @When("user enters first name")
    public void user_enters_first_name(){
        WebElement firstNameBox = driver.findElement(registration.firstNameTextBox());
        firstNameBox.clear();
        firstNameBox.sendKeys("Adam");
    }

    @And("user enters last name")
    public void user_enters_last_name(){
        WebElement lastNameBox =  driver.findElement(registration.lastNameTextBox());
        lastNameBox.clear();
        lastNameBox.sendKeys("Sandler");
    }

    @And("user enters email")
    public void user_enters_email(){
        Random rG = new Random();
        WebElement emailBox = driver.findElement(registration.emailTextBox());
        emailBox.clear();
        emailBox.sendKeys(emailAddress + rG.nextInt(1000) + "@gmail.com" );
    }

    @And("user enters password")
    public void user_enters_password(){
        WebElement passwordBox = driver.findElement(registration.passwordTextBox());
        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    @And("user confirms password")
    public void user_confirms_password(){
        WebElement confirmPasswordBox = driver.findElement(registration.confirmPasswordTextBox());
        confirmPasswordBox.clear();
        confirmPasswordBox.sendKeys(password);
    }

    @And("user clicks on register button")
    public void user_clicks_on_register_button(){
        driver.findElement(registration.registerButton()).click();
    }

    @And("user selects date of birth")
    public void user_selects_date_of_birth(){
        WebElement daySelect = driver.findElement(registration.dateOfBirth());
        Select dateSelectMenu = new Select(daySelect);
        dateSelectMenu.selectByValue(dayOfBirth);

        WebElement monthSelect = driver.findElement(registration.monthOfBirth());
        Select monthSelectMenu = new Select(monthSelect);
        monthSelectMenu.selectByValue(monthOfBirth);

        WebElement yearSelect = driver.findElement(registration.yearOfBirth());
        Select yearSelectMenu = new Select(yearSelect);
        yearSelectMenu.selectByValue(yearOfBirth);
    }

    @And("user enters company name")
    public void user_enters_company_name(){
        WebElement companyNameBox = driver.findElement(registration.companyTextBox());
        companyNameBox.clear();
        companyNameBox.sendKeys(companyName);
    }

    @Then("redirects to result page")
    public void redirects_to_result_page(){
        String expectedResult = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
        Assert.assertEquals(expectedResult, driver.getCurrentUrl());
    }

    @And("success message appears")
    public void success_message_appears(){
        String expectedResult = "Your registration completed";
        Assert.assertEquals(expectedResult, driver.findElement(registration.resultMessage()).getText().trim());
    }

    @And("continue button appears")
    public void continue_button_appears(){
        Assert.assertTrue(driver.findElement(registration.continueButton()).isDisplayed());
    }

    @And("logout link appears")
    public void logout_link_appears(){
        Assert.assertNotNull(driver.findElement(homePage.logoutLink()));
    }

}

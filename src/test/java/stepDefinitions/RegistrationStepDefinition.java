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
import utils.DataHub;

public class RegistrationStepDefinition {

    HomePage homePage;
    RegistrationPage registration;
    WebDriver driver;


    @Given("user navigates to registration page")
    public void user_navigates_to_registration_page(){
        driver = Hooks.getDriver();
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
        WebElement emailBox = driver.findElement(registration.emailTextBox());
        emailBox.clear();
        emailBox.sendKeys(DataHub.getEmailAddress());
    }

    @And("user enters password")
    public void user_enters_password(){
        WebElement passwordBox = driver.findElement(registration.passwordTextBox());
        passwordBox.clear();
        passwordBox.sendKeys(DataHub.password);
    }

    @And("user confirms password")
    public void user_confirms_password(){
        WebElement confirmPasswordBox = driver.findElement(registration.confirmPasswordTextBox());
        confirmPasswordBox.clear();
        confirmPasswordBox.sendKeys(DataHub.password);
    }

    @And("user clicks on register button")
    public void user_clicks_on_register_button(){
        driver.findElement(registration.registerButton()).click();
    }

    @And("user selects date of birth")
    public void user_selects_date_of_birth(){
        WebElement daySelect = driver.findElement(registration.dateOfBirth());
        Select dateSelectMenu = new Select(daySelect);
        dateSelectMenu.selectByValue(DataHub.dayOfBirth);

        WebElement monthSelect = driver.findElement(registration.monthOfBirth());
        Select monthSelectMenu = new Select(monthSelect);
        monthSelectMenu.selectByValue(DataHub.monthOfBirth);

        WebElement yearSelect = driver.findElement(registration.yearOfBirth());
        Select yearSelectMenu = new Select(yearSelect);
        yearSelectMenu.selectByValue(DataHub.yearOfBirth);
    }

    @And("user enters company name")
    public void user_enters_company_name(){
        WebElement companyNameBox = driver.findElement(registration.companyTextBox());
        companyNameBox.clear();
        companyNameBox.sendKeys(DataHub.companyName);
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
}

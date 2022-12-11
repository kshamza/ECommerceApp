package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationStepDefinition {

    HomePage homePage;
    RegistrationPage registration;
    WebDriver driver;

    String emailAddress = "adamsandler@gmail.com";
    String password = "adamsandler";
    String dayOfBirth = "15";
    String monthOfBirth = "May";
    String yearOfBirth = "1975";
    String companyName = "Sandlers Inc.";

    @Given("user opens browser and navigates to test site")
    public void user_opens_browser_navigates_to_test_site() throws InterruptedException{
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/browsers/chrome/chromedriver_108.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user navigates to registration page")
    public void user_navigate_to_registration_page(){
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
        driver.findElement(registration.firstNameTextBox()).sendKeys("Adam");
    }

    @And("user enters last name")
    public void user_enters_last_name(){
        driver.findElement(registration.lastNameTextBox()).sendKeys("Adam");
    }


    @And("user enters email")
    public void user_enters_email(){
        driver.findElement(registration.emailTextBox()).sendKeys(emailAddress);
    }

    @And("user enters password")
    public void user_enters_password(){
        driver.findElement(registration.passwordTextBox()).sendKeys(password);
    }

    @And("user confirms password")
    public void user_confirms_password(){
        driver.findElement(registration.confirmPasswordTextBox()).sendKeys(password);
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

        WebElement monthSelect = driver.findElement(registration.monthOfBorth());
        Select monthSelectMenu = new Select(monthSelect);
        monthSelectMenu.selectByValue(monthOfBirth);

        WebElement yearSelect = driver.findElement(registration.yearOfBirth());
        Select yearSelectMenu = new Select(yearSelect);
        yearSelectMenu.selectByValue(yearOfBirth);
    }

    @And("user enters company name")
    public void user_enters_company_name(){
        driver.findElement(registration.companyTextBox()).sendKeys(companyName);
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
        Assert.assertNotNull(driver.findElement(registration.logoutLink()));
    }

}

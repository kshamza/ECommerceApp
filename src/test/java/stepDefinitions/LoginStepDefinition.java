package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import utils.DataHub;

public class LoginStepDefinition {

    HomePage homePage;
    LoginPage login;
    WebDriver driver;

    @Given("user navigates to login page")
    public void user_navigates_to_login_page(){
        driver = SharedSteps.getDriver();
        homePage = new HomePage(driver);
        driver.findElement(homePage.loginLink()).click();
        login = new LoginPage(driver);
    }

    @When("user enters valid email")
    public void user_enters_valid_email(){
        WebElement emailBox = driver.findElement(login.emailInputBox());
        emailBox.clear();
        emailBox.sendKeys(DataHub.registeredEmail);
    }

    @And("user enters valid password")
    public void user_enters_valid_password(){
        WebElement passwordBox = driver.findElement(login.passwordInputBox());
        passwordBox.clear();
        passwordBox.sendKeys(DataHub.password);
    }

    @And("user clicks login button")
    public void user_clicks_login_button(){
        driver.findElement(login.loginButton()).click();
    }

    @Then("user is redirected to homepage")
    public void user_is_redirected_to_homepage(){
        String expectedResult = "https://demo.nopcommerce.com/";
        Assert.assertEquals(expectedResult, driver.getCurrentUrl());
    }

    @And("logout link appears after login")
    public void logout_link_appears(){
        Assert.assertNotNull(driver.findElement(homePage.logoutLink()));
    }


    @And("user successfully logs in")
    public void user_successfully_logs_in(){
        driver = SharedSteps.getDriver();
        user_enters_valid_email();
        user_enters_valid_password();
        user_clicks_login_button();
        user_is_redirected_to_homepage();
        logout_link_appears();
    }


}

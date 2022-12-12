package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.PasswordRecoveryPage;

public class PasswordRecoveryStepDefinition {

    LoginPage login;
    WebDriver driver;
    PasswordRecoveryPage passwordRecoveryPage;

    @Given("user navigates to forgot password page")
    public void user_navigates_to_forgot_password_page(){
        driver = SharedSteps.getDriver();
        login = new LoginPage(driver);
        driver.findElement(login.forgotPasswordLink()).click();
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
    }

    @When("user enters a registered email")
    public void user_enters_a_registered_email(){
        WebElement textBoxElement = driver.findElement(passwordRecoveryPage.emailTextBox());
        textBoxElement.clear();
        textBoxElement.sendKeys("adamsandler@gmail.com");
    }


    @And("user clicks recover button")
    public void user_clicks_recover_button() throws InterruptedException {
        driver.findElement(passwordRecoveryPage.recoverButton()).click();
        Thread.sleep(2000);
    }


    @Then("success flash message is displayed")
    public void success_flash_message_is_displayed(){
        String expectedResult = "Email with instructions has been sent to you.";
        Assert.assertEquals(expectedResult, driver.findElement(passwordRecoveryPage.flashMessage()).getText().trim());
    }


}

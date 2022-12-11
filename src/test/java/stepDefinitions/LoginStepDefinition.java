package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinition {

    HomePage homePage;
    LoginPage login;
    WebDriver driver;

    @Given("user opens browser and navigates to test site")
    public void user_opens_browser_navigates_to_test_site() throws InterruptedException{
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/browsers/chrome/chromedriver_108.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @And("user navigates to login page")
    public void user_navigate_to_login_page(){
        homePage = new HomePage(driver);
        driver.findElement(homePage.loginLink()).click();
        login = new LoginPage(driver);
    }

    @When("user enters valid email")
    public void user_enters_valid_email(){
        driver.findElement(login.emailInputBox()).sendKeys("adamsandler@gmail.com");
    }

    @And("user enters valid password")
    public void user_enters_valid_password(){
        driver.findElement(login.passwordInputBox()).sendKeys("adamsandler");
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

    @And("logout link appears")
    public void logout_link_appears(){
        Assert.assertNotNull(driver.findElement(login.logoutLink()));
    }

}

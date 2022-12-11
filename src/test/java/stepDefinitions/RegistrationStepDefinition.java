package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class RegistrationStepDefinition {

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



}

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;

public class TheTest {


    public static void main(String[] args) throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/browsers/chrome/chromedriver_108.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/");

        HomePage homePage = new HomePage(driver);
        driver.findElement(homePage.loginLink()).click();
        LoginPage login = new LoginPage(driver);

        driver.findElement(login.emailInputBox()).sendKeys("adamsandler@gmail.com");

        driver.findElement(login.passwordInputBox()).sendKeys("adamsandler");

        driver.findElement(login.loginButton()).click();


        String expectedResult = "https://demo.nopcommerce.com/";
        Assert.assertEquals(expectedResult, driver.getCurrentUrl());

        Assert.assertNotNull(driver.findElement(login.logoutLink()));



    }
}

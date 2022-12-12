package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TheTest {


    public static void main(String[] args) throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/browsers/chrome/chromedriver_108.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/");

        HomePage homePage = new HomePage(driver);

        String emailAddress = "amysandler@gmail.com";
        String password = "amysandler";
        String dayOfBirth = "15";
        String monthOfBirth = "5";
        String yearOfBirth = "1975";
        String companyName = "Sandlers Inc.";
        driver.findElement(homePage.registerLink()).click();
        RegistrationPage registration = new RegistrationPage(driver);

        driver.findElement(registration.maleRadioButton()).click();

        driver.findElement(registration.firstNameTextBox()).sendKeys("Adam");
        driver.findElement(registration.lastNameTextBox()).sendKeys("Adam");

        WebElement daySelect = driver.findElement(registration.dateOfBirth());
        Select dateSelectMenu = new Select(daySelect);
        dateSelectMenu.selectByValue(dayOfBirth);

        WebElement monthSelect = driver.findElement(registration.monthOfBirth());
        Select monthSelectMenu = new Select(monthSelect);
        monthSelectMenu.selectByValue(monthOfBirth);

        WebElement yearSelect = driver.findElement(registration.yearOfBirth());
        Select yearSelectMenu = new Select(yearSelect);
        yearSelectMenu.selectByValue(yearOfBirth);

        driver.findElement(registration.emailTextBox()).sendKeys(emailAddress);


        driver.findElement(registration.companyTextBox()).sendKeys(companyName);

        driver.findElement(registration.passwordTextBox()).sendKeys(password);
        driver.findElement(registration.confirmPasswordTextBox()).sendKeys(password);


//        driver.findElement(registration.registerButton()).click();


//        String expectedResult1 = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
//        Assert.assertEquals(expectedResult1, driver.getCurrentUrl());
//
//        String expectedResult2 = "Your registration completed";
//        Assert.assertEquals(expectedResult2, driver.findElement(registration.resultMessage()).getText().trim());
//
//        Assert.assertTrue(driver.findElement(registration.continueButton()).isDisplayed());
//
//        Assert.assertNotNull(driver.findElement(homePage.logoutLink()));


//        driver.findElement(homePage.loginLink()).click();
//        LoginPage login = new LoginPage(driver);
//
//        driver.findElement(login.emailInputBox()).sendKeys("adamsandler@gmail.com");
//
//        driver.findElement(login.passwordInputBox()).sendKeys("adamsandler");
//
//        driver.findElement(login.loginButton()).click();
//
//
//        String expectedResult = "https://demo.nopcommerce.com/";
//        Assert.assertEquals(expectedResult, driver.getCurrentUrl());
//
//        Assert.assertNotNull(driver.findElement(homePage.logoutLink()));



    }
}

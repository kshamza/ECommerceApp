package stepDefinitions;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private static WebDriver driver;
    private Logger logger;

    public static WebDriver getDriver(){
        return driver;
    }

    @Before
    public void user_opens_browser_and_navigates_to_test_site() throws InterruptedException{
        
        logger = LoggerFactory.getLogger(Hooks.class);
        BasicConfigurator.configure();
        
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/browsers/chrome/chromedriver_108.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}

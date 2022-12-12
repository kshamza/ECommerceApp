package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public By loginLink(){
        return By.className("ico-login");
    }

    public By registerLink(){
        return By.className("ico-register");
    }

    public By logoutLink(){
        return By.className("ico-logout");
    }

}

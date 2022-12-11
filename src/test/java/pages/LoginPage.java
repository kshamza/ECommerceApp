package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public By emailInputBox(){
        return By.xpath("//input[@class=\"email\"]");
    }

    public By passwordInputBox(){
        return By.xpath("//input[@class=\"password\"]");
    }

    public By loginButton(){
        return By.xpath("//button[contains(@class,\"login-button\")]");
    }

    public By logoutLink(){
        return By.className("ico-logout");
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage extends Page {

    public PasswordRecoveryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public By emailTextBox(){
        return By.xpath("//input[@class=\"email\"]");
    }

    public By recoverButton(){
        return By.name("send-email");
    }

    public By flashMessage(){
        return By.className("content");
    }

}

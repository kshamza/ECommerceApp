package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public By logoutLink(){
        return By.className("ico-logout");
    }

}

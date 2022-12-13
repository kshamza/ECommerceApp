package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MyMouse {

    WebDriver driver;
    Actions actions;

    public MyMouse(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    public Actions getActions(){
        return actions;
    }



}

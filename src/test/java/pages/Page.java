package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public By currencySelector(){
        return By.id("customerCurrency");
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

    public By listOfCategories(){
        return By.xpath("//ul[contains(@class, \"notmobile\")]/li");
    }


}

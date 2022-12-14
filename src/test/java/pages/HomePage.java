package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public By shoppingCart(){
        return By.className("cart-label");
    }

    public By wishlistPage(){
        return By.className("wishlist-label");
    }

    public By customerServiceLinks(){
        return By.xpath("//div[@class=\"footer-block customer-service\"]//ul[@class=\"list\"]//li//a");
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public By productTagsList(){
        return By.xpath(".//div[@class=\"product-tags-list\"]//li/a");
    }
}

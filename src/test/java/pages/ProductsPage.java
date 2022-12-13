package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends Page {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public By productItems(){
        return By.className("product-item");
    }

    public By availableColors(){
        return By.xpath("//ul[contains(@class,\"group product-spec-group product-spec-color\")]/li[contains(@class,\"item\")]/input");
    }

}

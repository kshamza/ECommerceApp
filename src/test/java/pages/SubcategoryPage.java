package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubcategoryPage extends Page{

    public SubcategoryPage(WebDriver driver) {
        super(driver);
    }

    public By subCategories(){
        return By.className("sub-category-item");
    }
}

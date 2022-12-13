package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends Page {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public By popularTags(){
        return By.xpath("//div[@class='tags']//li");
    }

}

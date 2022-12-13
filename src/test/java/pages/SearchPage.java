package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends HomePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public By searchBox(){
        return By.xpath("//input[@id=\"small-searchterms\"]");
    }

    public By searchButton(){
        return By.xpath("//button[contains(@class,\"button-1 search-box-button\")]");
    }

}

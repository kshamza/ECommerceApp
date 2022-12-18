package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class CurrencySelectionStepDefinition {

    WebDriver driver;
    HomePage homePage;
    List<String> featuredProductsPricesDollars;
    List<String> featuredProductsPricesEuros;

    @When("user selects euro from currency dropdown menu")
    public void user_selects_euro_from_currency_dropdown_menu() {
        driver = Hooks.getDriver();
        homePage = new HomePage(driver);

        List<WebElement> featuredProductsPrices = driver.findElements(By.xpath("//span[contains(@class,\"actual-price\")]"));

        featuredProductsPricesDollars = new ArrayList<>();

        for (WebElement price:featuredProductsPrices){
            featuredProductsPricesDollars.add(price.getText());
        }

        Select currencySelector = new Select(driver.findElement(homePage.currencySelector()));
        currencySelector.selectByVisibleText("Euro");
    }

    @Then("featured products displayed currency type and price will change")
    public void featured_products_displayed_currency_type_and_price_will_change() {
        List<WebElement> featuredProductsPrices = driver.findElements(By.xpath("//span[contains(@class,\"actual-price\")]"));
        featuredProductsPricesEuros = new ArrayList<>();
        for (WebElement price:featuredProductsPrices){
            featuredProductsPricesEuros.add(price.getText());
        }

        boolean currencyChanged = true;

        for (int i = 0 ; i < featuredProductsPricesEuros.size() ; i++){
            String itemPrice = featuredProductsPricesEuros.get(i);
            if (!itemPrice.trim().startsWith("€") && !itemPrice.substring(1).equals(featuredProductsPricesDollars.get(i).substring(1))){
                currencyChanged = false;
            }
        }
        Assert.assertTrue(currencyChanged);
    }
}

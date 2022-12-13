package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SearchPage;

import java.util.List;

public class SearchStepDefinition {
    SearchPage searchPage;
    WebDriver driver;

    String searchTerm = "shoes";

    @When("user enters a valid search term in the search box")
    public void user_enters_a_valid_search_term_in_the_search_box(){
        driver = SharedSteps.getDriver();
        searchPage = new SearchPage(driver);
        WebElement searchBox = driver.findElement(searchPage.searchBox());
        searchBox.clear();
        searchBox.sendKeys(searchTerm);
    }

    @And("user clicks the search button")
    public void user_clicks_the_search_button() throws InterruptedException {
        driver.findElement(searchPage.searchButton()).click();
        Thread.sleep(1000);
    }

    @Then("products display and their name contain the search term")
    public void products_display_and_their_name_contain_the_search_term(){
        // Get the list of products
        List<WebElement> products = driver.findElements(searchPage.productItem());

        // Check if the results contain the keywords of the search
        int count = 0;
        for (WebElement product : products){
            WebElement productTitle = product.findElement(By.xpath("//h2/a"));
            if (productTitle != null && productTitle.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                count++;
            }
        }

        Assert.assertEquals(count,products.size());
    }

}

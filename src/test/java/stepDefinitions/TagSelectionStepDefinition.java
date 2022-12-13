package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductsPage;
import utils.MyMouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TagSelectionStepDefinition {

    WebDriver driver;
    CategoryPage categoryPage;
    ProductsPage productsPage;
    ProductPage productPage;
    // Random generator for random selections
    Random rG;
    WebElement selectedProduct;
    WebElement selectedTag;
    String selectedTagText;

    @When("user randomly selects one of the tags in the Popular tags section")
    public void user_randomly_selects_one_of_the_tags_in_the_popular_tags_section() {
        categoryPage = new CategoryPage(driver);
        driver = SharedSteps.getDriver();
        rG = new Random();

        // Put all tags elements in an ArrayList
        List<WebElement> tags = new ArrayList<>();
        tags = driver.findElements(categoryPage.popularTags());

        // Randomly select a tag
        int tagIdx = rG.nextInt(tags.size());

        // Populate the selectedTag object to be used in other methods
        selectedTag = tags.get(tagIdx);

        selectedTagText = selectedTag.getText();

        // Click on the selected tag
        selectedTag.click();
    }

    @And("user randomly selects one of the products displayed after selecting a tag")
    public void user_randomly_selects_one_of_the_products_displayed_after_selecting_a_tag() throws InterruptedException {

        ProductsPage productsPage = new ProductsPage(driver);

        // Get the list of products
        List<WebElement> products = driver.findElements(productsPage.productItems());

        if (products.size() > 0) {
            // We have products displayed
            int selectedItemIdx = rG.nextInt(products.size());

            selectedProduct = products.get(selectedItemIdx);

            // Click on the product title
            selectedProduct.findElement(By.xpath(".//h2[@class='product-title']/a")).click();

            Thread.sleep(1000);

        }
    }


    @Then("the product selected by the user has a tag that matches the selected tag by the user")
    public void the_product_selected_by_the_user_has_a_tag_that_matches_the_selected_tag_by_the_user() {

        productPage = new ProductPage(driver);


        // Get all the tags of the product
        List<WebElement> tagsList = new ArrayList<>();
        tagsList = driver.findElements(productPage.productTagsList());


        // Check if the selected tag is present
        boolean tagIsPresent = false;

        for (WebElement tag : tagsList){
            String tagText = tag.getText();
            if (tagText.startsWith(selectedTagText)){
                tagIsPresent = true;
            }
        }

        Assert.assertTrue(tagIsPresent);
    }

}

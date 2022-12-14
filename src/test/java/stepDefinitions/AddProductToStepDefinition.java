package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.SubcategoryPage;

import java.util.List;

public class AddProductToStepDefinition {

    WebDriver driver;
    HomePage homePage;
    SubcategoryPage subcategoryPage;

    WebElement product;

    @When("user navigates to an uncustomizable product")
    public void user_navigates_to_an_uncustomizable_product() throws InterruptedException {
        driver = SharedSteps.getDriver();
        homePage = new HomePage(driver);

        // Retrieve the list of categories
        List<WebElement> categories = driver.findElements(homePage.listOfCategories());

        int i;
        for (i = 0; i < categories.size(); i++) {
            if (categories.get(i).findElement(By.tagName("a")).getText().trim().toLowerCase().equals("apparel")) {
                break;
            }
        }

        /*
         * Select the category for further processing:
         * If there are sub-categories, we will select one of them, if not, then we will just click it.
         */
        WebElement category = categories.get(i);

        category.click();

        subcategoryPage = new SubcategoryPage(driver);

        List<WebElement> subcategories = driver.findElements(subcategoryPage.subCategories());

        int j;
        for (j = 0; j < subcategories.size(); j++) {
            if (subcategories.get(j).findElement(By.xpath(".//a")).getText().trim().toLowerCase().equals("shoes")) {
                break;
            }
        }

        WebElement subcategory = subcategories.get(j);

        subcategory.click();

        Thread.sleep(1000);

        // TODO try to change the way you choose the product in case that changes in the future.
        // Selecting the Nike Shoes

        product = driver.findElement(By.xpath("//div[@data-productid=\"26\"]"));
    }

    /*
     * Shopping Cart Button
     */
    @And("user clicks the add to cart button")
    public void user_clicks_the_add_to_cart_button() throws InterruptedException {
        product.findElement(By.xpath(".//button[contains(@class,\"product-box-add-to-cart-button\")]")).click();
        Thread.sleep(1000);
    }

    /*
     * Wishlist Button
     */
    @And("user clicks the add to wishlist button")
    public void user_clicks_the_add_to_wishlist_button() throws InterruptedException {
        product.findElement(By.xpath(".//button[contains(@class,\"add-to-wishlist-button\")]")).click();
        Thread.sleep(1000);
    }

    /*
     * Compare List Button
     */

    @And("user clicks the add to compare list button")
    public void user_clicks_the_add_to_compare_list_button() throws InterruptedException {
        product.findElement(By.xpath(".//button[contains(@class,\"add-to-compare-list-button\")]")).click();
        Thread.sleep(1000);
    }

    /*
     * Flash Message
     */

    @Then("^added to \"(.*)\" success flash message displays$")
    public void success_flash_message_displays(String productDestination){
        WebElement flash = driver.findElement(By.id("bar-notification"));
        String expectedResult = "The product has been added to your " + productDestination;
        Assert.assertTrue(flash.findElement(By.xpath(".//p")).getText().trim().contains(expectedResult));

        // Click the x to close
        flash.findElement(By.xpath(".//span[@class=\"close\"]")).click();
    }


    /*
     * Checking the Shopping Cart
     */
    @And("product is added successfully to the shopping cart")
    public void product_is_added_successfully_to_the_shopping_cart() {
        Assert.assertTrue(isItemInCart(product));
    }


    /*
     * Checking the Wishlist
     */
    @And("product is added successfully to the wishlist")
    public void product_is_added_successfully_to_the_wishlist() {
        Assert.assertTrue(isItemInWishlist(product));
    }


    /*
     * Checking the Compare List
     */
    @And("product is added successfully to the comparison list")
    public void product_is_added_successfully_to_the_comparison_list() throws InterruptedException {
        Assert.assertTrue(isItemInComparisonList(product));
    }


    /*
     * Helping Methods
     */
    public boolean isItemInCart(WebElement item){

        // Get the item's title
        String itemName = item.findElement(By.className("product-title")).getText();

        // Navigate to the cart
        driver.findElement(By.className("cart-label")).click();

        // Get all the elements in the shopping cart
        List<WebElement> shoppingCartProducts = driver.findElements(By.xpath("//tr/td[@class=\"product\"]"));

        boolean itemInList = false;

        for (WebElement product : shoppingCartProducts){
            if (product.findElement(By.xpath(".//a")).getText().trim().equals(itemName.trim())){
                itemInList = true;
            }
        }

        // Return the boolean variable
        return itemInList;
    }


    public boolean isItemInWishlist(WebElement item){

        // Get the item's title
        String itemName = item.findElement(By.className("product-title")).getText();

        // Navigate to the wishlist
        driver.findElement(By.className("wishlist-label")).click();

        // Get all the elements in the wishlist
        List<WebElement> wishlistProducts = driver.findElements(By.xpath("//tr/td[@class=\"product\"]"));

        boolean itemInList = false;

        for (WebElement product : wishlistProducts){
            if (product.findElement(By.xpath(".//a")).getText().trim().equals(itemName.trim())){
                itemInList = true;
            }
        }

        // Return the boolean variable
        return itemInList;
    }


    public boolean isItemInComparisonList(WebElement item) throws InterruptedException {

        // Get the item's title
        String itemName = item.findElement(By.className("product-title")).getText();
        System.out.println(itemName);

        // Navigate to the wishlist
        List<WebElement> customerServiceLinks = driver.findElements(By.xpath("//div[@class=\"footer-block customer-service\"]//ul[@class=\"list\"]//li//a"));

        // Find the "compare products list" and click it
        for (WebElement link : customerServiceLinks){
            if (link.getText().trim().equalsIgnoreCase("compare products list")){
                link.click();
                break;
            }
        }

        Thread.sleep(1000);

        // Get all the elements in the wishlist
        List<WebElement> comparisonListProducts = driver.findElements(By.xpath("//tr[@class=\"product-name\"]//td//a"));
        System.out.println(comparisonListProducts.size());

        boolean itemInList = false;

        for (WebElement product : comparisonListProducts){
            System.out.println(product.getText().trim());
            if (product.getText().trim().equals(itemName.trim())){
                itemInList = true;
            }
        }

        // Return the boolean variable
        return itemInList;
    }


}

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

public class AddToShoppingCartStepDefinition {

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

    @And("user clicks the add to cart button")
    public void user_clicks_the_add_to_cart_button() throws InterruptedException {
        product.findElement(By.xpath(".//button[contains(@class,\"product-box-add-to-cart-button\")]")).click();
        Thread.sleep(1000);
    }

    @Then("success flash message displays")
    public void success_flash_message_displays(){
        WebElement flash = driver.findElement(By.id("bar-notification"));
        String expectedResult = "The product has been added to your shopping cart";
        Assert.assertTrue(flash.findElement(By.xpath(".//p")).getText().trim().contains(expectedResult));

        // Click the x to close
        flash.findElement(By.xpath(".//span[@class=\"close\"]")).click();
    }

    @And("product is added successfully to the shopping cart")
    public void product_is_added_successfully_to_the_shopping_cart() {
        Assert.assertTrue(isItemInCart(product));
    }



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

}

package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ProductsPage;
import pages.SubcategoryPage;

import java.util.List;
import java.util.Random;

public class ColorFilterStepDefinition {

    WebDriver driver;
    HomePage homePage;
    SubcategoryPage subcategoryPage;

    @When("user navigates to shoes subcategory")
    public void user_navigates_to_shoes_subcategory() throws InterruptedException {
        driver = Hooks.getDriver();
        homePage = new HomePage(driver);

        // Retrieve the list of categories
        List<WebElement> categories = driver.findElements(homePage.listOfCategories());

        // Get the index of the "Apparel" category
        int i;
        for (i = 0; i < categories.size(); i++) {
            if (categories.get(i).findElement(By.tagName("a")).getText().trim().toLowerCase().equals("apparel")) {
                break;
            }
        }

        /*
         * Select the category for further processing:
         * If there are sub-categories, we we will select one of them, if not, then we will just click it.
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

        Assert.assertEquals("https://demo.nopcommerce.com/shoes", driver.getCurrentUrl());
    }


    @And("user selects one of the colors")
    public void user_selects_one_of_the_color(){
        ProductsPage productsPage = new ProductsPage(driver);

        List<WebElement> colors = driver.findElements(productsPage.availableColors());

        Random rG = new Random();

        int selectedColorIdx = rG.nextInt(colors.size());

        colors.get(selectedColorIdx).click();
    }

    @Then("list of products will display based on the color filter")
    public void list_of_products_will_display_based_on_the_color_filter(){
        ProductsPage productsPage = new ProductsPage(driver);
        // Get the list of products
        List<WebElement> products = driver.findElements(productsPage.productItems());
        Assert.assertTrue(products.size() > 0);
    }

}

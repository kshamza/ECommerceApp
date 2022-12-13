package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ProductsPage;
import pages.SubcategoryPage;
import utils.MyMouse;

import java.util.List;
import java.util.Random;

public class CategorySelectionStepDefinition {

    static Random rG;
    MyMouse mouse;
    HomePage homePage;
    static WebDriver driver;

    SubcategoryPage subcategoryPage;

    @When("user randomly selects one of the categories in the top menu")
    public void user_randomly_selects_one_of_the_categories_in_the_top_menu() throws InterruptedException {
        driver = SharedSteps.getDriver();
        homePage = new HomePage(driver);
        rG = new Random();

        // Retrieve the list of categories
        List<WebElement> categories = driver.findElements(homePage.listOfCategories());

        // Generate a random number to select one of the categories (0-categories.size() - 1)
        int categoryIdx = rG.nextInt(categories.size());

        /*
         * Select the category for further processing:
         * If there are sub-categories, we we will select one of them, if not, then we will just click it.
         */
        WebElement category = categories.get(categoryIdx);

        List<WebElement> subcategories = category.findElements(By.xpath(".//ul[contains(@class,\"sublist\")]/li"));

        if (subcategories.size() > 0) { // We have subcategories, randomly select one of them
            int subcategoryIdx = rG.nextInt(subcategories.size());

            // TODO: Try to select from the dropdown menu that appears after hovering over the category
            category.click();

            subcategoryPage = new SubcategoryPage(driver);

            subcategories = driver.findElements(subcategoryPage.subCategories());

            WebElement subcategory = subcategories.get(subcategoryIdx);

            subcategory.click();

        } else { // We do not have subcategories, click the category link.
            category.click();
        }

        Thread.sleep(1000);
    }

    @Then("list of products will display under this category")
    public void list_of_products_will_display_under_this_category(){
        ProductsPage productsPage = new ProductsPage(driver);
        // Get the list of products
        List<WebElement> products = driver.findElements(productsPage.productItems());
        Assert.assertTrue(products.size() > 0);
    }
}

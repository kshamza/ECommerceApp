package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;
import utils.MyMouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TagSelectionStepDefinition {

    WebDriver driver;
    HomePage homePage;
    CategoryPage categoryPage;

    // Random generator for random selections
    Random rG;
    WebElement selectedTag;

    MyMouse mouse;


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

        System.out.println("List size: " + categories.size());
        System.out.println("Index" + categoryIdx);
        System.out.println("SElected Category:" + category.getText());

        System.out.println("subList size: " + subcategories.size());

        if (subcategories.size() > 0) { // We have subcategories, randomly select one of them
            int subcategoryIdx = rG.nextInt(subcategories.size());
            WebElement subcategory = subcategories.get(subcategoryIdx);

            System.out.println("Index" + subcategoryIdx);

            // Hover over the category
            mouse = new MyMouse(driver);
            mouse.getActions().moveToElement(category);

            System.out.println("SElected subCategory:" + subcategory.getText());

            subcategory.click();
        } else { // We do not have subcategories, click the category link.
            category.click();
        }

        Thread.sleep(1000);
    }

    @When("user randomly selects one of the tags in the Popular tags section")
    public void user_randomly_selects_one_of_the_tags_in_the_popular_tags_section() {
        categoryPage = new CategoryPage(driver);

        // Put all tags elements in an ArrayList
        List<WebElement> tags = new ArrayList<>();
        tags = driver.findElements(categoryPage.popularTags());

        // Randomly select a tag
        int tagIdx = rG.nextInt(tags.size());

        // Populate the selectedTag object to be used in other methods
        selectedTag = tags.get(tagIdx);

        System.out.println(selectedTag.getText());

        // Click on the selected tag
        selectedTag.click();
    }

    @When("user randomly selects one of the products displayed")
    public void user_randomly_selects_one_of_the_products_displayed() {

    }

    @Then("the product selected by the user has a tag that matches the selected tag by the user")
    public void the_product_selected_by_the_user_has_a_tag_that_matches_the_selected_tag_by_the_user() {

    }




}

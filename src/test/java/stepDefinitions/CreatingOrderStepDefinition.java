package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.ShoppingCartPage;
import utils.DataHub;

import java.util.List;

public class CreatingOrderStepDefinition {

    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;


    @When("user clicks the shopping cart button")
    public void user_clicks_the_shopping_cart_button() throws InterruptedException {

        driver = Hooks.getDriver();
        homePage = new HomePage(driver);

        // Navigate to the cart
        driver.findElement(homePage.shoppingCart()).click();

        Thread.sleep(3000);
    }

    @And("user checks the terms of service checkbox")
    public void user_checks_the_terms_of_service_checkbox() {
        shoppingCartPage = new ShoppingCartPage(driver);
        driver.findElement(shoppingCartPage.termsOfServiceCheckbox()).click();
    }

    @And("user clicks the checkout button")
    public void user_clicks_the_checkout_button() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(shoppingCartPage.checkoutBtn()).click();
        Thread.sleep(3000);
    }

    @And("user checks the ship to the same address checkbox")
    public void user_checks_the_ship_to_the_same_address_checkbox(){
        WebElement sameAddressCheckbox = driver.findElement(shoppingCartPage.sameAddressCheckbox());

        if (!sameAddressCheckbox.isSelected()){
            sameAddressCheckbox.click();
        }
    }

    @And("user selects the country")
    public void user_selects_the_country() throws InterruptedException {
        WebElement countryDropDown = driver.findElement(shoppingCartPage.countryDropDownMenu());
        Select countrySelector = new Select(countryDropDown);
        countrySelector.selectByVisibleText(DataHub.country);
        Thread.sleep(3000); // Wait for the list of states to load
    }

    @And("user selects the state")
    public void user_selects_the_state() throws InterruptedException {
        WebElement stateDropDown = driver.findElement(shoppingCartPage.stateDropDownMenu());
        Select stateSelector = new Select(stateDropDown);
        stateSelector.selectByVisibleText(DataHub.state);
    }

    @And("user enters the city name")
    public void user_enters_the_city_name() {
        driver.findElement(shoppingCartPage.cityTextBox()).sendKeys(DataHub.city);
    }

    @And("user enters the first address line")
    public void user_enters_the_first_address_line() {
        driver.findElement(shoppingCartPage.addressLineOne()).sendKeys(DataHub.addressFirstLine);
    }

    @And("user enters the zip code")
    public void user_enters_the_zip_code() {
        driver.findElement(shoppingCartPage.zipPostalCodeTextBox()).sendKeys(DataHub.zipCode);

    }

    @And("user enters the phone number")
    public void user_enters_the_phone_number() {
        driver.findElement(shoppingCartPage.phoneNumberTextBox()).sendKeys(DataHub.phoneNumber);
    }

    @And("user clicks continue button")
    public void user_clicks_continue_button() throws InterruptedException {
        driver.findElement(shoppingCartPage.addressContinueBtn()).click();
        Thread.sleep(3000);
    }


    @And("user accepts ground shipping")
    public void user_accepts_ground_shipping() throws InterruptedException {
        // since this is the automatically selected shipping type, the user only need to click continue
        driver.findElement(shoppingCartPage.shippingContinueBtn()).click();
        Thread.sleep(3000);
    }

    @And("^user selects the \"(.*)\" payment method$")
    public void user_selects_the_payment_method(String selectedPaymentMethod) {
        List<WebElement> paymentMethods = driver.findElements(shoppingCartPage.paymentMethods());

        for (WebElement paymentMethod: paymentMethods){
            if (paymentMethod.findElement(By.xpath(".//label")).getText().equalsIgnoreCase(selectedPaymentMethod)){
                // Click the radio button
                paymentMethod.findElement(By.xpath(".//input")).click();
            }
        }
    }

    @And("user clicks continue in payment method section")
    public void user_clicks_continue_in_payment_method_section() throws InterruptedException {
        driver.findElement(shoppingCartPage.paymentContinueBtn()).click();
        Thread.sleep(3000);
    }

    @And("user clicks continue button in payment information section")
    public void user_clicks_continue_button_in_payment_information_section() throws InterruptedException {
        driver.findElement(shoppingCartPage.paymentInformationContinueBtn()).click();
        Thread.sleep(3000);
    }

    @And("user clicks confirm button")
    public void user_clicks_confirm_button() throws InterruptedException {
        driver.findElement(shoppingCartPage.confirmBtn()).click();
        Thread.sleep(3000);
    }

    @Then("confirmation page displays")
    public void confirmation_page_displays() {

        String expectedResult = "https://demo.nopcommerce.com/checkout/completed";

        Assert.assertEquals(expectedResult, driver.getCurrentUrl());

        String successMessage = "Your order has been successfully processed!";
        String actualMessage = driver.findElement(shoppingCartPage.confirmationMessage()).getText().trim();
        Assert.assertEquals(successMessage, actualMessage);
    }

}

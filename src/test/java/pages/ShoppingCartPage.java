package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends Page {


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public By shoppingCartItems(){
        return By.xpath("//tr/td[@class=\"product\"]");
    }

    public By termsOfServiceCheckbox(){
        return By.id("termsofservice");
    }

    public By checkoutBtn(){
        return By.id("checkout");
    }

    public By sameAddressCheckbox(){
        return By.id("ShipToSameAddress");
    }

    public By countryDropDownMenu(){
        return By.id("BillingNewAddress_CountryId");
    }

    public By stateDropDownMenu(){
        return By.id("BillingNewAddress_StateProvinceId");
    }

    public By cityTextBox(){
        return By.id("BillingNewAddress_City");
    }

    public By addressLineOne(){
        return By.id("BillingNewAddress_Address1");
    }

    public By zipPostalCodeTextBox(){
        return By.id("BillingNewAddress_ZipPostalCode");
    }

    public By phoneNumberTextBox(){
        return By.id("BillingNewAddress_PhoneNumber");
    }

    public By addressContinueBtn(){
        return By.xpath("//div[@id=\"billing-buttons-container\"]//button[@name=\"save\"]");
    }

    // Shipping Section
    public By shippingContinueBtn(){
        return By.xpath("//div[@id=\"shipping-method-buttons-container\"]//button");
    }

    // //ol[@id="checkout-steps"]//li[contains(@class,active)]//button[contains(@class,"new-address-next-step-button")] billing-buttons-container


    // Payment Methods
    public By paymentMethods(){
        return By.xpath("//div[@class=\"payment-details\"]");
    }


    public By paymentContinueBtn() {
        return By.xpath("//div[@id=\"payment-method-buttons-container\"]//button");
    }

    public By paymentInformationContinueBtn(){
        return By.xpath("//div[@id=\"payment-info-buttons-container\"]//button");
    }

    public By confirmBtn() {
        return By.xpath("//div[@id=\"confirm-order-buttons-container\"]//button");
    }

    public By confirmationMessage(){
        return By.xpath("//div[@class=\"section order-completed\"]//div[@class=\"title\"]");
    }
}

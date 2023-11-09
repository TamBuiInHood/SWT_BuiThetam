package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    By BillingNewAddress = By.id("billing-address-select");
    By BillingAddress = By.id("billing:street1");
    By BillingCity = By.id("billing:city");
    By Billingregion = By.id("billing:region_id");
    By BillingState = By.id("billing:region");
    By Billingzip = By.id("billing:postcode");
    By Billingtelephone = By.id("billing:telephone");

    By BillingFirstname = By.id("billing:firstname");
    By BillingLastname = By.id("billing:lastname");
    By BillingCompany = By.id("billing:company");

    By BillingCountry = By.id("billing:country_id");

    By DifferentAddess = By.xpath("//label[@for='billing:use_for_shipping_no']");
    By BillingContinueBtn = By.cssSelector("button[class='button validation-passed']");


    By ShippingFirstname = By.id("shipping:firstname");
    By ShippingLastname = By.id("shipping:lastname");
    By ShippingCompany = By.id("shipping:company");
    By ShippingAddress = By.id("shipping:street1");
    By ShippingCity = By.id("shipping:city");
    By ShippingCountry = By.id("shipping:country_id");
    By Shippingregion = By.id("shipping:region_id");
    By Shippingzip = By.id("shipping:postcode");
    By Shippingtelephone = By.id("shipping:telephone");
    By ShippingNewAddress = By.id("shipping-address-select");

    By UseBillingAddress = By.xpath("//label[@for='shipping:same_as_billing']");
    By ShippingContinueBtn = By.xpath("//button[@onclick='shipping.save()']");

    By ShippingMethodContinueBtn = By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]");

    By CheckMoneyOrder = By.xpath("//label[@for='p_method_checkmo']");
    By PaymentContinueBtn = By.xpath("//button[@onclick='payment.save()']");

    By PlaceOrderBtn = By.xpath("//button[@title='Place Order']");

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterBilling(String firstName, String lastName, String company, String address, String state,
                             String city, String zip, String country, String telephone) {

        WebElement firstNameEle = driver.findElement(BillingFirstname);
        firstNameEle.clear();
        firstNameEle.sendKeys(firstName);

        WebElement lastNameEle = driver.findElement(BillingLastname);
        lastNameEle.clear();
        lastNameEle.sendKeys(lastName);

        WebElement companyEle = driver.findElement(BillingCompany);
        companyEle.clear();
        companyEle.sendKeys(company);

        WebElement addressElement = driver.findElement(BillingAddress);
        addressElement.clear();
        addressElement.sendKeys(address);

        WebElement cityElement = driver.findElement(BillingCity);
        cityElement.clear();
        cityElement.sendKeys(city);

        WebElement countryEle = driver.findElement(BillingCountry);
        Select options = new Select(countryEle);
        options.selectByValue(country);

        WebElement regionEle = driver.findElement(Billingregion);
        Select regionOptions = new Select(regionEle);
        regionOptions.selectByValue(state);

//        Select regionDropdown = new Select(driver.findElement(Billingregion));
//        regionDropdown.selectByValue(region);

        WebElement zipElement = driver.findElement(Billingzip);
        zipElement.clear();
        zipElement.sendKeys(zip);

        WebElement telephoneElement = driver.findElement(Billingtelephone);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
    }
//    public void BillingNewAddress(){
//        Select NewAddressDropdowm = new Select(driver.findElement(BillingNewAddress));
//        NewAddressDropdowm.selectByIndex(NewAddressDropdowm.getOptions().size() - 1);
//    }
    public void ShippingNewAddress(){
        Select NewAddressDropdowm = new Select(driver.findElement(ShippingNewAddress));
        NewAddressDropdowm.selectByIndex(NewAddressDropdowm.getOptions().size() - 1);
    }
    public void clickDifferentAddess(){
        driver.findElement(DifferentAddess).click();
    }
    public void clickBillingContinue() {
        WebElement continueButton = driver.findElement(new By.ByCssSelector("button[class='button validation-passed'] span span"));
        continueButton.click();
    }
    public void enterShipping(String firstName, String lastName, String company, String address, String state,
                              String city, String zip, String country, String telephone) {

        WebElement firstNameEle = driver.findElement(ShippingFirstname);
        firstNameEle.clear();
        firstNameEle.sendKeys(firstName);

        WebElement lastNameEle = driver.findElement(ShippingLastname);
        lastNameEle.clear();
        lastNameEle.sendKeys(lastName);

        WebElement companyEle = driver.findElement(ShippingCompany);
        companyEle.clear();
        companyEle.sendKeys(company);

        WebElement addressElement = driver.findElement(ShippingAddress);
        addressElement.clear();
        addressElement.sendKeys(address);

        WebElement cityElement = driver.findElement(ShippingCity);
        cityElement.clear();
        cityElement.sendKeys(city);


        WebElement countryEle = driver.findElement(ShippingCountry);
        Select options = new Select(countryEle);
        options.selectByValue(country);

        WebElement regionElement = driver.findElement(Shippingregion);
        Select regionOpts = new Select(regionElement);
        regionOpts.selectByValue(state);

//        Select regionDropdown = new Select(driver.findElement(Billingregion));
//        regionDropdown.selectByValue(region);

        WebElement zipElement = driver.findElement(Shippingzip);
        zipElement.clear();
        zipElement.sendKeys(zip);

        WebElement telephoneElement = driver.findElement(Shippingtelephone);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
    }
    public void clickShippingContinue() {
        WebElement continueButton = driver.findElement(ShippingContinueBtn);
        continueButton.click();
    }

    public void clickShippingMethodContinue() {
        WebElement continueButton = driver.findElement(ShippingMethodContinueBtn);
        continueButton.click();
    }

    public void selectCheckMoneyOrderPaymentMethod() {
        WebElement checkMoneyOrderElement = driver.findElement(CheckMoneyOrder);
        checkMoneyOrderElement.click();
    }

    public void clickPaymentContinue() {
        WebElement continueButton = driver.findElement(PaymentContinueBtn);
        continueButton.click();
    }

    public void clickPlaceOrder() {
        WebElement placeOrderButtonElement = driver.findElement(PlaceOrderBtn);
        placeOrderButtonElement.click();
    }

    public void clickUseBillingAddress(){
        WebElement btn = driver.findElement(UseBillingAddress);
        btn.click();
    }
}

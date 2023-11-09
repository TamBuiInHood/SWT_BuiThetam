package BAITAP;
import driver.driverFactory;
import model.pages.CartPage;
import model.pages.CheckoutPage;
import model.pages.LoginPage;
import model.pages.WishList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/* Verify user is able to purchase product using registered email id (USE CHROME BROWSER)

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on MY WISHLIST link

5. In next page, Click ADD TO CART link

6. Enter general shipping country, state/province and zip for the shipping cost estimate

7. Click Estimate

8. Verify Shipping cost generated

9. Select Shipping Cost, Update Total

10. Verify shipping cost is added to total

11. Click "Proceed to Checkout"

12a. Enter Billing Information, and click Continue

12b. Enter Shipping Information, and click Continue

13. In Shipping Method, Click Continue

14. In Payment Information select 'Check/Money Order' radio button. Click Continue

15. Click 'PLACE ORDER' button

16. Verify Oder is generated. Note the order number
 */
public class TestCase6 {
    @Test
    public void Testcase06() {
        String firstname = "Bui";
        String lastname = "Tam";
        String email = "thetam1410022@gmail.com";
        String password = "123456";
        String address = "Phu Giao";
        String country = "US";
        String company = "FPT";
        String region = "57";
        String zip = "2000";
        String city = "Texas";
        String telephone = "0123456789";
        String state = "Ya";

        WebDriver driver = driverFactory.getChromeDriver();
        try {

            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

            Thread.sleep(2000);

            // Click on mobile link
            driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
            // Click add to wish list
            driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();
            // click on Account
            driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
            // click on My Account
            driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']")).click();

            WebElement myWishlistLink = driver.findElement(By.linkText("MY WISHLIST"));
            myWishlistLink.click();

            WishList wishlistPage = new WishList(driver);
            wishlistPage.clickAddToCart();

            Thread.sleep(2000);

            CartPage cartPage = new CartPage(driver);
            cartPage.selectCountry(country);
            cartPage.selectRegion(region);
            cartPage.enterZip(zip);
            cartPage.clickEstimate();

            //8. Verify Shipping cost generated
            String shipType = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']")).getText();
            System.out.println("Actual Shipping Cost: " + shipType);
            System.out.println("Expected Shipping Cost: " + "Flat Rate");
            Assert.assertEquals(shipType, "Flat Rate");

            //String shipCost = driver.findElement(By.cssSelector("label[for='s_method_flatrate_flatrate']")).getText();

            // Select shipping type
            driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']")).click();
            // click update
            cartPage.clickUpdateTotal();

            //10. Verify shipping cost is added to total
            String shipTotal = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)")).getText();
            System.out.println("Shipping total price: " + shipTotal);
            Assert.assertTrue(!shipTotal.isEmpty());

            cartPage.clickProceedToCheckout();

            CheckoutPage checkoutPage = new CheckoutPage(driver);
//            checkoutPage.BillingNewAddress();
            checkoutPage.enterBilling(firstname, lastname, company, address, region, city, zip, country, telephone);
            Thread.sleep(2000);
            checkoutPage.clickDifferentAddess();
            //checkoutPage.clickBillingContinue();
            driver.findElement(By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]")).click();

            Thread.sleep(3000);

            //checkoutPage.ShippingNewAddress();
//            WebElement shippingEle = driver.findElement(By.xpath("//select[@id='shipping-address-select']"));
//            Select shippingOpts = new Select(shippingEle);
//            shippingOpts.selectByIndex(shippingOpts.getOptions().size() - 1);

            checkoutPage.enterShipping(firstname + "haha", lastname + "hihi", company + "Uni", address + "hehe", region, city, zip + "123", country, telephone);
            //checkoutPage.clickUseBillingAddress();
            //checkoutPage.clickShippingContinue();
            // Click continue button
            driver.findElement(By.xpath("//button[@onclick='shipping.save()']//span//span[contains(text(),'Continue')]")).click();
            Thread.sleep(3000);

            String shipMethod = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']")).getText();
            Assert.assertEquals(shipMethod, "Flat Rate");

            //checkoutPage.clickShippingMethodContinue();
            // Click shipping method continue
            driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")).click();
            Thread.sleep(3000);

            checkoutPage.selectCheckMoneyOrderPaymentMethod();
//            checkoutPage.clickPaymentContinue();

            // Click payment continue
            driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();

            //checkoutPage.clickPlaceOrder();

            Thread.sleep(2000);

            // Click place order
            driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();

            Thread.sleep(3000);

            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            for (WebElement link : allLinks) {
                if (link.getText().startsWith("1000")) {
                    System.out.println("Created order Id: " + link.getText());
                }
            }

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("F:\\User\\SWTPic\\selenium-webdriver-java-master\\src\\test\\java\\TestCase06.png");
            FileUtils.copyFile(scrFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}

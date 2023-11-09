package BAITAP;

import driver.driverFactory;
import model.pages.CartPage;
import model.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
/*  Verify Discount Coupon works correctly

Test Case Description:

1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated

TestData:  Coupon Code: GURU50

Expected result:

1) Price is discounted by 5%

*/
public class TestCase9 {
    @Test
    public void TestCase9()  {


        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
        try {
            HomePage homepage = new HomePage(driver);
        homepage.clickMobileLink();
        Thread.sleep(2000);
        // click add to cart for iphone
            homepage.addIphoneToCart();
            CartPage cartPage = new CartPage(driver);

            String pricebefor = cartPage.getGrandTotal();
            System.out.println("Price before discount: " + pricebefor);
            cartPage.enterDiscountCode("GURU50");
            cartPage.clickApplyDiscount();
            Thread.sleep(2000);
            String priceAfter = cartPage.getGrandTotal();
            System.out.println("Price after discount: " + priceAfter);

                Assert.assertNotEquals(pricebefor, priceAfter);
                Thread.sleep(2000);

        }  catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}

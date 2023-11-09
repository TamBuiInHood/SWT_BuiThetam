package BAITAP;

import driver.driverFactory;
import model.pages.RegisterPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/* Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.

 */
public class TestCase5 {
    @Test
    public void Testcase05(){
        String firstName = "TheTam";
        String lastName = "Bui";
        String email = "thetam1410022@gmail.com";
        String password = "123456";
        String confirmPassword = password;

        WebDriver driver = driverFactory.getChromeDriver();
        try{
            //Step 1. Goto http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);
            //Step 2. go to account and click link register
            registerPage.clickMyAccountLink();
            // switch page
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.clickCreateAccountLink();
            Thread.sleep(2000);
            // switch page to input info
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.enterFirtstName(firstName);
            registerPage.enterLastName(lastName);
            registerPage.enterEmail(email);
            registerPage.enterPassword(password);
            registerPage.enterConfirmPassword(confirmPassword);
            registerPage.clickRegisterButton();
            Thread.sleep(2000);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // Step 4: Verify Registration is done. Expected account registration done.
            WebElement successMessage = driver.findElement(By.cssSelector(".welcome-msg"));
            Assert.assertEquals(successMessage.getText(),"WELCOME, THETAM BUI!");

            // Step 5: Go to TV menu
            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
            tvMenu.click();
            Thread.sleep(1000);
            // Step 6: Add product in your wish list - use product - LG LCD
            WebElement lgLcdAddToWishlist = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
            lgLcdAddToWishlist.click();
            Thread.sleep(1000);

            // Step 7: Click SHARE WISHLIST
            WebElement shareWishlistLink = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareWishlistLink.click();
            Thread.sleep(1000);

            // Step 8: In next page enter Email and a message and click SHARE WISHLIST -- input field
            WebElement emailInputWishlist = driver.findElement(By.id("email_address"));
            emailInputWishlist.sendKeys("test@gmail.com");
            WebElement messageInput = driver.findElement(By.id("message"));
            messageInput.sendKeys("Check out my wishlist!");
            WebElement shareWishlistButton = driver.findElement(By.cssSelector("button[title='Share Wishlist'] span span"));
            shareWishlistButton.click();
            Thread.sleep(1000);
            // Step 9: Check wishlist is shared. Expected wishlist shared successfully.
            String wishlistSharedMessage = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span")).getText();
            Assert.assertEquals(wishlistSharedMessage,"Your Wishlist has been shared.");

            //take screen shot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("F:\\User\\SWTPic\\selenium-webdriver-java-master\\src\\test\\java\\TestCase05.png");
            FileUtils.copyFile(scrFile, new File(png));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}

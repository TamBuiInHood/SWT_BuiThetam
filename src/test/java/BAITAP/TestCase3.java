package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class TestCase3 {

    /*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile

4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available.

5. Verify the error message

6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty
     */
    public void testCase3(){
        int scc = 0;
        StringBuffer verificationErrors = new StringBuffer();
        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            // step 1: go to web
            driver.get ("http://live.techpanda.org/");
            //click MOBILE
            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > header:nth-child(2) > div:nth-child(1) > div:nth-child(4) > nav:nth-child(1) > ol:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
            // click �ADD TO CART� for Sony Xperia mobile
            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
            WebElement passwordElem = driver.findElement(By.cssSelector("input[title='Qty']"));
            Thread.sleep(2000);
            //6. Input 1000 to Quanity field
            passwordElem.sendKeys("1000");
            driver.findElement(By.cssSelector("button[title='Update']")).click();
            String exceedquantity = driver.findElement(By.cssSelector("li[class='error-msg'] ul li span")).getText();
            try {
                AssertJUnit.assertEquals("The requested quantity for 'Sony Xperia' is not available", exceedquantity);
                Thread.sleep(2000);
            } catch (Error er){
                verificationErrors.append(er.toString());
            }
            driver.findElement(By.cssSelector("button[id='empty_cart_button'] span span")).click();
            String emptyCartMess = driver.findElement(By.cssSelector("div[class='page-title'] h1")).getText();
            try {
                AssertJUnit.assertEquals("SHOPPING CART IS EMPTY", emptyCartMess);
                Thread.sleep(2000);
            } catch (Error er){
                verificationErrors.append(er.toString());
            }
            // take screen shot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("F:\\User\\SWTPic\\selenium-webdriver-java-master\\src\\test\\java\\TestCase03.png");
            FileUtils.copyFile(scrFile, new File(png));
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}

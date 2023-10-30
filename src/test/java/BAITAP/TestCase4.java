package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/


@Test
public class TestCase4 {
    public void TestCase4(){
        StringBuffer verificationErrors = new StringBuffer();
        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            // step 1: go to web
            driver.get ("http://live.techpanda.org/");
            //click MOBILE
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);
            // click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
            WebElement sonyXperiaCompare = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            sonyXperiaCompare.click();
            WebElement iPhoneCompare = driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            iPhoneCompare.click();
            //4. Click on �COMPARE� button. A popup window opens
            driver.findElement(By.cssSelector("button[title='Compare'] span span")).click();
            // pop up window
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);
            //popup window check
            String comparePageHeader = driver.findElement(By.cssSelector("div[class='page-title title-buttons'] h1")).getText();
            try {
                AssertJUnit.assertEquals("COMPARE PRODUCTS", comparePageHeader);
                Thread.sleep(2000);
            } catch (Error er){
                verificationErrors.append(er.toString());
            }
            driver.findElement(By.cssSelector("button[title='Close Window']")).click();
            Thread.sleep(2000);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

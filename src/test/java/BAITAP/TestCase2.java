package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/

public class TestCase2 {
    @Test
    public void TestCase2(){
        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            //2. Open target page
            //Step 1: Goto http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");


             //Step 2: Click on �MOBILE� menu
            WebElement moblieLink = driver.findElement(new By.ByCssSelector("body > div:nth-child(1) > div:nth-child(2) > header:nth-child(2) > div:nth-child(1) > div:nth-child(4) > nav:nth-child(1) > ol:nth-child(1) > li:nth-child(1) > a:nth-child(1)"));
            moblieLink.click();

            Thread.sleep(2000);


             //Step 3: In the list of all mobile , read the cost
             //of Sony Xperia mobile (which is $100)
            WebElement sonyXPrice = driver.findElement(new By.ByCssSelector("span[id='product-price-1'] span[class='price']"));
            // convert to double instance
            double price = Double.parseDouble(sonyXPrice.getText().substring(1));


             //Step 4: Click on Sony Xperia mobile
            WebElement sonyXLink = driver.findElement(new By.ByCssSelector("a[title='Sony Xperia']"));
            sonyXLink.click();
            Thread.sleep(2000);

             //Step 5: Read the Sony Xperia mobile from detail page.
            WebElement sonyXDetailPrice = driver.findElement(new By.ByCssSelector(".price"));
            String validPrice = sonyXDetailPrice.getText().substring(1);
            // convert to double instance
            double detailPrice = Double.parseDouble(validPrice);


             //Step 6: Compare Product value in list
             // and details page should be equal ($100).
            System.out.println("Sony Xperia Menu Price: " + price);
            System.out.println("Sony Xperia Detail Price: " + detailPrice);
            AssertJUnit.assertEquals(price, detailPrice);

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("F:\\User\\SWTPic\\selenium-webdriver-java-master\\src\\test\\java\\TestCase02.png");
            FileUtils.copyFile(scrFile, new File(png));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        // quit driver session
        driver.quit();
    }
}

package BAITAP;

import com.sun.jna.WString;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/
@Test
public class TestCase1 {
    public static void testTC01(){
        int scc = 0;

        StringBuffer verificationErrors = new StringBuffer();

    //Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
        //Step 1. Goto http://live.techpanda.org/
            driver.get ("http://live.techpanda.org/");
        //Step 2. Verify Title of the page
            String demoSite = driver.findElement(By.cssSelector("h2")).getText();
            System.out.println(demoSite);
            try {
                AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", demoSite);
            } catch (Error er){
                verificationErrors.append(er.toString());
            }
            //debug purposse only
            Thread.sleep(2000);
            // step 3
            driver.findElement(By.linkText("MOBILE")).click();
            //debug pupose only
            Thread.sleep(2000);
            //step 5 In the list of all movle, selcet SORT BY dropdown as NAME
            WebElement dropdownElement = driver.findElement(By.cssSelector("select[title=\"Sort By\"]"));
            //4. Init a Select Option instance
            Select selectOption = new Select(dropdownElement);
            //select options in dropdown list by Text
            selectOption.selectByVisibleText("Name");
            Thread.sleep(2000);
            // step 6. verify all product are are ssorted by name
            // this will take a screen shot of the manager's page after succeffully login
            WebElement pro1 = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='IPhone']"));
            WebElement pro2 = driver.findElement(new By.ByCssSelector("h2[class='product-name'] a[title='Samsung Galaxy']"));
            WebElement pro3 = driver.findElement(new By.ByCssSelector("a[title='Sony Xperia']"));
            AssertJUnit.assertEquals("IPHONE", pro1.getText());
            AssertJUnit.assertEquals("SAMSUNG GALAXY", pro2.getText());
            AssertJUnit.assertEquals("SONY XPERIA", pro3.getText());

            //debug purpose only
            Thread.sleep(2000);

            // ScreenShot Capture
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("F:\\User\\SWTPic\\selenium-webdriver-java-master\\src\\test\\java\\TestCase01.png");
            FileUtils.copyFile(scrFile, new File(png));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        driver.quit();
    }
}

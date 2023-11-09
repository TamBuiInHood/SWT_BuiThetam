package BAITAP;

import driver.driverFactory;
import model.pages.AdminPage;
import model.pages.BackEndLogin;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

/*

/*--------------------------TESTCASE10---------------------------------*/

//The client wants you to work on the scenario “Screenshot capture OrderId by condition”

/*
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Input OrderId and FromDate -> ToDate
5. Click Search button
6. Screenshot capture.

*/

public class TestCase10 {
    @Test
    public void TestCase10(){
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            String username = "user01";
            String password = "guru99com";
            String orderID = "100021269";
            String fromDate = "11/2/2023";
            String toDate = "20/12/2023";

            //1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            //2. Login the credentials provided
            BackEndLogin backEndLogin = new BackEndLogin(driver);
            backEndLogin.enterUsername(username);
            backEndLogin.enterPassword(password);
            backEndLogin.clickLogin();
            Thread.sleep(2000);

            AdminPage adminPage = new AdminPage(driver);
            // close pop up
            adminPage.clickClosePopup();
            //3. Go to Sales-> Orders menu
            adminPage.clickSaleLink();
            adminPage.clickOrderMenu();


            //4. Input OrderId and FromDate -> ToDate
            adminPage.enterOrderId(orderID);
            adminPage.enterFromDate(fromDate);
            adminPage.entertToDate(toDate);
            //5. Click Search button
            Thread.sleep(2000);
            adminPage.clickSearchBtn();
            Thread.sleep(2000);
            //6. Screenshot capture.
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("F:\\User\\SWTPic\\selenium-webdriver-java-master\\src\\test\\java\\TestCase10.png");
            FileUtils.copyFile(scrFile, new File(png));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        driver.quit();
    }
}

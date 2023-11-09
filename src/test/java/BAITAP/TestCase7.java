package BAITAP;

import driver.driverFactory;
import model.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class TestCase7 {
    @Test
    public void Testcase07() {
        String email = "thetam1410011@gmail.com";
        String password = "123456";

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

            driver.findElement(By.linkText("MY ORDERS")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[normalize-space()='View Order']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[@class='link-print']")).click();
            Thread.sleep(5000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("F:\\User\\SWTPic\\selenium-webdriver-java-master\\src\\test\\java\\TestCase07.png");
            FileUtils.copyFile(scrFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

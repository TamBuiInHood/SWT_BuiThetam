package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    By MoblieLink = By.xpath("//a[normalize-space()='Mobile']");

    By IPhoneLink = By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]");

    private WebDriver driver;

    public HomePage(WebDriver driver){this.driver = driver;}

    public void clickMobileLink(){
        WebElement moblieLink = driver.findElement(MoblieLink);
        moblieLink.click();
    }

    public void addIphoneToCart(){
        WebElement iphoneLink = driver.findElement(IPhoneLink);
        iphoneLink.click();
    }
}
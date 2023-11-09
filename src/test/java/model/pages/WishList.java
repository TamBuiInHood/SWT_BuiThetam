package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishList {

    WebDriver driver;

    By addToCartBtn = By.xpath("//span[contains(text(),'Add to Cart')]");

    public WishList(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }
}

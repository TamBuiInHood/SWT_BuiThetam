package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackEndLogin {
    By Usernmame = By.xpath("//input[@id='username']");
    By Password = By.xpath("//input[@id='login']");

    By loginBtn = By.xpath("//input[@title='Login']");
    private WebDriver driver;

    public BackEndLogin(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        WebElement usernameEle = driver.findElement(Usernmame);
        usernameEle.clear();
        usernameEle.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordEle = driver.findElement(Password);
        passwordEle.clear();
        passwordEle.sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
}

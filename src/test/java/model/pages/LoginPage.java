package model.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
        WebDriver driver;

        By MyAccountLink = By.linkText("MY ACCOUNT");
        By emailInput = By.id("email");
        By passwordInput = By.id("pass");
        By loginButton = By.id("send2");

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void clickMyAccountLink(){
            driver.findElement(MyAccountLink).click();
        }

        public void enterEmail(String email) {
            driver.findElement(emailInput).sendKeys(email);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordInput).sendKeys(password);
        }

        public void clickLoginButton() {
            driver.findElement(loginButton).click();
        }
    }


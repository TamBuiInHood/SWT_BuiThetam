package model.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class RegisterPage {
    WebDriver driver;

    //
    By MyAccountLink = By.linkText("MY ACCOUNT");
    By CreateAccountLink = By.linkText("CREATE AN ACCOUNT");
    By FirstNameRegister = By.id("firstname");
    By LastNameRegister = By.id("lastname");
    By EmailRegister = By.id("email_address");
    By PasswordRegister = By.id("password");
    By ConfirmPasswordRegister = By.id("confirmation");
    By RegisterBtn = By.xpath("//span[contains(text(),'Register')]");

    public  RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickMyAccountLink(){
        driver.findElement(MyAccountLink).click();
    }

    public void clickCreateAccountLink(){
        driver.findElement(CreateAccountLink).click();
    }
    public void enterFirtstName(String firstName){
        WebElement firstNameElement = driver.findElement(FirstNameRegister);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        WebElement lastNameElement = driver.findElement(LastNameRegister);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterEmail(String email){
        WebElement emailElement = driver.findElement(EmailRegister);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordElement = driver.findElement(PasswordRegister);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword){
        WebElement confirmPasswordElement = driver.findElement(ConfirmPasswordRegister);
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void clickRegisterButton(){
        driver.findElement(RegisterBtn).click();
    }

}

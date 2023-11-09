package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
    By SaleLink = By.xpath("//span[normalize-space()='Sales']");

    By OrderMenu = By.xpath("//span[normalize-space()='Orders']");

    By OrderId = By.xpath("//input[@id='sales_order_grid_filter_real_order_id']");

    By FromDate = new By.ByName("created_at[from]");
    By ToDate = new By.ByName(   "created_at[to]");

    By SearchBtn = By.xpath("//span[contains(text(),'Search')]");

    By ClosePopup = By.xpath("//span[normalize-space()='close']");
    WebDriver driver;

    public AdminPage(WebDriver driver){this.driver = driver;}

    public void clickClosePopup(){
        driver.findElement(ClosePopup).click();
    }
    public void clickSaleLink(){
        driver.findElement(SaleLink).click();
    }

    public void clickOrderMenu(){
        driver.findElement(OrderMenu).click();
    }

    public void enterOrderId(String orderID){
        WebElement orderIdEle = driver.findElement(OrderId);
        orderIdEle.clear();
        orderIdEle.sendKeys(orderID);
    }

    public void enterFromDate(String fromDate){
        WebElement fromDateEle = driver.findElement(FromDate);
        fromDateEle.clear();
        fromDateEle.sendKeys(fromDate);
    }

    public void entertToDate(String toDate){
        WebElement toDateEle = driver.findElement(ToDate);
        toDateEle.clear();
        toDateEle.sendKeys(toDate);
    }

    public void clickSearchBtn(){
        driver.findElement(SearchBtn).click();
    }
}
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageElements
{
    WebDriver driver;

    @FindBy(id = "ui-id-5")
    public
    WebElement Mens;

    @FindBy(id= "ui-id-17")
    public
    WebElement Tops;

    @FindBy(id="ui-id-19")
    public
    WebElement Jackets;
    public By HotSellersProducts = By.xpath("//ol[@class='product-items widget-product-grid']/li");

    //initialising web driver from the main class
    public HomePageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}

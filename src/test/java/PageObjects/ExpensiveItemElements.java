package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensiveItemElements
{
    WebDriver driver;

    @FindBy(id="option-label-size-143-item-168")
    public static WebElement ProductSize;

    @FindBy(id = "option-label-color-93-item-53")
    public static WebElement ProductColor;

    @FindBy(name = "qty")
    public static WebElement ProductQuantity;

    @FindBy(id = "product-addtocart-button")
    public static WebElement AddToCartButton;

    @FindBy(css = ".action.showcart")
    public static WebElement CartIcon;

    @FindBy(id="product-price-334")
    public static WebElement ProductPrice;

    public ExpensiveItemElements(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

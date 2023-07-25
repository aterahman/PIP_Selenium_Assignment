package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageElements
{
    WebDriver driver;
    public CheckoutPageElements(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="customer-email")
    public static WebElement EmailInput;

    @FindBy(name="firstname")
    public static WebElement FirstNameInput;

    @FindBy(name="lastname")
    public static WebElement LastNameInput;

    @FindBy(name="company")
    public static WebElement CompanyInput;

    @FindBy(name="street[0]")
    public static WebElement AddressInput;

    @FindBy(name="city")
    public static WebElement CityInput;

    @FindBy(name="postcode")
    public static WebElement PostCodeInput;

    @FindBy(name="telephone")
    public static WebElement PhoneNumberInput;

    @FindBy(name="country_id")
    public static WebElement CountryDropDown;

    @FindBy(name="region_id")
    public static WebElement StateDropDown;

    @FindBy(name = "ko_unique_3")
    public static WebElement Shipping;

    @FindBy(css = ".button.action.continue.primary")
    public static WebElement NextButton;

    @FindBy(css =".action.primary.checkout")
    public static WebElement PlaceOrderBtn;
}

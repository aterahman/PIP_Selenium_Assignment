package PageEvents;

import Base.BaseTest;
import PageObjects.ExpensiveItemElements;
import Utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExpensiveItemEvents
{
    WebDriver driver;

    ExpensiveItemElements ex = new ExpensiveItemElements(BaseTest.driver);
    ElementFetch elementFetch = new ElementFetch();

    //initialising driver using constructor
    public ExpensiveItemEvents(WebDriver driver)
    {
     this.driver= driver;
    }

    //method to select product size
    public void SelectSize()
    {
        ex.ProductSize.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BaseTest.log.info("Size has been selected");
    }

    //method to select product color
    public void SelectColor()
    {
        ex.ProductColor.click();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        BaseTest.log.info("Color has been selected");
    }

    public void EnterQuantity()
    {
        //emptying the input box
        ex.ProductQuantity.clear();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        //entering quantity
        ex.ProductQuantity.sendKeys("2");

    }

    //method to click add to cart button
    public void ClickAddToCart()
    {
        BaseTest.log.info("Clicking add to cart button");

        //clicking add to cart button
        ex.AddToCartButton.click();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }


    public void ValidateCartIcon()
    {
        try {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(elementFetch.GetWebElement(By.cssSelector(".counter.qty")).getText());
    }

    public String ClickCartIcon()
    {

        driver.manage().timeouts().implicitlyWait(55,TimeUnit.SECONDS);

        ex.CartIcon.click();

        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);

        String MinicartPrice = elementFetch.GetWebElement(By.cssSelector(".minicart-price")).getText();

        return MinicartPrice;
    }

    public void ClickCheckoutButton()
    {
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        BaseTest.log.info("Clicking checkout button");
        elementFetch.GetWebElement(By.id("top-cart-btn-checkout")).click();
    }
}

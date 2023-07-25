package PageEvents;

import Base.BaseTest;
import PageObjects.HomePageElements;
import Utils.ElementFetch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageEvents
{
    HomePageElements he = new HomePageElements(BaseTest.driver);

    ElementFetch elementFetch = new ElementFetch();
    WebDriver driver;

    public HomePageEvents(WebDriver driver)
    {
        this.driver = driver;
    }

    //method to check for the number of products in hot sellers
    public int ValidateHotSellersCount()
    {
        BaseTest.log.info("Getting all the products from hot sellers section");

        //list to store all web elements in hot sellers grid
        List<WebElement> HotSellerProducts = elementFetch.GetWebElements(he.HotSellersProducts);

        //list to store all products as string
        List<String> ProductNames = new ArrayList<>();


        for(WebElement product : HotSellerProducts) {

            String product_name = product.getText();

            ProductNames.add(product_name);

        }

        BaseTest.log.info("Number of Products in Hot sellers section = "+ProductNames.size());

        return ProductNames.size();

    }


    public void ClickOnJackets()
    {
        Actions action = new Actions(driver);

        action.moveToElement(he.Mens).perform();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        action.moveToElement(he.Tops).perform();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        he.Jackets.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }



}

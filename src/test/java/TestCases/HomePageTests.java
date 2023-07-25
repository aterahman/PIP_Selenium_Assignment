package TestCases;

import Base.BaseTest;
import PageEvents.HomePageEvents;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners
public class HomePageTests extends BaseTest
{

    @Test
    public void NumberOfProductsTest()
    {
        HomePageEvents hp = new HomePageEvents(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        log.info("Scrolling down");
        js.executeScript("window.scrollBy(0,1000)", "");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        log.info("Validating if Number of products in Hotsellers is greater than 1");
        Assert.assertTrue(hp.ValidateHotSellersCount()>1);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



}

package TestCases;

import Base.BaseTest;
import PageEvents.HomePageEvents;
import PageEvents.JacketPageEvents;
import PageObjects.ComparesPageElements;
import PageObjects.JacketsPageElements;
import Utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners
public class JacketsPageTests extends BaseTest
{

    @Test(priority = 1)
    public void GoToJacketsPageTest()
    {
        HomePageEvents hp = new HomePageEvents(driver);

        hp.ClickOnJackets();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        log.info("Checking wehther the Jackets page has opened");
        Assert.assertTrue(driver.getTitle().contains("Jackets"));
    }

    @Test(priority = 2)
    public void ApplyFiltersTest()
    {
        JacketPageEvents jp = new JacketPageEvents(driver);

        log.info("Entering Size filter");
        jp.SelectSize();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        log.info("Entering Color filter");
        jp.SelectColor();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        log.info("Checking whether the filters have been applied or not");
        Assert.assertTrue(jp.CheckFilters());

    }

    @Test(priority = 3)
    public void AddFirstJacketToCompare()
    {
        JacketPageEvents jp = new JacketPageEvents(driver);
        ElementFetch elementFetch = new ElementFetch();

        String FirstjacketName = elementFetch.GetWebElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong")).getText();

        String message = "You added product "+ FirstjacketName +" to the comparison list.";

        Assert.assertEquals(jp.AddingFirstToCompare(),message);
    }

    @Test(priority = 4)
    public void AddLastJacketToCompare()
    {
        JacketPageEvents jp = new JacketPageEvents(driver);
        ElementFetch elementFetch = new ElementFetch();

        driver.navigate().refresh();

        String LastjacketName = elementFetch.GetWebElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/strong")).getText();

        String message = "You added product "+ LastjacketName +" to the comparison list.";

        Assert.assertEquals(jp.AddingLastToCompare(),message);

    }

    @Test(priority = 5)
    public void ValidateCompareList()
    {
        JacketPageEvents jp = new JacketPageEvents(driver);
        ComparesPageElements cp = new ComparesPageElements(driver);

        log.info("Validating if the compare list has 2 items");
        Assert.assertEquals(jp.CompareItemsCount(),"2 items");

        log.info("Compare list validated");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        log.info("Clicking on the Compare button and going to compare page");
        jp.ClickCompareButton();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        log.info("Validating if the title of the page is Compare Products");
        Assert.assertEquals(cp.PageTitle.getText()  , "Compare Products");
    }

    @Test(priority = 6)
    public void ClearFiltersandComparisonsTest()
    {
        JacketPageEvents jp = new JacketPageEvents(driver);

        log.info("Going to the previous page");
        driver.navigate().back();

        log.info("Clearing Filters and the Comparison field");
        String Messagedisplayed = jp.ClearAllFields();

        log.info("validating if the message has been displayed after clearing comparison field");
        Assert.assertEquals(Messagedisplayed, "You cleared the comparison list.");
    }

    @Test(priority = 7)
    public void AddToCartTest()
    {
        JacketPageEvents jp = new JacketPageEvents(driver);

        jp.SortByPriceandSelectExpensiveItem();

    }

}

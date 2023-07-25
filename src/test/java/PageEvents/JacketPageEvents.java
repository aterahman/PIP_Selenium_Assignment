package PageEvents;

import Base.BaseTest;
import PageObjects.JacketsPageElements;
import Utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

//class that will perform all the actions and events related to the Jackets page
public class JacketPageEvents
{
    JacketsPageElements je = new JacketsPageElements(BaseTest.driver);
    ElementFetch elementFetch = new ElementFetch();

    WebDriver driver;

    public JacketPageEvents(WebDriver driver)
    {
     this.driver = driver;
    }

    public void SelectSize()
    {
        //clicking on size filter
        je.Size.click();
        BaseTest.log.info("Clickedon Size filter");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //clicking on medium
        je.Medium.click();
        BaseTest.log.info("Clicked on Medium");
    }

    public void SelectColor()
    {
        //clicking on color filter
        je.Color.click();
        BaseTest.log.info("Clicking on Color filter");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //clicking on medium
        je.Green.click();
        BaseTest.log.info("Clicked on Green");
    }



    //method to check what Filters have been applied
    public boolean CheckFilters()
    {
        BaseTest.log.info("Checking if filters have been applied");

        boolean filtersapplied = false, sizefilter=false, colorfilter = false;

        //storing all the filter elementes in a list
        List<WebElement> filters = elementFetch.GetWebElements(je.Filters);

        //iterating through list to check if the filters are present
        for(WebElement filter : filters) {

            //checking if the selected filters field has size filter
            if (filter.getText().contains("Size M")) {
                sizefilter = true;
            }

            //checking if the selected filters field has color filter
            if(filter.getText().contains("Color Green")){
                colorfilter=true;
            }

        }

        //checking if both size and color gilter have been applied
        if(sizefilter==true && colorfilter==true)
        {
            filtersapplied = true;
            BaseTest.log.info("Filters have been applied and validated");
        }

        return filtersapplied;
    }

    //method to add the first item to compare list and return the message shown after adding
    public String AddingFirstToCompare()
    {
        try {
            //initialising actions class object
            Actions actions = new Actions(driver);

            //initialising explicit wait class object
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            //hovering over the first item
            actions.moveToElement(je.FirstJacket).perform();
            BaseTest.log.info("hovered over the first item");

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            elementFetch.GetWebElement(By.cssSelector(".action.tocompare")).click();
            BaseTest.log.info("Added first item to compare list");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //explicitly waiting till the message is displayed
            wait.until(ExpectedConditions.visibilityOf(elementFetch.GetWebElement(By.cssSelector(".page.messages"))));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        BaseTest.log.info("Validating message after adding item");
        return elementFetch.GetWebElement(By.cssSelector(".page.messages")).getText();
    }

    //method to add the last item to compare list and return the message shown after adding
    public String AddingLastToCompare()
    {
        try {
            //initialising actions class object
            Actions actions = new Actions(driver);

            //initialising Javascript executor object to scrolll in page
            JavascriptExecutor js = (JavascriptExecutor) driver;

            //initialising explicit wait object
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            //refreshing page
            driver.navigate().refresh();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            //scrolling down
            js.executeScript("window.scrollBy(0,2000)", "");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //hovering over the last item
            actions.moveToElement(je.LastJacket).perform();
            BaseTest.log.info("hovered over the last item");

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            //clicking the add to compare button
            elementFetch.GetWebElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[4]/div/div[2]/a[2]")).click();
            BaseTest.log.info("Added last item to compare list");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //waiting until the message is visible
            wait.until(ExpectedConditions.visibilityOf(elementFetch.GetWebElement(By.cssSelector(".page.messages"))));


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        BaseTest.log.info("Validating message after adding to list");

        return elementFetch.GetWebElement(By.cssSelector(".page.messages")).getText();
    }

    public String CompareItemsCount()
    {
        //initialising explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));

        wait.until(ExpectedConditions.visibilityOf(je.CompareCount));

        String CompareProducts = je.CompareCount.getText();

        return CompareProducts;
    }

    public void ClickCompareButton()
    {
        je.CompareButton.click();
        BaseTest.log.info("Clicked on Compare items button");

    }

    public String ClearAllFields()
    {
        //initialising explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));

        //initialising Javascript executor object to scrolll in page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            je.ClearFiltersButton.click();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);

            //scrolling down
            js.executeScript("window.scrollBy(0,1800)", "");

            wait.until(ExpectedConditions.visibilityOf(je.ClearComparisonsButton));

            je.ClearComparisonsButton.click();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            elementFetch.GetWebElement(By.cssSelector(".action-primary.action-accept")).click();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            //explicitly waiting till the message is displayed
            wait.until(ExpectedConditions.visibilityOf(elementFetch.GetWebElement(By.cssSelector(".page.messages"))));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return elementFetch.GetWebElement(By.cssSelector(".page.messages")).getText();
    }

    //this method will sort all products by price and select the most expensive product
    public void SortByPriceandSelectExpensiveItem()
    {
        //initialising explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Select select = new Select(je.SortDropDown);
        select.selectByValue("price");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);

        //initialising Javascript executor object to scrolll in page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scrolling down
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //wait.until(ExpectedConditions.elementToBeSelected(je.MostExpensiveItem));

        //hovering over most expensive item
        actions.moveToElement(je.MostExpensiveItem).perform();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //click on product link
        elementFetch.GetWebElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[11]/div/div/strong/a")).click();

    }


}

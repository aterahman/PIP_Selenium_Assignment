package PageEvents;

import Base.BaseTest;
import PageObjects.CheckoutPageElements;
import Utils.CSVParserClass;
import Utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckoutEvents
{
    CheckoutPageElements cp = new CheckoutPageElements(BaseTest.driver);
    CSVParserClass csvp = new CSVParserClass();

    ElementFetch elementFetch = new ElementFetch();
    WebDriver driver;
    public CheckoutEvents(WebDriver driver) throws IOException {
        this.driver = driver;
        csvp.parsefile();
    }

    //method to enter email
    public void emailinput()
    {
        cp.EmailInput.sendKeys(csvp.email);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void firstnameinput()
    {

        cp.FirstNameInput.sendKeys(csvp.FirstName);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        try {
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void lastnameinput()
    {
        cp.LastNameInput.sendKeys(csvp.LastName);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void companyinput()
    {
        cp.CompanyInput.sendKeys(csvp.Company);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void addressinput()
    {
        cp.AddressInput.sendKeys(csvp.Address);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public void cityinput()
    {
        cp.CityInput.sendKeys(csvp.City);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void countryinput()
    {
        Select select = new Select(cp.CountryDropDown);
        select.selectByVisibleText("India");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void stateinput()
    {
        Select select  = new Select(cp.StateDropDown);
        select.selectByVisibleText("Karnataka");
    }
    public void postcodeinput()
    {
        cp.PostCodeInput.sendKeys(csvp.PostCode);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public void phonenumberinput()
    {
        cp.PhoneNumberInput.sendKeys(csvp.PhoneNumber);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void shippinginput()
    {
        cp.Shipping.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void PressNext()
    {
        try {
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        cp.NextButton.click();
    }

    public void PlaceOrder()
    {
        try {
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        cp.PlaceOrderBtn.click();
    }

    public String VerifyMessage()
    {
        try {
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       return elementFetch.GetWebElement(By.cssSelector(".page-title")).getText();
    }

}

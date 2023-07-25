package Utils;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch
{
    public WebElement GetWebElement(By selector)
    {
       return BaseTest.driver.findElement(selector);
    }

    public List<WebElement> GetWebElements(By selector)
    {
        return  BaseTest.driver.findElements(selector);
    }
}

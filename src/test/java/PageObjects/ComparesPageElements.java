package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparesPageElements
{
    WebDriver driver;
    @FindBy(css = ".page-title")
    public static WebElement PageTitle;

    public ComparesPageElements(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}

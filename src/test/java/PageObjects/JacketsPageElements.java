package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JacketsPageElements
{
    public static WebDriver driver;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[2]/div[1]")
    public static WebElement Size;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[2]/div[2]/div/div/a[3]/div")
    public static WebElement Medium;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[3]/div[1]")
    public static WebElement Color;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[3]/div[2]/div/div/a[4]/div")
    public static WebElement Green;

    @FindBy(id = "sorter")
           public WebElement SortDropDown;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]")
    public static WebElement FirstJacket;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]")
           public static WebElement LastJacket;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[3]/div[1]/div[1]/span")
            public static WebElement CompareCount;

    @FindBy(css = ".action.compare.primary")
    public static WebElement CompareButton;

    @FindBy(css=".action.clear")
    public static WebElement ClearComparisonsButton;

    @FindBy(css = ".action.clear.filter-clear")
    public static WebElement ClearFiltersButton;

    @FindBy(xpath = "/html/body/div[1]/main/div[3]/div[1]/div[3]/ol/li[11]")
    public static WebElement MostExpensiveItem;


    public By Filters = By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol");

    public JacketsPageElements(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}

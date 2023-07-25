package Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class BaseTest
{
    public static final Logger log = LogManager.getLogger(BaseTest.class);

    public static WebDriver driver;

   public static ExtentTest test;
    public static ExtentReports report;

    //setting up the driver before entering the test class
    @BeforeSuite
    public void SetUpDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        log.info("Driver is set up");
    }

    //creating extent report
    @BeforeSuite
    public static void startreport()
    {
        String date = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss").format(new java.util.Date());
        ExtentSparkReporter spark = new ExtentSparkReporter(date+"Spark.html");
        report = new ExtentReports();
        report.attachReporter(spark);
        test = report.createTest("ExtentReport");
    }

    //visiting url before every test
    @BeforeTest
    public void VisitUrl()
    {
        //opening url
        driver.get("https://magento.softwaretestingboard.com/");
        log.info("Opening url");

        //maximizing window
        driver.manage().window().maximize();
        log.info("Maximising browser window");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //closing reporter
    @AfterSuite
    public static void endTest()
    {
        report.flush();
    }

    //closing driver after test class
    @AfterSuite
    public void QuitDriver()
    {
     log.info("Closing driver");
        driver.close();
        driver.quit();
    }
}


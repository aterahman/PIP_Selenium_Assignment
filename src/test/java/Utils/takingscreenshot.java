package Utils;

import Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class takingscreenshot
{
    public static void getscreenshotfortestpass()throws IOException
    {

        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ","-").replace(":","-");
        System.out.println(screenshotfilename);

        File screenshotfile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotfile, new File(".//Passed_Test_screenshot//"+screenshotfilename+"test-pass.png"));
    }

    public static void getscreenshotfortestfail()throws IOException
    {

        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ","-").replace(":","-");
        System.out.println(screenshotfilename);

        File screenshotfile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotfile, new File(".//Failed_Test_Screenshot//"+screenshotfilename+"test-fail.png"));
    }
}

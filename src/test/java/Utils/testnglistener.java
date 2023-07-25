package Utils;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class testnglistener  implements ITestListener
{


    @Override
    public void onTestStart(ITestResult result)
    {
        BaseTest.log.info("Test has started"+result);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        BaseTest.log.info("PASSED TEST "+result);

        BaseTest.test.log(Status.PASS,"Passed test"+result);

        try
        {
            takingscreenshot.getscreenshotfortestpass();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        BaseTest.log.info("FAILED TEST "+result);
        BaseTest.test.log(Status.FAIL,"Failed Test"+result);
        try
        {
            takingscreenshot.getscreenshotfortestfail();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        /* compiled code */
    }
}
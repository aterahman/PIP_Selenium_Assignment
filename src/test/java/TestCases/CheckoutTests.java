package TestCases;

import Base.BaseTest;
import PageEvents.CheckoutEvents;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners
public class CheckoutTests extends BaseTest
{
    @Test
    public void InputDetailsTest() throws IOException {
        CheckoutEvents ce = new CheckoutEvents(driver);

        try {
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        log.info("Entering email");
        ce.emailinput();

        log.info("Entering first name");
        ce.firstnameinput();

        log.info("Entering last name");
        ce.lastnameinput();

        log.info("Entering Company name");
        ce.companyinput();

        log.info("Entering Address");
        ce.addressinput();

        log.info("Entering City");
        ce.cityinput();

        log.info("Entering country");
        ce.countryinput();

        log.info("Entering state");
        ce.stateinput();

        log.info("Entering zip code");
        ce.postcodeinput();

        log.info("Entering Phone Number");
        ce.phonenumberinput();

        log.info("Entering Shipping option");
        ce.shippinginput();

        log.info("Pressing next button");
        ce.PressNext();

        log.info("Placing order");
        ce.PlaceOrder();

        log.info("Verifying Congratulatory message");
        Assert.assertEquals(ce.VerifyMessage(),"Thank you for your purchase!");

    }
}


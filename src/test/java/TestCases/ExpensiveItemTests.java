package TestCases;

import Base.BaseTest;
import PageEvents.ExpensiveItemEvents;
import PageObjects.ExpensiveItemElements;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class ExpensiveItemTests extends BaseTest
{
    @Test
    public void EnterProductDetails()
    {
        ExpensiveItemEvents ex = new ExpensiveItemEvents(driver);
        ExpensiveItemElements exel = new ExpensiveItemElements(driver);

        ex.SelectSize();
        ex.SelectColor();
        ex.EnterQuantity();
        ex.ClickAddToCart();

        ex.ValidateCartIcon();

        log.info("Validating if Mini cart price is same as Product price");
        Assert.assertEquals(ex.ClickCartIcon(),exel.ProductPrice.getText());

        log.info("Minicart Price is Same as Product Price");

        ex.ClickCheckoutButton();

    }

}

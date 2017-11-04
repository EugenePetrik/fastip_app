import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;

public class TestScenarios extends AbstractTest {
    @Test(description = "Getting amount with default tip")
    public void amountWithDefaultTip() {
        MainPage defaultAmount = new MainPage(driver)
                .enterAmountAndClickCalculate("1000");

        Assert.assertTrue(defaultAmount.getTipAmount("$150.00"));
        Assert.assertTrue(defaultAmount.getTotalAmount("$1150.00"));
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;
import pageobjects.SettingPage;

public class TestScenarios extends AbstractTest {
    @Test(description = "Getting amount with default tip percentage")
    public void amountWithDefaultTip() throws Exception {
        MainPage defaultAmount = new MainPage(driver)
                .enterAmountAndClickCalculate("1000");

        Assert.assertTrue(defaultAmount.getTipAmount("$150.00"));
        Assert.assertTrue(defaultAmount.getTotalAmount("$1150.00"));
    }

    @Test(description = "Getting amount with custom tip percentage")
    public void amountWithCustomTip() throws Exception {
        MainPage mainPage = new MainPage(driver)
                .clickToSettings()
                .saveCustomTipPercentage("20.20")
                .enterAmountAndClickCalculate("2000");

        Assert.assertTrue(mainPage.getTipAmount("$404.00"));
        Assert.assertTrue(mainPage.getTotalAmount("$2404.00"));
    }

    @Test(description = "Getting amount with empty tip percentage")
    public void amountWithEmptyTip() throws Exception {
        MainPage mainPage = new MainPage(driver)
                .clickToSettings()
                .saveCustomTipPercentage("");

        Assert.assertEquals(new SettingPage(driver)
                .errorMessageIncorrectTipPercentage(), "Percentage must be a decimal value");
    }
}

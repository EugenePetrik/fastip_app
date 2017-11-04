import enums.Platform;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;
import pageobjects.SettingPage;

import static pageobjects.BasePage.platform;

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

        SettingPage emptyTip = new SettingPage(driver);

        if (platform.equals(Platform.IOS)) {
            Assert.assertEquals(emptyTip.errorIncorrectTipPercentage(), "Percentage must be a decimal value");
        } else if (platform.equals(Platform.ANDROID)) {
            Assert.assertEquals(emptyTip.errorIncorrectTipPercentage(), "A decimal value is required");
        }
    }
}

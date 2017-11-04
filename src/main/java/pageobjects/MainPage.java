package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MainPage extends BasePage {
    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initializePage();
    }

    @Override
    public MainPage initializePage() {
        return this;
    }

    @iOSFindBy(accessibility = "Settings")
    private MobileElement settings;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement checkAmount;

    @iOSFindBy(accessibility = "Calculate Tip")
    private MobileElement calculateTip;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private MobileElement tipAmount;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[4]")
    private MobileElement totalAmount;

    public MainPage enterAmountAndClickCalculate(String amount) {
        checkAmount.setValue(amount);
        calculateTip.click();

        return this;
    }

    public boolean getTipAmount(String value) {
        String tip = tipAmount.getText();

        return tip.equals(value);
    }

    public boolean getTotalAmount(String value) {
        String tip = totalAmount.getText();

        return tip.equals(value);
    }

    public SettingPage clickToSettings() {
        settings.click();

        return new SettingPage(driver);
    }
}

package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingPage extends BasePage {
    public SettingPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public SettingPage initializePage() {
        return this;
    }

    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "org.traeg.fastip:id/tipPercentageEditText")
    private MobileElement setTipPercentage;

    @iOSFindBy(accessibility = "Done")
    @AndroidFindBy(id = "org.traeg.fastip:id/saveSettingsButton")
    private MobileElement saveSettings;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Percentage must be a decimal value\"]")
    @AndroidFindBy(id = "android:id/message")
    private MobileElement invalidTipPercentage;

    public MainPage saveCustomTipPercentage(String tipPercentage) {
        setTipPercentage.clear();
        setTipPercentage.setValue(tipPercentage);

        saveSettings.click();

        return new MainPage(driver);
    }

    public String errorIncorrectTipPercentage() {
        return invalidTipPercentage.getText();
    }
}

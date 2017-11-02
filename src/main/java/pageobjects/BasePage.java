package pageobjects;

import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected static AppiumDriver<MobileElement> driver;
    public static Platform platform;

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }
}

package packages.driver.factory.web.local;

import org.openqa.selenium.WebDriver;
import packages.driver.manager.web.local.ChromeManager;
import packages.driver.manager.web.local.FirefoxManager;
import packages.enums.BrowserType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class LocalDriverFactory {

    private LocalDriverFactory(){}

    private static final Map<BrowserType, Supplier<WebDriver>> MAP=new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType)
    {
        return MAP.get(browserType).get();
    }
}

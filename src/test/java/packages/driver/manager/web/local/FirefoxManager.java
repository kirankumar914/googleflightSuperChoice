package packages.driver.manager.web.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager {

    private FirefoxManager(){};

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new FirefoxDriver();
    }
}

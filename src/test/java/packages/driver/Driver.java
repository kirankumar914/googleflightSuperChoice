package packages.driver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import packages.configs.factroy.ConfigFactory;
import packages.driver.factory.web.local.LocalDriverFactory;
import packages.driver.manager.web.local.ChromeManager;

public class Driver {
    public static WebDriver driver;
    public static void initDriver()
    {
        driver= ChromeManager.getDriver();
        driver=LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        driver.manage().window().maximize();
    }
}

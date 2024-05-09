package packages.driver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import packages.configs.factroy.ConfigFactory;
import packages.driver.factory.web.local.LocalDriverFactory;
import packages.driver.manager.web.local.ChromeManager;

@Slf4j
public class Driver {
    public static WebDriver driver;
    public static void initDriver()
    {

        driver=LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());
        driver.get(ConfigFactory.getConfig().applicationURL());
        driver.manage().window().maximize();
    }
}

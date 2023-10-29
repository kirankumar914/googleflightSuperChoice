package packages.runnerAndHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import packages.driver.Driver;

public class Hooks extends Driver {

    @Before
    public void setUp(){
        Driver.initDriver();
    }

    @After
    public void tearDown()
    {
//        driver.quit();
    }
}

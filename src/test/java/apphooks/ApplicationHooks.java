package apphooks;

import com.qa.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class ApplicationHooks {

    DriverFactory driverFactory ;
    WebDriver driver;
    @Before(order = 0)
    public void launchBrowser(){
        driverFactory=new DriverFactory();
        driver=driverFactory.init_driver();
    }
    @After(order = 0)
    public void quitBrowser(){
        DriverFactory.getDriver().quit();
    }
}

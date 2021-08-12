package jobcity.test.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari extends jobcity.test.core.AbstractDriver{
    @Override
    WebDriver initDriver() {
        WebDriverManager.edgedriver();
        return new SafariDriver();
    }
}

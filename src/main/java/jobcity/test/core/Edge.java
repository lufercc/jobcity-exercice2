package jobcity.test.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Edge extends jobcity.test.core.AbstractDriver{

    @Override
    WebDriver initDriver() {
        WebDriverManager.edgedriver();
        return new InternetExplorerDriver();
    }
}

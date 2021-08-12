package jobcity.test.core;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static final Map<String, jobcity.test.core.AbstractDriver> DRIVERS = new HashMap<>();

    static {
        DRIVERS.put("chrome", new Chrome());
        DRIVERS.put("edge", new Edge());
        DRIVERS.put("firefox", new FireFox());
    }

    public static WebDriver createDriver(String browser) {
        return DRIVERS.get(browser).initDriver();
    }
}

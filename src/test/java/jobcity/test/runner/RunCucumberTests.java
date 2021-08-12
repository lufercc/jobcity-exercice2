package jobcity.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/html/index.html",
                "json:reports/cucumber-reports/cucumber.json",
                "de.monochromata.cucumber.report.PrettyReports:reports/cucumber-reporting",
                "rerun:reports/rerun/rerun.txt"
        },
        features = "src/test/resources/scenarios",
        glue = "webui.test",
        tags = "@outline"
)
public class RunCucumberTests {

}

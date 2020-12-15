package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/feature", monochrome=true,
glue="step_definations",
plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/reports.html", "json:target/cucumber-report.json"}
)

public class Runner {

}

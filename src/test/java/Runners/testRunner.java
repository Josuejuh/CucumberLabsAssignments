package Runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//EXAMPLE OF REGRESSION TAG
@CucumberOptions(
        features = "src/test/java/Resources/scenario01.feature",
         tags = "@Regression",
        glue = {"StepDefinition"},
        plugin = {"html:target/cucumber-reports/cucumber-pretty", "json:target/json-cucumber-reports/default/CucumberJson.json",
                "testng:target/testng-cucumber-reports/CucumberTestng.xml"}
)

//EXAMPLE OF SMOKE TAG
//@CucumberOptions(
//        features = "src/test/java/Resources/lab08.feature",
//        tags = "@Smoke",
//        glue = {"StepDefinition"},
//        plugin = {"html:target/cucumber-reports/cucumber-pretty", "json:target/json-cucumber-reports/default/CucumberJson.json",
//                "testng:target/testng-cucumber-reports/CucumberTestng.xml"}
//)

public class testRunner extends AbstractTestNGCucumberTests
{

}
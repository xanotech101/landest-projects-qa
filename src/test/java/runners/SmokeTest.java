package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features is used to provide the path of all my feature files
        features = "src/test/resources/features/",
        glue = "steps",
        //when dry is set to true it stops actual execution and generates any missing step definition
        dryRun = true,
        tags = "@backOffice",
        monochrome = true, //to remove irrelevant information from the console
        plugin= {"pretty"}
)


public class SmokeTest {

}

package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features is used to provide the path of all my feature files
        features = "src/test/resources/features/",
        glue = "steps"
)


public class SmokeTest {

}

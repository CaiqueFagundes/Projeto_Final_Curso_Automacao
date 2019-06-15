
package curso.treinamento.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		    
		    plugin = {"pretty","html:target/cucumber"},
            format={"json:target/cucumber/cucumber.json"},
			features = {"src\\test\\resources\\features\\" },
			glue = {"curso.treinamento.steps", "curso.treinamento.setup"},
			snippets = SnippetType.CAMELCASE, 
			tags = {"@Login"} 
		)
public class RunnerTest {
}

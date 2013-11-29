package system.architecture.exercise.mvc.web.functional;

import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(parameterConverters=ParameterConverters.EnumConverter.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false, ignoreFailureInView = false)
@UsingSpring(resources = { "system/architecture/exercise/mvc/web/functional/configuration.xml",
           "system/architecture/exercise/mvc/web/functional/calculatorService-acceptancetest.xml" })
public class CalculatorFunctionalityTest extends InjectableEmbedder {

	@Test
	public void run() throws Throwable {
		injectedEmbedder().runStoriesAsPaths(storyPaths());
	}

	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromPath("src/test/resources"), "system/architecture/exercise/mvc/web/functional/*.story", "");
	}

}
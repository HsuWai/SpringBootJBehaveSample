package com.singtel.voucher.jbehave.story.livetest;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import java.util.Arrays;
import java.util.List;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * Common configuration for story to test
 *
 */
public abstract class AbstractStory extends JUnitStories {

    abstract String storyName();

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
          .useStoryLoader(new LoadFromClasspath(this.getClass()))
          .useStoryReporterBuilder(new StoryReporterBuilder()
            .withCodeLocation(codeLocationFromClass(this.getClass()))
            .withFormats(Format.CONSOLE, Format.TXT, Format.HTML));
    }
    
    @Override
    public Embedder configuredEmbedder() {
    		// TODO Auto-generated method stub
    	//Configuring meta filters (eg. skip - to exclude the scenario from testing)
    	Embedder embedder = super.configuredEmbedder();
    	embedder.useMetaFilters(Arrays.asList("-skip"));
    	return embedder;
    }

    abstract Object stepInstance();

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), stepInstance());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList(storyName());
    }

}

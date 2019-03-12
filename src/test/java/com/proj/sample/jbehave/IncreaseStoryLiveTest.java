package com.proj.sample.jbehave;

/**
 * Set up the stage to perform the steps for increase.story
 *
 */
public class IncreaseStoryLiveTest extends AbstractStory{
	
	@Override
	String storyName() {
		 return "increase.story";
	}
	
	@Override
	Object stepInstance() {
		return new IncreaseSteps();
	}
}

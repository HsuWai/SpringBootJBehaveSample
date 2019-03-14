package com.singtel.voucher.jbehave.story.livetest;

import com.singtel.voucher.jbehave.story.steps.IncreaseSteps;

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

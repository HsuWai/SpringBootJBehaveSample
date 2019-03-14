package com.singtel.voucher.jbehave.story.livetest;

import com.singtel.voucher.jbehave.story.steps.GetProductListSteps;

/**
 * Set up the stage to perform the steps for get_product_list.story
 *
 */
public class GetProductListLiveTest extends AbstractStory{

	@Override
	String storyName() {
		// TODO Auto-generated method stub
		return "get_product_list.story";
	}

	@Override
	Object stepInstance() {
		// TODO Auto-generated method stub
		return new GetProductListSteps();
	}

}

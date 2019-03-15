package com.singtel.voucher.jbehave.story.livetest;

import com.singtel.voucher.jbehave.story.steps.ViewProductSteps;

/**
 * Set up the stage to perform the steps for get_product_list.story
 *
 */
public class ViewProductLiveTest extends AbstractStory{

	@Override
	String storyName() {
		// TODO Auto-generated method stub
		return "view_product.story";
	}

	@Override
	Object stepInstance() {
		// TODO Auto-generated method stub
		return new ViewProductSteps();
	}

}

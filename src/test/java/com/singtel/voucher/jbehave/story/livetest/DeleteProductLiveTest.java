package com.singtel.voucher.jbehave.story.livetest;

import com.singtel.voucher.jbehave.story.steps.DeleteProductSteps;

/**
 * Set up the stage to perform the steps for delete_product.story
 *
 */
public class DeleteProductLiveTest extends AbstractStory{

	@Override
	String storyName() {
		// TODO Auto-generated method stub
		return "delete_product.story";
	}

	@Override
	Object stepInstance() {
		// TODO Auto-generated method stub
		return new DeleteProductSteps();
	}

}

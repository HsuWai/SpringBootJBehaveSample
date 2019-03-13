package com.proj.sample.jbehave;

/**
 * Set up the stage to perform the steps for edit_product.story
 *
 */
public class EditProductLiveTest extends AbstractStory{

	@Override
	String storyName() {
		// TODO Auto-generated method stub
		return "edit_product.story";
	}

	@Override
	Object stepInstance() {
		// TODO Auto-generated method stub
		return new GetProductListSteps();
	}

}

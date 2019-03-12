package com.proj.sample.jbehave;

/**
 * Set up the stage to perform the steps for get_product_list.story
 *
 */
public class CreateNewProductLiveTest extends AbstractStory{

	@Override
	String storyName() {
		// TODO Auto-generated method stub
		return "create_new_product.story";
	}

	@Override
	Object stepInstance() {
		// TODO Auto-generated method stub
		return new CreateNewProductSteps();
	}

}

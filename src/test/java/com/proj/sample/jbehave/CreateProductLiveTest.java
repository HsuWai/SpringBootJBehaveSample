package com.proj.sample.jbehave;

/**
 * Set up the stage to perform the steps for create_product.story
 *
 */
public class CreateProductLiveTest extends AbstractStory{

	@Override
	String storyName() {
		// TODO Auto-generated method stub
		return "create_product.story";
	}

	@Override
	Object stepInstance() {
		// TODO Auto-generated method stub
		return new CreateProductSteps();
	}

}

package com.proj.sample.jbehave;

import java.util.Random;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

public class IncreaseSteps {
	private int counter;
	private int previousValue;
	
	@Given("a counter")
	public void aCounter() {
	}
	
	@Given("the counter has any integral value")
	public void counterHasAnyIntegralValue() {
		counter = new Random().nextInt();
        previousValue = counter;
	}
	
	@When("the user increases the counter")
	public void increasesTheCounter() {
		counter++;
	}
	
	@Then("the value of the counter must be 1 greater than previous value")
	public void counterGreaterThanPreviousValue() {
		Assert.assertTrue(1 == counter - previousValue);
	}
}

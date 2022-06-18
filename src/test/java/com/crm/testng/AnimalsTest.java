package com.crm.testng;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnimalsTest
{
@Test(priority = 1,invocationCount =-2 )
public void elephantTest()
{
	System.out.println("big");
	Assert.fail();
}
@Test(dependsOnMethods = "elephantTest")
public void dogTest()
{
	System.out.println("medium");
}
@Test(priority = 3,invocationCount = 1)
public void ratTest()
{
	System.out.println("small");
}
}

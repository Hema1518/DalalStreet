package com.dalalstreet.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import ai.dalalstreet.testBase.TestBase;

public class LoginPageTest extends TestBase
{
	String expected_url="https://apps.dalalstreet.ai/dashboard";
	   
	@Test
	public void verifyLoginTest() throws InterruptedException
	{
		
		String actual_url=login.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}
	

}

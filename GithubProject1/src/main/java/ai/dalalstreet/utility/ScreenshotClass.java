package ai.dalalstreet.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import ai.dalalstreet.testBase.TestBase;

public class ScreenshotClass extends TestBase
{
   
	public ScreenshotClass()
	{
		PageFactory.initElements(driver,this);
	}
	
	//screenshot
	public static void takeScreenShot(String filename)//..method is static so as not to create object
	{
		try {
		String path="C:\\Users\\hp\\Desktop\\GitHub Files\\DalalStreet\\GithubProject1\\ScreenShot\\";
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src= ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
		}
		catch(IOException e)
		{
			System.out.println("IO Exception- file not found");
			e.printStackTrace();
		}
		
	}
}

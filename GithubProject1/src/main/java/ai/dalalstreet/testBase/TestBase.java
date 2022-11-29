package ai.dalalstreet.testBase;

import java.time.Duration;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ai.dalalstreet.PageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver;
	public LoginPage login;
	public static Logger logger;
	
	@BeforeClass
	public void start()
	{
		logger= Logger.getLogger("DalalStreet Auto framework");  //...it is for framework only
	    
	     
	    PropertyConfigurator.configure("Log4jFile.properties");
    //...apli file configure hty classes mdhe
	    logger.info("Framework execution started");
	}
	
	
	@AfterClass
	public void end()
	{
		 logger.info("Framework execution completed");
	}
	
	
	  @Parameters("browser")
      @BeforeMethod
	  public void setup(String br) throws InterruptedException     //...can give name setup,start,initialization
	  {                                                            //...String br="chrome";
    	 if(br.equalsIgnoreCase("chrome"))
    	 {
    		 WebDriverManager.chromedriver().setup();
   		     driver = new ChromeDriver();
    	 }
    	 else if(br.equalsIgnoreCase("firefox"))
    	 {
    		 WebDriverManager.firefoxdriver().setup();
   		     driver = new FirefoxDriver();
    	 }
    	 else if(br.equalsIgnoreCase("edge"))  
    		//...as we can use in any browser and need not to change browser--only change url and if version changes,can be done in pom.xml
        	 
    	 {
    		 WebDriverManager.edgedriver().setup();  //....driver is accessed in this block and treated as local 
   		     driver = new EdgeDriver();    //....variable and should make global variable
    	 }
    	 else
    	 {  		  System.out.println("Please provide correct browser");
    	 }
    	 
    	 
    	  driver.get("https://apps.dalalstreet.ai/login");
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  logger.info("url launches,maximize,and provided waits");
		  
		  
		//..........................Object Creation.............................
		  login = new LoginPage();
		
		  
		  //..........................Login Steps .............................
		    login.enterEmailID("amarwaghmare573@gmail.com");
			login.enterPassword("Test@1234");
			login.clickOnLoginButton();
			Thread.sleep(3000);
			logger.info("Login Successfully");
	  }
      
     
       @AfterMethod
       public void teardown()    //....teardown,end,close or browser name can be given any.
       {
    	  // driver.quit();
       }
}


//Here,selenium webdriver+java if-else ladder+testng @test is used by mixing.
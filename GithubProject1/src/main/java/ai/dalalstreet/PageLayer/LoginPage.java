package ai.dalalstreet.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.dalalstreet.testBase.TestBase;

public class LoginPage extends TestBase
{

	  public LoginPage()              //....constructor create through pagefactory
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  //---------------OBJECT REPOSITORY------------------
	  @FindBy(xpath="//input[@name='email']")   //..if change occurs in xpath/dome structure /CR then only change
	  private WebElement email_txt;             //..OBJECT REPOSITORY not ACTION METHODS and it remains constant.
	  
	  @FindBy(xpath="//input[@name='password']")
	  private WebElement password_txt;
	  
	  @FindBy(xpath="//button[text()='Log In']")
	  private WebElement login_btn;
	  
	  
	  //----------------ACTION METHODS-----------------------
	  public void enterEmailID(String email)
	  {
		  email_txt.sendKeys(email);
	  }
	  
	  
	  public void enterPassword(String password)
	  {
		  password_txt.sendKeys(password);
	  }
	  
	  
	  public void clickOnLoginButton()
	  {
		  login_btn.click();
	  }
	  
	  public String getCurrentUrl()
	  {
		  String url=driver.getCurrentUrl();
		  return url;
	  }
}

package test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
 
import pages.HomePagePolestar;
import pages.MainPage;
public class UITests {
	Playwright playwright;
	Browser browser;
	Page page;
	HomePagePolestar homeObj;
	MainPage main;

	@Parameters("br")
	 @BeforeClass
	  public void beforeMethod(@Optional("chrome")String br) throws InterruptedException {
		playwright = Playwright.create();
		switch (br) {
		case "chrome" : 
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		  	page = browser.newPage();
		  	System.out.println(br);
		  	break;
		  case "firefox" :
			  browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			  page = browser.newPage();
			  System.out.println(br);
			  break;
		  default:
			  	System.out.println("default");
 
		  
		  }
		homeObj = new HomePagePolestar(page);
		main= new MainPage(page);
	  }
	
  @Test(priority =0)
  public void navigateToHome() throws InterruptedException {
	  page.navigate("https://www.polestar.com/se/developer/get-started");
	  Thread.sleep(5000);
  }
  @Test(priority = 1,dependsOnMethods = {"navigateToHome"} )
  public void verifyPrompt() throws InterruptedException
  {
	  
	  Assert.assertFalse(homeObj.verifyButtonDisplayed(homeObj.acceptBtn));
	  Assert.assertTrue(homeObj.verifyButtonDisplayed(homeObj.rejectBtn));
	  homeObj.clickButton();
	  Thread.sleep(5000);

  }
  @Test(priority = 2)
  public void mainPageClick() throws InterruptedException {
	  Thread.sleep(5000);
	  main.returnHome();
  }

  @AfterClass
  public void afterMethod() {
	 page.close();
	 browser.close();
	 playwright.close();
  }
 
}

package pages;
 
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
 
public class MainPage {
	Page page;
	public Locator returnHomeBtn;
	public Locator image;
	public MainPage(Page page) {
		this.page = page;
		returnHomeBtn=page.locator("//span[text()='Return Home']");
		image=page.locator("img[alt='404 image']");
		
	}
	
	public void returnHome() throws InterruptedException
	{
		System.out.println(image.isVisible());
		returnHomeBtn.click();
		Thread.sleep(5000);
	}
 
}

package pages;
 
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
 
public class HomePagePolestar {
	Page page;
	public Locator acceptBtn;
	public Locator rejectBtn;
	public Locator viewBox;
 
	public HomePagePolestar(Page page) {
		this.page = page;
		acceptBtn = page.locator("#onetrust-accept-btn-handler");
		rejectBtn =page.locator("#onetrust-reject-all-handler");
	}
 
 
	public boolean verifyButtonDisplayed(Locator loc) {
		return loc.isVisible();
	}
	
	
	public void clickButton() {
		acceptBtn.click();
	}
}

package pages.commonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import configuration.Browser;
import utilities.DataProvider;

public class DashBoardPage {
	
	static By userNameDisplay = By.xpath("//div[@id='navbar']/ul[2]/li[3]/a/span[2]");
	static By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
	static double waitDuration = DataProvider.getWaitTime("WaitDuration");

	
	public static boolean isAt() {
		boolean ccLogin = false;
		try {
			Browser.instance.findElement(userNameDisplay);
	        ccLogin = true;
	        System.out.println("End of try block"); }
	    catch(Exception e){
	    	System.out.println("Inside catch block");
	    	 ccLogin = false; }
		return ccLogin;
	}

	public static void logOut() {
		//WebDriverWait wait = new WebDriverWait(Browser.instance,10);
		WebDriverWait wait = new WebDriverWait(Browser.instance,(long) waitDuration);
		wait.until(ExpectedConditions.elementToBeClickable(userNameDisplay));
		Browser.instance.findElement(userNameDisplay).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
		Browser.instance.findElement(logoutLink).click();
		
	}

}
package testset1;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import configuration.Browser;
import pages.commonPages.UserLoginPage;
import pages.commonPages.CashControlPage;
import pages.commonPages.DashBoardPage;

public class BaseTest {	
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser){
		System.out.println("browser passed as :- " + browser);
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		Assert.assertTrue(CashControlPage.isAt());
		CashControlPage.loginToACCGroup();
		Assert.assertTrue(DashBoardPage.isAt());
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
	
}
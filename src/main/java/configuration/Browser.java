package configuration;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser 
{

	public static WebDriver instance;
	
	//Launches the browser based on the testNG parameter passed - chrome, IE or Firefox
	public static void initialize(String browserName)
	{

		if (browserName.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromeDriver.exe");
		instance = new ChromeDriver();
		instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
		if (browserName.equalsIgnoreCase("IE"))
		{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\IEDriverServer.exe");
		instance = new InternetExplorerDriver();
		instance.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		
		else
		{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		instance = new FirefoxDriver();
		instance.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}
		instance.manage().window().maximize();
	}
	
	//Closes the current instance of the browser
	public static void instanceClose()
	{
	instance.close();	
	}
}
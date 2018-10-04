package testset1;		

import org.testng.Assert;		
import org.testng.annotations.Test;
import configuration.Browser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
	
	public class loginTests {	

			
		    @Test				
			public void testEasy() {	
				Browser.instance.get("http://demo.guru99.com/test/guru99home/");  
				String title = Browser.instance.getTitle();				 
				Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
			}	
			
		    @BeforeTest
		    @Parameters({ "Browser"})
			public void beforeTest(@Optional("Firefox")String browser){	
		    	
		    	System.out.println("browser passed as :- " + browser);
		    	Browser.initialize(browser);
			
		    }
		    
			@AfterTest
			public void afterTest() {
				Browser.instanceClose();		
			}			
}

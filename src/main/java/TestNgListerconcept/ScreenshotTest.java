package TestNgListerconcept;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenshotTest {
	
	@BeforeMethod
	public void setup() {
		
	}
	@AfterMethod
	public void tearDown() {
		
	}
	@Test
	public void takeScreenshotTest() {
		Assert.assertEquals(true, false);
	}

}

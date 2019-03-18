package LogsandReport;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoggerTest {
	static String configFilename="D:/workspace selenium/TurfMAVEN/log4j.properties";
	
	public static final Logger logger=Logger.getLogger(LoggerTest.class.getName());
	
	@BeforeClass
	public static void getlogger() {
		PropertyConfigurator.configure(configFilename);
	}
	
	@Test
      public void testlogger() {
    	  //getlogger();
    	  logger.info("log test1");
    	  logger.info("log test2");
    	  logger.info("log test3");
    	  logger.info("log test4");
      }
}

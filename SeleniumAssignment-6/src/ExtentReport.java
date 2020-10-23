import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReport {

	WebDriver driver;
	String url="https://www.google.com/";
	
	static ExtentTest Etest;
	static ExtentReports EReport;
	
	@Before
	public void setUp() throws Exception {
		
		EReport=new ExtentReports("F:\\API Testing Using Java\\SeleniumAssignment-6\\Report\\GeneratedReport.html",true);
		Etest=EReport.startTest("Generated Extent Report"); 
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium\\Selenium New Jar Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@After
	public void tearDown() throws Exception {
		EReport.endTest(Etest);
		EReport.flush();
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Extent Report");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='iblpc']")).click();
		
		if(driver.getTitle().equalsIgnoreCase("google")) 
		{
			Etest.log(LogStatus.PASS, "Successful Search Operation!");
		}
		else 
		{
			Etest.log(LogStatus.FAIL, "Unsuccessful Search Operation");
		}
		
	}

}

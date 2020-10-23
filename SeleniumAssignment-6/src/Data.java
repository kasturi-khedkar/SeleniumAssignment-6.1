import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Data {

	@Test(dataProvider = "dp")
	public void f(String value) {
		WebDriver driver;
		String url="https://www.google.com";

		System.setProperty("webdriver.chrome.driver","F:\\selenium\\Selenium New Jar Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(value);
		System.out.println("Successful Search for data : "+value);

	}

	@DataProvider(name="dp")
	public Object[][] dp() {
		Object[][] data=new Object[3][1];

		data[0][0]="Selenium";
		data[1][0]="Java";
		data[2][0]="Rest Assured";

		return data;

	}
}


package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex1_withOut_DDF 
{
public static void main(String[] args) throws InterruptedException 
{

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\VELOCITY\\Selenium\\file\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://kite.zerodha.com/");
	
	//enter UN
	driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("QJU802");
	//ENTER PSW
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("591295anuja");
	//CLICK ON LOGIN
	driver.findElement(By.xpath("//button[text()='Login ']")).click();
	//ENTER PIN
	driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("591295");
	//CLICK ON COUNTINUE
	driver.findElement(By.xpath("//button[text()='Continue ']")).click();
	
	// COMPARE ACTUAL & EXPECTED UN
	 String actual_id = driver.findElement(By.xpath("//span[@class='user-id']")).getText();
	
	String expected_id = "QJU802";
	
	if(actual_id.equals(expected_id))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	Thread.sleep(3000);
	driver.quit();
}
}

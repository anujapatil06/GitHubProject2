package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EX2_With_DDF_2nd_Aprroach
{
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
{
	FileInputStream file=new FileInputStream("C:\\Users\\user\\Desktop\\VELOCITY\\Selenium\\file\\kite.xlsx");
	Sheet sheet = WorkbookFactory.create(file).getSheet("sheet1");
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\VELOCITY\\Selenium\\file\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://kite.zerodha.com/");
	
	driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
	
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
	
	driver.findElement(By.xpath("//button[text()='Login ']")).click();
	driver.findElement(By.xpath("//input[@id='pin']")).sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
	
	driver.findElement(By.xpath("//button[text()='Continue ']")).click();
	
	String actualId = driver.findElement(By.xpath("//span[@class='user-id']")).getText();
	
	String expectedId = sheet.getRow(1).getCell(3).getStringCellValue();
	
	if(actualId.equals(expectedId))
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

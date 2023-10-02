package day1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice2 {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
        System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver-win64\\chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver(); // Invoke the chrome driver
	    
	    driver.get("https://demo.guru99.com/test/newtours/"); 
	    FileInputStream file = new FileInputStream("D:\\Automation Testing\\Practice1.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet("Sheet1");
	    int rowcount  = sheet.getLastRowNum();
	    System.out.println("No of Records in the Excel Sheet : "+rowcount);
	    for(int i =1; i<=rowcount; i++)
	    {
		   XSSFRow row = sheet.getRow(i);
		   
		   XSSFCell fname = row.getCell(0);
		   String First_name =fname.getStringCellValue();
		   
		   XSSFCell lname = row.getCell(1);
		   String Last_name =lname.getStringCellValue();
		   
		   XSSFCell phone = row.getCell(2);
		   int Phone = (int)phone.getNumericCellValue();
		   
		   XSSFCell email = row.getCell(3);
		   String Email = email.getStringCellValue();
		   
		   XSSFCell add = row.getCell(4);
		   String Address =add.getStringCellValue();
		   
		   XSSFCell city = row.getCell(5);
		   String City =city.getStringCellValue();
		   
		   XSSFCell state = row.getCell(6);
		   String State =state.getStringCellValue();
		   
		   XSSFCell pcode = row.getCell(7);
		   int Postal_Code =(int)pcode.getNumericCellValue();
		   
		   XSSFCell coun = row.getCell(8);
		   String Country =coun.getStringCellValue();
		   
		   XSSFCell uname = row.getCell(9);
		   String UserName =uname.getStringCellValue();
		   
		   XSSFCell pass = row.getCell(10);
		   String Password =pass.getStringCellValue();

		   //Registration Process
		   driver.findElement(By.linkText("REGISTER")).click();
	       Thread.sleep(500);
	       
//	       Contact Information 
	        driver.findElement(By.name("firstName")).sendKeys(String.valueOf(First_name));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("lastName")).sendKeys(String.valueOf(Last_name));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("phone")).sendKeys(String.valueOf(Phone));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("userName")).sendKeys(String.valueOf(Email));
	        Thread.sleep(100);
	        
//	        Mailing Information
	        driver.findElement(By.name("address1")).sendKeys(String.valueOf(Address));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("city")).sendKeys(String.valueOf(City));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("state")).sendKeys(String.valueOf(State));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("postalCode")).sendKeys(String.valueOf(Postal_Code));
	        Thread.sleep(100);
	        
	        WebElement dropdownElement = driver.findElement(By.xpath("//select[@name='country']")); // Change the locator method and value accordingly
	        
	        Select dropdown = new Select(dropdownElement);
	        
	        dropdown.selectByVisibleText(String.valueOf(Country));
	        Thread.sleep(100);
//	        User Information
	        driver.findElement(By.name("email")).sendKeys(String.valueOf(UserName));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("password")).sendKeys(String.valueOf(Password));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("confirmPassword")).sendKeys(String.valueOf(Password));
	        Thread.sleep(100);
	        
	        driver.findElement(By.name("submit")).click();
	        Thread.sleep(100);

	        if(driver.getCurrentUrl().contains("https://demo.guru99.com/test/newtours/register_sucess.php"))
	        {
	        	System.out.println("Registration Completed for " + i + " record");
	        }
	        else
	        {
	        	System.out.println("Registration Failed for " + i + "record");
	        }
	   }
	    driver.close();
	   driver.quit();
	}
	
	

}

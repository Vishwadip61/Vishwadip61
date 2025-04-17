package test2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QATest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		try {
		// Navigate to URL
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        
		// Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		
       //  Fill form and submit
		WebElement FirstName = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		FirstName.clear();

		WebElement LastName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		LastName.clear();
		
		FirstName.sendKeys("John");
		LastName.sendKeys("Doe");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		// validations
	
		
		   WebElement firstNameText = driver.findElement(By.xpath("//body[text()='Firstname: John']"));
           WebElement lastNameText = driver.findElement(By.xpath("//body[text()='Lastname: Doe']"));

           String expectedFirst = "Firstname: John";
           String expectedLast = "Lastname: Doe";

           
           if (firstNameText.getText().contains(expectedFirst)) {
               System.out.println("First name text is correct");
           } else {
               System.out.println("First name text is incorrect");
           }

           if (lastNameText.getText().contains(expectedLast)) {
               System.out.println("Last name text is correct");
           } else {
               System.out.println("Last name text is incorrect");
           }

		} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
	
	}

}

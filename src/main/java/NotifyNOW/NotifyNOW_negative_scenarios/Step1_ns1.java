package NotifyNOW.NotifyNOW_negative_scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Step1_ns1 extends Step4_ns {

	public void login_ns1() throws InterruptedException {

		driver.get("https://dev.notifynow.uk/login");

		WebElement useremail = driver.findElement(By.xpath("//input[@type='email']"));
		useremail.sendKeys(loginemail);

		WebElement userpwd = driver.findElement(By.xpath("//input[@type='password']"));
		userpwd.sendKeys(loginpwd);

		Thread.sleep(15000);

		WebElement Loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", Loginbtn);

		Thread.sleep(5000);
		String expectedurl = driver.getCurrentUrl();
		String actualurl = "https://dev.notifynow.uk/notifier/pending-estate-account";

		Assert.assertEquals(actualurl, expectedurl);

		Thread.sleep(5000);
		WebElement CEA1 = driver.findElement(By.xpath("/html/body/div[3]/nav/ul/li[2]/a/div[2]"));
		js.executeScript("arguments[0].click()", CEA1);

	}

	public void step1_ns1() throws InterruptedException {

		// Empty form submission
		WebElement step1submission = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[18]/div/button"));
		js.executeScript("arguments[0].click()", step1submission);

		WebElement addrrequrrmsg = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[3]/div/p"));
		if (addrrequrrmsg.isDisplayed()) {
			WebElement streetaddrss = driver.findElement(By.xpath("//input[@name='address']"));
			System.out.println("Negative scenario 2 passed !");
			streetaddrss.sendKeys(generateRandomString(1));

			Thread.sleep(1000);
			streetaddrss.sendKeys(Keys.ARROW_DOWN);
			streetaddrss.sendKeys(Keys.ARROW_DOWN);
			streetaddrss.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			streetaddrss.sendKeys(Keys.ENTER);

			Thread.sleep(3000);
			WebElement Zipcode = driver.findElement(By.id("zipcode"));
			System.out.println(Zipcode.getText());
			if (Zipcode.getText().isEmpty()) {
				Zipcode.sendKeys(generateRandomString(6));
			} else {
				System.out.println("Zipcode exists");
			}
		}
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", step1submission);
		
		WebElement phonenmbr = driver.findElement(By.xpath("//input[@name='phone_number']"));
		Thread.sleep(3000);
		WebElement phnnmbrerr = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[8]/div/div/p"));
		if (phnnmbrerr.isDisplayed()) {
			phonenmbr.sendKeys(generateRandomString(5));

			Thread.sleep(3000);
		}
		
		if (phnnmbrerr.isDisplayed()) {
			phonenmbr.sendKeys(generateRandomspecialchar(5));

			Thread.sleep(3000);
		}
		
		if (phonenmbr.getText().isEmpty()) {
			System.out.println("Phonenumber did not accept alphabets and special Characters!");
			phonenmbr.sendKeys(generateRandomNumber(10));
		}
		Thread.sleep(3000);
		
		WebElement relationshipdd = driver.findElement(By.xpath("//select[@name='relationship']"));
		
		WebElement reqrmsgrelation = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[9]/div/p"));
		if (reqrmsgrelation.isDisplayed()) {

			Thread.sleep(3000);
			Select relationdd = new Select(relationshipdd);
			relationdd.selectByIndex(randomint());
		}
		
		
		
	}
}

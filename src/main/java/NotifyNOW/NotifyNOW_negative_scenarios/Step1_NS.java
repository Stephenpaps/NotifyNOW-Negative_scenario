package NotifyNOW.NotifyNOW_negative_scenarios;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Step1_NS extends BaseClass_Negative_scenario {

	public void validlogin() throws InterruptedException {
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

		WebElement CEA1 = driver.findElement(By.xpath("/html/body/div[3]/nav/ul/li[2]/a/div[2]"));
		js.executeScript("arguments[0].click()", CEA1);

	}

	public void Step1_ns() throws InterruptedException {

		Thread.sleep(3000);
		// Empty form submission
		WebElement step1submission = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[18]/div/button"));
		js.executeScript("arguments[0].click()", step1submission);

		WebElement addrrequrrmsg = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[3]/div/p"));
		WebElement streetaddrss = driver.findElement(By.xpath("//input[@name='address']"));
		WebElement phonenmbr = driver.findElement(By.xpath("//input[@name='phone_number']"));
		WebElement relationshipdd = driver.findElement(By.xpath("//select[@name='relationship']"));
		WebElement formid = driver.findElement(By.xpath("//select[@name='id_type[]']"));
		WebElement formidnmbr = driver.findElement(By.xpath("//input[@name='formid_number[]']"));
		WebElement phnnmbrerr = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[8]/div/div/p"));
		WebElement reqerrmsgcontact = driver.findElement(By.xpath("//*[@id=\'contact_alert\']"));
		WebElement reqrmsgrelation = driver.findElement(By.xpath("//*[@id=\'stepOne\']/div/div[9]/div/p"));
		WebElement reqmsgformid = driver.findElement(By.xpath("//*[@id=\"addrow1\"]/div/div[1]/div/p"));
		WebElement Zipcode = driver.findElement(By.id("zipcode"));

		if (addrrequrrmsg.isDisplayed()) {

			System.out.println("Negative scenario 1 passed !");
			streetaddrss.sendKeys(generateRandomString(1));

			Thread.sleep(1000);
			streetaddrss.sendKeys(Keys.ARROW_DOWN);
			streetaddrss.sendKeys(Keys.ARROW_DOWN);
			streetaddrss.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			streetaddrss.sendKeys(Keys.ENTER);

			Thread.sleep(3000);

			System.out.println(Zipcode.getText());
			if (Zipcode.getText().isEmpty()) {
				Zipcode.sendKeys(generateRandomString(6));
			} else {
				System.out.println("Zipcode exists");
			}

			Thread.sleep(3000);

			if (phnnmbrerr.isDisplayed()) {
				phonenmbr.sendKeys(generateRandomString(5));

				Thread.sleep(3000);
			}

			if (phonenmbr.getText().isEmpty()) {
				System.out.println("Phonenumber did not accept alphabets!");
				phonenmbr.sendKeys(generateRandomNumber(10));
			}

			if (reqrmsgrelation.isDisplayed()) {

				Thread.sleep(3000);
				Select relationdd = new Select(relationshipdd);
				relationdd.selectByIndex(randomint());
			}

			Thread.sleep(3000);
			if (reqmsgformid.isDisplayed()) {
				Select formiddd = new Select(formid);
				formiddd.selectByIndex(3);

				Thread.sleep(3000);

				formidnmbr.sendKeys(generateRandomNumber(3) + generateRandomString(3));
			}
			Thread.sleep(3000);

			if (reqerrmsgcontact.isDisplayed()) {
				// Select random way of contacting radio button
				List<WebElement> addrstype = driver
						.findElements(By.xpath("//input[@name='avail_for_contact_checkbox[]']"));
				Random random = new Random();
				int addr = random.nextInt(addrstype.size());
				js.executeScript("arguments[0].click()", addrstype.get(addr));
			}

			Thread.sleep(3000);

			js.executeScript("arguments[0].click()", step1submission);

			Thread.sleep(3000);

			String title = driver.getTitle();
			if (title.equals("Step two")) {
				System.out.println("Successfully finished negative scenario and passed step 1.");
			}

		}
	}
}

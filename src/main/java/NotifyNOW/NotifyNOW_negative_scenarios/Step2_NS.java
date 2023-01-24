package NotifyNOW.NotifyNOW_negative_scenarios;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Step2_NS extends Step1_NS {

	public void Step2() throws InterruptedException {

		Thread.sleep(3000);

		WebElement submits2 = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", submits2);

		Thread.sleep(3000);
		WebElement erruappradiobtn = driver.findElement(By.xpath("//*[@id=\'checkbox-validate\']/p"));
		WebElement uappradiobtn = driver.findElement(By.xpath("//input[@id='stepTwoAgree']"));
		if (erruappradiobtn.isDisplayed()) {

			js.executeScript("arguments[0].click()", uappradiobtn);
		}

		Thread.sleep(3000);
		WebElement errdepartedFN = driver
				.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div/form/div[3]/div[1]/div/p"));
		WebElement departedFN = driver.findElement(By.xpath("//input[@id='first_name_of_departed']"));

		if (errdepartedFN.isDisplayed()) {
			departedFN.sendKeys(generateRandomspecialchar(4));
		}

		Thread.sleep(3000);
		WebElement errdepartedLN = driver
				.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div/form/div[3]/div[2]/div/p"));
		WebElement departedLN = driver.findElement(By.xpath("//input[@id='last_name_of_departed']"));
		if (errdepartedLN.isDisplayed()) {
			departedLN.sendKeys(generateRandomspecialchar(5));
		}

		Thread.sleep(3000);
		WebElement erraddrtype = driver.findElement(By.xpath("//*[@id=\'address_type_required\']/label"));
		List<WebElement> addrtype = driver.findElements(By.xpath("//input[@type='radio']"));
		if (erraddrtype.isDisplayed()) {
			Random random = new Random();
			int addr = random.nextInt(addrtype.size());
			js.executeScript("arguments[0].click()", addrtype.get(addr));
		}
		Thread.sleep(3000);

		WebElement rental = driver.findElement(By.id("rental"));

		Thread.sleep(3000);

		if (rental.isSelected()) {
			WebElement vacating = driver.findElement(By.id("vacating_home_date"));
			Thread.sleep(3000);
			vacating.sendKeys(date + month + deathyear);
		}

		Thread.sleep(3000);
		WebElement errpresentaddr = driver.findElement(By.xpath("//*[@id=\'presentAddress\']/div[5]/div[2]/div/div/p"));
		WebElement presentaddr = driver.findElement(By.xpath("//input[@name='present_address']"));
		if (errpresentaddr.isDisplayed()) {
			presentaddr.sendKeys(generateRandomString(1));
			Thread.sleep(1000);
			presentaddr.sendKeys(Keys.ARROW_DOWN);
			presentaddr.sendKeys(Keys.ARROW_DOWN);
			presentaddr.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
		}
		WebElement dateofbirth = driver.findElement(By.id("date_of_birth"));
		dateofbirth
				.sendKeys(generateRandomspecialchar(2) + "-" + generateRandomString(2) + "-" + generateRandomNumber(4));

		Thread.sleep(3000);
		WebElement dateofdeath = driver.findElement(By.id("date_of_death"));
		dateofdeath
				.sendKeys(generateRandomspecialchar(2) + "-" + generateRandomString(2) + "-" + generateRandomNumber(4));

		Thread.sleep(3000);
		WebElement presentzipcode = driver.findElement(By.id("present_zipcode"));
		if (presentzipcode.getAttribute("value").isEmpty()) {
			presentzipcode.sendKeys(generateRandomString(6));
		} else {
			System.out.println("Zipcode exists");
		}

		Thread.sleep(3000);
		WebElement formid = driver.findElement(By.xpath("//select[@id='identification_id']"));
		WebElement inputid = driver.findElement(By.xpath("//input[@id='id_number']"));
		Select formofid = new Select(formid);
		formofid.selectByIndex(2);
		Thread.sleep(3000);
		inputid.sendKeys(generateRandomString(5));

		Thread.sleep(3000);

		js.executeScript("arguments[0].click()", submits2);

		Thread.sleep(4000);

		WebElement DeceasedFNerr = driver
				.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div/form/div[3]/div[1]/div/p"));
		if (DeceasedFNerr.isDisplayed()) {
			departedFN.clear();
			System.out.println("Deceased first name doesn't accept Numbers and Special Characters.");
			departedFN.sendKeys(generateRandomString(5) + "'" + generateRandomString(1));
		}
		Thread.sleep(3000);
		WebElement DeceasedLNerr = driver
				.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div/form/div[3]/div[2]/div/p"));
		if (DeceasedLNerr.isDisplayed()) {
			System.out.println("Deceased Last name doesn't accept Numbers and Special Characters.");
			departedLN.clear();
			departedLN.sendKeys(generateRandomString(5));
		}
		Thread.sleep(3000);
		dateofbirth.clear();
		System.out.println("Date field not accepting special characters and Alphabets.");
		dateofbirth.sendKeys(date + month + birthyear);

		Thread.sleep(3000);
		dateofdeath.clear();
		dateofdeath.sendKeys(date + month + deathyear);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", submits2);
		Thread.sleep(3000);
		String title = driver.getTitle();

		if (title.equals("Step three")) {
			System.out.println("Successfully finished negative scenario and passed step 2.");
		}
	}
}

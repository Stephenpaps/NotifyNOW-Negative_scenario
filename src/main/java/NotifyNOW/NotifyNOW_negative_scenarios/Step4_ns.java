package NotifyNOW.NotifyNOW_negative_scenarios;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Step4_ns extends Step3_NS {
	public String accntdf = generateRandomString(5) + "-" + generateRandomNumber(3);
	public void step4() throws InterruptedException {
		Thread.sleep(3000);
		
		WebElement submitstep4 = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", submitstep4);
		
		String title = driver.getTitle();
		
		Thread.sleep(3000);
		if(title.equals("Step four")) {
			System.out.println("Select one company.");
		}
	
		Thread.sleep(3000);

		// Selecting EON next creditor from Dropdown
		WebElement creditordd = driver
				.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/form/div[1]/div[2]/div/div/div[1]/div"));
		js.executeScript("arguments[0].click()", creditordd);

		Thread.sleep(3000);

		WebElement eonnextcred = driver.findElement(By.xpath("//div[normalize-space()='Eonnext']"));
		js.executeScript("arguments[0].click()", eonnextcred);

		Thread.sleep(3000);

		//Selecting random utility type from the creditor
		WebElement eonnextdd = driver
				.findElement(By.xpath("//select[@id='asset_type2a01940f-2313-4aca-9914-a84fd15a5f99']"));
		Select utility = new Select(eonnextdd);
		utility.selectByIndex(randomddutility());

		Thread.sleep(2000);

		// If the utility is Dual fuel
		if (eonnextdd.getText().equals("Dual-Fuel")) {

			Thread.sleep(2000);

			WebElement dfaccnt = driver.findElement(By.xpath("//input[@name='utility_account_number[]']"));
			dfaccnt.sendKeys(accntdf);

			Thread.sleep(2000);

			WebElement dfaccnt2 = driver.findElement(By.xpath("//input[@name='confirm_utility_account_number[]']"));
			dfaccnt2.sendKeys(accntdf);

			Thread.sleep(2000);

			WebElement gasmeterreading = driver.findElement(By
					.xpath("//*[@id=\'2a01940f-2313-4aca-9914-a84fd15a5f99\']/div/div[2]/div[2]/div[3]/div[1]/input"));
			gasmeterreading.sendKeys(generateRandomNumber(2));

			Thread.sleep(2000);

			WebElement gasmeterdate = driver.findElement(By.xpath(
					"//*[@id=\'2a01940f-2313-4aca-9914-a84fd15a5f99\']/div/div[2]/div[2]/div[3]/div[2]/input"));
			gasmeterdate.sendKeys(date + month + deathyear);

			Thread.sleep(2000);

			WebElement electricmeterreading = driver.findElement(By.xpath(
					"//*[@id=\'2a01940f-2313-4aca-9914-a84fd15a5f99\']/div/div[2]/div[2]/div[4]/div[1]/input"));
			electricmeterreading.sendKeys(generateRandomNumber(2));

			Thread.sleep(2000);

			WebElement electricmeterdate = driver.findElement(By.xpath(
					"//*[@id=\'2a01940f-2313-4aca-9914-a84fd15a5f99\']/div/div[2]/div[2]/div[4]/div[2]/input"));
			electricmeterdate.sendKeys(date + month + deathyear);

			Thread.sleep(2000);

		} 
		// if the utility is other than dual fuel
		else {
			Thread.sleep(2000);
			WebElement accnt = driver.findElement(By.xpath("//input[@name='utility_account_number[]']"));
			accnt.sendKeys(accntdf);

			Thread.sleep(2000);
			WebElement accnt1 = driver.findElement(By.xpath("//input[@name='confirm_utility_account_number[]']"));
			accnt1.sendKeys(accntdf);

			WebElement cmr = driver.findElement(By.xpath("//input[@name='meter_read[]']"));
			cmr.sendKeys(generateRandomNumber(2));

			Thread.sleep(2000);
			WebElement cmrdate = driver.findElement(By.xpath("//input[@name='meter_read_date[]']"));
			cmrdate.sendKeys(date + month + deathyear);

		}

		Thread.sleep(3000);

		// Selecting random transfer radio button
		List<WebElement> transutility = driver.findElements(By.xpath("//input[@type='radio']"));
		Random random = new Random();
		int uti = random.nextInt(transutility.size());
		js.executeScript("arguments[0].click()", transutility.get(uti));

		Thread.sleep(2000);

		WebElement transferuti = driver
				.findElement(By.xpath("//input[@id='transfer-utility-0-2a01940f-2313-4aca-9914-a84fd15a5f99']"));

		Thread.sleep(2000);

		if (transferuti.isSelected()) {
			WebElement notifiertransfer = driver
					.findElement(By.xpath("//*[@id=\'notifier-0-2a01940f-2313-4aca-9914-a84fd15a5f99\']"));
			WebElement ongoingsupplytransfer = driver
					.findElement(By.xpath("//*[@id=\'other-0-2a01940f-2313-4aca-9914-a84fd15a5f99\']"));

			Thread.sleep(2000);
			List<WebElement> transferlist = Arrays.asList(notifiertransfer, ongoingsupplytransfer);
			Random random1 = new Random();
			int trans = random1.nextInt(transferlist.size());
			js.executeScript("arguments[0].click()", transferlist.get(trans));
			
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
			js.executeScript("arguments[0].click()", submit);
			Thread.sleep(3000);
			WebElement successtoast = driver.findElement(By.xpath("//div[@id='toast-container']"));

			if (successtoast.isDisplayed()) {
				System.out.println("Request submitted successfully.");
			}
		}
	}
		
	
		
			
		
}

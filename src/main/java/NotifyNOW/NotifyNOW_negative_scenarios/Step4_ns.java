package NotifyNOW.NotifyNOW_negative_scenarios;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Step4_ns extends Step3_NS {
	public String accntdf = generateRandomString(5) + "-" + generateRandomNumber(3);
	public String accntdf1 = generateRandomspecialchar(5);
	public String accntdf2 = generateRandomNumber(5);

	public void step4() throws InterruptedException, AWTException {
		Thread.sleep(3000);

		WebElement submitstep4 = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", submitstep4);

		String title = driver.getTitle();

		Thread.sleep(3000);
		if (title.equals("Step four")) {
			System.out.println("Select one company.");
		}

		Thread.sleep(3000);

		// Selecting EON next creditor from Dropdown
		WebElement creditordd = driver
				.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/form/div[1]/div[2]/div/div/div[1]/div"));
		js.executeScript("arguments[0].click()", creditordd);

		Thread.sleep(3000);

		WebElement eonnextcred = driver.findElement(By.xpath("//div[normalize-space()='Eon NEXT']"));
		js.executeScript("arguments[0].click()", eonnextcred);

		Thread.sleep(3000);

		// Selecting random utility type from the creditor
		WebElement eonnextdd = driver.findElement(By.xpath("//select[@name='asset_type[]']"));
		Select utility = new Select(eonnextdd);
		utility.selectByIndex(randomddutility());

		Thread.sleep(2000);

		WebElement accnt = driver.findElement(By.xpath("//input[@name='utility_account_number[]']"));
		Thread.sleep(2000);
		accnt.sendKeys(accntdf1);
		Thread.sleep(2000);
		if (accnt.getAttribute("value").isEmpty()) {
			accnt.sendKeys(accntdf);
		}

		Thread.sleep(2000);

		WebElement accnt2 = driver.findElement(By.xpath("//input[@name='confirm_utility_account_number[]']"));
		accnt2.sendKeys(accntdf1);
		Thread.sleep(2000);
		if (accnt2.getAttribute("value").isEmpty()) {
			accnt2.sendKeys(accntdf2);
		}

		Thread.sleep(2000);
		// If the utility is Dual fuel
		if (eonnextdd.getAttribute("value").equals("Dual-Fuel")) {

			Thread.sleep(2000);

			WebElement gasmeterreading = driver.findElement(By
					.xpath("//input[@class='meterRead storePropertyDraft assetNumber custom-validate step-four-validation rounded-l font-sans py-2 font-medium block text-base input border border-gray-400 appearance-none rounded w-full focus:border-tdr-blue filled']"));
			gasmeterreading.sendKeys(generateRandomNumber(2));

			Thread.sleep(2000);

			WebElement gasmeterdate = driver.findElement(By
					.xpath("//*[@id=\'1faf6ffa-aa6b-48a6-9e0a-fcdc9503df68\']/div/div[2]/div[2]/div[3]/div[2]/input"));
			gasmeterdate.sendKeys(
					generateRandomspecialchar(2) + "-" + generateRandomString(2) + "-" + generateRandomNumber(4));
			
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_TAB);
//			
//			robot.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			WebElement electricmeterreading = driver.findElement(By.xpath
					("//input[@class='meterRead assetNumber storePropertyDraft alphaNumericSymbolOnly custom-validate step-four-validation rounded-l font-sans py-2 font-medium block text-base input border border-gray-400 appearance-none rounded w-full focus:border-tdr-blue']"));
			electricmeterreading.sendKeys(generateRandomNumber(2));

			Thread.sleep(2000);

			WebElement electricmeterdate = driver.findElement(By
					.xpath("//*[@id=\'1faf6ffa-aa6b-48a6-9e0a-fcdc9503df68\']/div/div[2]/div[2]/div[4]/div[2]/input"));
			electricmeterdate.sendKeys(
					generateRandomspecialchar(2) + "-" + generateRandomString(2) + "-" + generateRandomNumber(4));

			Thread.sleep(2000);
		}
		// if the utility is other than dual fuel
		else {
			Thread.sleep(2000);
			WebElement cmr = driver.findElement(By.xpath("//input[@name='meter_read[]']"));
			cmr.sendKeys(generateRandomNumber(2));

			Thread.sleep(2000);
			WebElement cmrdate = driver.findElement(By.xpath("//input[@name='meter_read_date[]']"));
			cmrdate.sendKeys(
					generateRandomspecialchar(2) + "-" + generateRandomString(2) + "-" + generateRandomNumber(4));

		}

		Thread.sleep(3000);

		// Selecting random transfer radio button
		List<WebElement> transutility = driver.findElements(By.xpath("//input[@type='radio']"));
		Random random = new Random();
		int uti = random.nextInt(transutility.size());
		js.executeScript("arguments[0].click()", transutility.get(uti));

		Thread.sleep(2000);

		WebElement transferuti = driver.findElement(By.xpath("//input[@data-id='0']"));

		Thread.sleep(2000);

		if (transferuti.isSelected()) {
			System.out.println("Close Account is selected");
		} else {
			WebElement notifiertransfer = driver.findElement(By.xpath("//input[@value='Notifier']"));
			WebElement ongoingsupplytransfer = driver.findElement(By.xpath("//input[@value='Others']"));

			Thread.sleep(2000);
			List<WebElement> transferlist = Arrays.asList(notifiertransfer, ongoingsupplytransfer);
			Random random1 = new Random();
			int trans = random1.nextInt(transferlist.size());
			js.executeScript("arguments[0].click()", transferlist.get(trans));
		}

		Thread.sleep(3000);
		WebElement errcnfmacct = driver
				.findElement(By.xpath("//p[@class='validation invalid-feedback text-xs font-sans mt-2 text-red leading-4']"));
		if (errcnfmacct.isDisplayed()) {
			accnt2.clear();
			accnt2.sendKeys(accntdf);
			System.out.println("Confirm account number and account number must be equal.");
		}
		Thread.sleep(3000);
		if (eonnextdd.getAttribute("value").equals("Dual-Fuel")) {

			WebElement gasmeterdate = driver.findElement(By
					.xpath("//*[@id=\'1faf6ffa-aa6b-48a6-9e0a-fcdc9503df68\']/div/div[2]/div[2]/div[3]/div[2]/input"));
			gasmeterdate.clear();
			Thread.sleep(2000);
			gasmeterdate.sendKeys(date + month + deathyear);

			WebElement electricmeterdate = driver.findElement(By
					.xpath("//*[@id=\'1faf6ffa-aa6b-48a6-9e0a-fcdc9503df68\']/div/div[2]/div[2]/div[4]/div[2]/input"));
			electricmeterdate.clear();
			Thread.sleep(3000);
			electricmeterdate.sendKeys(date + month + deathyear);
			Thread.sleep(2000);

		} else {
			WebElement cmrdate = driver.findElement(By.xpath("//input[@name='meter_read_date[]']"));
			cmrdate.clear();
			Thread.sleep(3000);
			cmrdate.sendKeys(date + month + deathyear);

		}
		System.out.println("Datepicker not accepting special characters and alphabets.");
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

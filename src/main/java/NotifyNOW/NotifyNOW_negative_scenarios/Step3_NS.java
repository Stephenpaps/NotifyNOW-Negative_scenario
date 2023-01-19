package NotifyNOW.NotifyNOW_negative_scenarios;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Step3_NS extends Step2_NS {

	public void step3_ns() throws InterruptedException {

		Thread.sleep(3000);
		File filelocation = new File(directorypath);
		File[] totalfiles = filelocation.listFiles();

		File randfile = getRandomElement(totalfiles);

		System.out.println(randfile);
		String randomfile = randfile.toString();
		WebElement fileupload = driver.findElement(By.xpath(".//input[@type='file']"));

		if (fileupload.getText().isEmpty()) {
			fileupload.sendKeys(randomfile);
		}

		// Submitting Step 3
		WebElement submitfileupload = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", submitfileupload);

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.equals("Step four")) {
			System.out.println("Successfully finished negative scenario and passed step 3.");
		}
	}

}

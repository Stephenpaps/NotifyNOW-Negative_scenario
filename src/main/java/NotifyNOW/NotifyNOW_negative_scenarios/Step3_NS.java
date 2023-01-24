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

		// Selects random file from folder and uploads
		String randomfile = randfile.toString();
		WebElement fileupload = driver.findElement(By.xpath(".//input[@type='file']"));

		if (fileupload.getText().isEmpty()) {
			fileupload.sendKeys(randomfile);
		}

		Thread.sleep(3000);
		// Gives access to system camera and clicks image
		WebElement cameraupload = driver
				.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div/div[4]/form/div/div[1]"));
		js.executeScript("arguments[0].click()", cameraupload);

		Thread.sleep(3000);

		WebElement capture = driver.findElement(By.xpath("//button[@id='capture-btn']"));
		js.executeScript("arguments[0].click()", capture);

		Thread.sleep(3000);

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

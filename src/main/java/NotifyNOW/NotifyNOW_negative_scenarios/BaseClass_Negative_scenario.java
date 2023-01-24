package NotifyNOW.NotifyNOW_negative_scenarios;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Negative_scenario {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public String baseurl = "https://dev.notifynow.uk/login";
	public String loginemail = "stephen@yopmail.com";
	public String loginpwd = "Stephen123@";
	public String date = Integer.toString(randomdate());
	public String month = Integer.toString(randommonth());
	public String birthyear = Integer.toString(randomBirthYear());
	public String deathyear = Integer.toString(randomdeathYear());
	public String directorypath = "/home/stephen/Downloads/";

	@BeforeTest
	public void Browsersetup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("use-fake-ui-for-media-stream");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseurl);
		js = (JavascriptExecutor) driver;
	}

	public StringBuilder generateRandomString(int len) {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb;
	}

	public String generateRandomNumber(int len) {
		String chars = "012345678";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public String generateRandomspecialchar(int len) {
		String chars = "!@#$%^*()|<>?";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	static int randomBirthYear() {
		Random r = new Random();
		int low = 1967;
		int high = 1983;
		int result = r.nextInt(high - low) + low;
		return result;

	}

	static int randommonth() {
		Random r = new Random();
		int low = 10;
		int high = 12;
		int result = r.nextInt(high - low) + low;
		return result;

	}

	static int randomdate() {
		Random r = new Random();
		int low = 10;
		int high = 31;
		int result = r.nextInt(high - low) + low;
		return result;

	}

	static int randomdeathYear() {
		Random r = new Random();
		int low = 2010;
		int high = 2022;
		int result = r.nextInt(high - low) + low;
		return result;

	}

	static int randomint() {
		Random r = new Random();
		int low = 1;
		int high = 11;
		int result = r.nextInt(high - low) + low;
		return result;

	}

	public static <T> T getRandomElement(T[] arr) {
		return arr[ThreadLocalRandom.current().nextInt(arr.length)];
	}

	static int randomddutility() {
		Random r = new Random();
		int low = 1;
		int high = 3;
		int result = r.nextInt(high - low) + low;
		return result;

	}

	@Test(priority = 1)
	public void callmethod1() throws InterruptedException {
		Step1_NS s1 = new Step1_NS();
		s1.validlogin();
		s1.Step1_ns();

	}

	@Test(priority = 2)
	public void callmethod2() throws InterruptedException {
		Step2_NS s2 = new Step2_NS();
		s2.Step2();

	}

	@Test(priority = 3)
	public void callmethod3() throws InterruptedException {
		Step3_NS s3 = new Step3_NS();
		s3.step3_ns();

	}

	@Test(priority = 4)
	public void callmethod4() throws InterruptedException {
		Step4_ns s4 = new Step4_ns();
		s4.step4();

	}
}

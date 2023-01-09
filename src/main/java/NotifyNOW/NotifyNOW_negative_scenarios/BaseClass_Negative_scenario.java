package NotifyNOW.NotifyNOW_negative_scenarios;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Negative_scenario {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public String baseurl = "https://dev.notifynow.uk/login";
	public String loginemail = "stephen@yopmail.com";
	public String loginpwd = "Stephen123@";

	@BeforeTest
	public void Browsersetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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

	@Test(priority = 1)
	public void callmethod1() throws InterruptedException {
		Step1_NS s1 = new Step1_NS();
		s1.validlogin();
		s1.Step1_ns();

	}

}

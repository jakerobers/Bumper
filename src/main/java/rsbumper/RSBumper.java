package rsbumper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RSBumper {
	public static void main(String args[]) {

		String username = null;
		String password = null;
		String thread = null;
		String message = null;
		String driverLocation = null;

		for (int i = 0; i < args.length; i++) {
			String[] arg = args[i].split("=");
			if (arg[0].equals("--username") || arg[0].equals("-u")) {
				username = arg[1];
			} else if (arg[0].equals("--password")) {
				password = arg[1];
			} else if (arg[0].equals("--thread")) {
				thread = arg[1];
			} else if (arg[0].equals("--message")) {
				message = arg[1];
			} else if (arg[0].equals("--driver")) {
				driverLocation = arg[1];
			} else if (arg[0].equals("--help") || arg[0].equals("-h")) {
				System.out.println("See the github page for more information: ");
			} else {
				System.out.println("Unknown argument: " + arg[0] + ". use -h for options.");
			}
		}
		
		if (username == null) {
			System.err.println("Username must be provided!");
		}
		
		if (password == null) {
			System.err.println("Password must be provided!");
		}
		
		if (thread == null) {
			System.err.println("Thread must be provided!");
		}
		
		if (message == null) {
			System.err.println("Message must be provided!");
		}
		
		if (driverLocation == null) {
			System.err.println("Driver must be provided!");
		}	

		System.setProperty("webdriver.chrome.driver", driverLocation);	
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.runescape.com/a=13/community");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("header-login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-password")).sendKeys(password);
		driver.findElement(By.id("rs-login-submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Forums")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("searchThreads")).sendKeys(thread);
		driver.findElement(By.id("submitSearch")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("reply-box__area")).sendKeys(message);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Post']")).click();
		
		driver.close();

	}
}

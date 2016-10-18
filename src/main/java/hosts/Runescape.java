package hosts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Runescape extends Website implements WebsiteProperties {

	public Runescape() {
		super();
	}
	
	public Runescape(String username, String password, String thread, String message) {
		super(username, password, thread, message);
	}
	
	public void doAction(WebDriver driver) {
		driver.get("http://www.runescape.com/a=13/community");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("header-login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("login-username")).sendKeys(this.username);
		driver.findElement(By.id("login-password")).sendKeys(this.password);
		driver.findElement(By.id("rs-login-submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Forums")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("searchThreads")).sendKeys(this.thread);
		driver.findElement(By.id("submitSearch")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("reply-box__area")).sendKeys(this.message);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Post']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("reply-box__area"));

		driver.close();	
	}

	public boolean isValid() {
		boolean isValid = true;
		
		if (this.username == null) {
			System.err.println("Username must be provided!");
			isValid = false;
		}

		if (this.password == null) {
			System.err.println("Password must be provided!");
			isValid = false;
		}

		if (this.thread == null) {
			System.err.println("Thread must be provided!");
			isValid = false;
		}

		if (this.message == null) {
			System.err.println("Message must be provided!");
			isValid = false;
		}

		return isValid;
	}
}

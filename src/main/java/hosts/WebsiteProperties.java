package hosts;

import org.openqa.selenium.WebDriver;

public interface WebsiteProperties {
	public void doAction(WebDriver driver) throws InterruptedException;
	public boolean isValid();

}

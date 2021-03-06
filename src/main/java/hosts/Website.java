package hosts;

import org.openqa.selenium.WebDriver;

public class Website implements WebsiteProperties {


	protected String username;
	protected String password;
	protected String thread;
	protected String message;

	
	public Website() {
		
	}
	
	public Website(String username, String password, String thread, String message) {
		this.username = username;
		this.password = password;
		this.thread = thread;
		this.message = message;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setThread(String thread) {
		this.thread = thread;
	}	
	
	public String getThread() {
		return this.thread;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	public boolean isValid() {
		throw new UnsupportedOperationException();
	}

	public void doAction(WebDriver driver) throws InterruptedException {
		throw new UnsupportedOperationException();
	}
}

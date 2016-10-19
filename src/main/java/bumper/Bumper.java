package bumper;

import org.openqa.selenium.firefox.FirefoxDriver;

import hosts.Runescape;
import hosts.Website;

public class Bumper {
	public static void main(String args[]) throws Exception {

		String driverLocation = null;
		Website website = null;

		for (int i = 0; i < args.length; i++) {
			String[] arg = args[i].split("=");
			if (arg[0].equals("--website")) {
				if (arg[1].equalsIgnoreCase("runescape")) {
					website = new Runescape();
				} else {
					System.out.println("Website not supported: " + arg[1]);
				}
			}
		}
		
		if (website == null) {
			throw new Exception("--website must be provided!");
		}

		for (int i = 0; i < args.length; i++) {
			String[] arg = args[i].split("=");
			if (arg[0].equals("--username")) {
				website.setUsername(arg[1]);
			} else if (arg[0].equals("--password")) {
				website.setPassword(arg[1]);
			} else if (arg[0].equals("--thread")) {
				website.setThread(arg[1]);
			} else if (arg[0].equals("--message")) {
				website.setMessage(arg[1]);
			} else if (arg[0].equals("--help") || arg[0].equals("-h")) {
				System.out.println("See the github page for more information: ");
			} else if (arg[0].equals("--website")) {
				continue;
			} else {
				System.out.println("Unknown argument: " + arg[0] + ". use -h for options.");
			}
		}

		if (driverLocation == null) {
			System.err.println("Driver location must be provided!");
		}
		
		if (website.isValid()) {
			website.doAction(new FirefoxDriver());
		}
	}
}

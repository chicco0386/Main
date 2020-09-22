package it.zeze.main;

public class NewMainLinux extends NewMain {

	public void superMain() {
		super.execute();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewMainLinux mainWindows = new NewMainLinux();
		mainWindows.rootFileHTML = "/home/enrico/Desktop/ZeZe/fantaFormazione/new_html";
		mainWindows.rootFileTXT = "/home/enrico/Desktop/ZeZe/fantaFormazione/new_txt";
		mainWindows.superMain();
	}

}

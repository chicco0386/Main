package it.zeze.main;

public class NewMainWindows extends NewMain {

	public void superMain() {
		super.execute();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewMainWindows mainWindows = new NewMainWindows();
		mainWindows.rootFileHTML = "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/new_html";
		mainWindows.rootFileTXT = "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/new_txt";
		mainWindows.superMain();
	}

}

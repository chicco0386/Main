package it.zeze.main;

import it.zeze.selenium.SeleniumUtil;

public class NewMainStatisticheLinux extends NewMain {

	public void salvaStatistichePiuFormazioni() {
		try {
			super.salvaProbabiliFormazioni();
			super.salvaStatistiche();
		} finally {
			SeleniumUtil.closeDriver();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewMainStatisticheLinux mainWindows = new NewMainStatisticheLinux();
		mainWindows.rootFileHTML = "/home/enrico/Scrivania/ZeZe/fantaFormazione/new_html";
		mainWindows.rootFileTXT = "/home/enrico/Scrivania/ZeZe/fantaFormazione/new_txt";
		mainWindows.salvaStatistichePiuFormazioni();
	}

}

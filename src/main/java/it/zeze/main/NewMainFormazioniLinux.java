package it.zeze.main;


import it.zeze.selenium.SeleniumUtil;

public class NewMainFormazioniLinux extends NewMain {

	public void salvaStatistichePiuFormazioni() {
		try {
			super.salvaProbabiliFormazioni(false);
		} finally {
			SeleniumUtil.closeDriver();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewMainFormazioniLinux mainWindows = new NewMainFormazioniLinux();
		mainWindows.rootFileHTML = "/home/enrico/Desktop/ZeZe/fantaFormazione/new_html";
		mainWindows.rootFileTXT = "/home/enrico/Desktop/ZeZe/fantaFormazione/new_txt";
		mainWindows.salvaStatistichePiuFormazioni();
	}

}

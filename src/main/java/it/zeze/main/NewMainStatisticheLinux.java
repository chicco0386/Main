package it.zeze.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.zeze.selenium.SeleniumUtil;

public class NewMainStatisticheLinux extends NewMain {

	public void salvaStatistichePiuFormazioni(String user, String pass) {
		try {
			super.salvaProbabiliFormazioni(false);
			super.salvaStatistiche(user, pass);
		} finally {
			SeleniumUtil.closeDriver();
		}
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		NewMainStatisticheLinux mainWindows = new NewMainStatisticheLinux();
		mainWindows.rootFileHTML = "/home/enrico/Scrivania/ZeZe/fantaFormazione/new_html";
		mainWindows.rootFileTXT = "/home/enrico/Scrivania/ZeZe/fantaFormazione/new_txt";
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Inserisci user accesso al sito: ");
		String user = dataIn.readLine();
		System.out.print("Inserisci pass accesso al sito: ");
		String pass = dataIn.readLine();
		mainWindows.salvaStatistichePiuFormazioni(user, pass);
	}

}

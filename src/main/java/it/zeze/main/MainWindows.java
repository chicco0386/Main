package it.zeze.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainWindows extends Main {
	
	public void superMain(String user, String pass) {
		super.execute(user, pass);
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MainWindows mainWindows = new MainWindows();
		mainWindows.filePathFantaGazzettaHTML= "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/html/fantagazzetta.html";
		mainWindows.filePathGazzettaHTML = "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/html/gazzetta.html";
		mainWindows.filePathMiaFormazioneFantaGazzettaSisalHTML= "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/html/rosaFGSisal.html";
		mainWindows.filePathMiaFormazioneFantaGazzettaHTML= "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/html/rosaFG.html";
		mainWindows.filePathFantaGazzettaTXT ="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/FantaGazzettaSquadre.txt";
		mainWindows.filePathGazzettaTXT="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/GazzettaSquadre.txt";
		mainWindows.filePathTuttiGiocatoriFinaleTXT ="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/Finale.txt";
		mainWindows.filePathMiaFormazioneFantaGazzettaSisalTXT ="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/MiaRosaFGSisal.txt";
		mainWindows.filePathMiaFormazioneFantaGazzettaTXT ="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/MiaRosaFG.txt";
		mainWindows.filePathMiglioreFormazioneSisal = "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/rosaFGSisal_migliore.txt";
		mainWindows.filePathMiglioreFormazione = "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/rosaFG_migliore.txt";
		mainWindows.filePathMiglioreFormazioneFantaGazzettaSisal ="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/rosaFGSisal_migliore_daFG.txt";
		mainWindows.filePathMiglioreFormazioneFantaGazzetta = "C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/rosaFG_migliore_daFG.txt";
		
		mainWindows.filePathPartiteDiGiornata="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/partiteDiGiornata.txt";
		
		mainWindows.filePathVotiFantaGazzettaHTML ="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/html/votiFantaGazzetta.html";
		mainWindows.filePathVotiFantaGazzettaTXT ="C:/Users/yyi3867/Desktop/ZeZe/fantaFormazione/txt/votiFantaGazzetta.txt";
		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Inserisci user accesso al sito: ");
		String user = dataIn.readLine();
		System.out.print("Inserisci pass accesso al sito: ");
		String pass = dataIn.readLine();
		mainWindows.superMain(user, pass);
	}

}

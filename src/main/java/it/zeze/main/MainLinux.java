package it.zeze.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainLinux extends Main {
	
	public void superMain(String user, String pass) {
		super.execute(user, pass);
	}
	
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MainLinux mainWindows = new MainLinux();
		
		mainWindows.filePathFantaGazzettaHTML= "/home/enrico/Scrivania/FantaFormazione/html/fantagazzetta.html";
		mainWindows.filePathGazzettaHTML = "/home/enrico/Scrivania/FantaFormazione/html/gazzetta.html";
		mainWindows.filePathMiaFormazioneFantaGazzettaSisalHTML= "/home/enrico/Scrivania/FantaFormazione/html/rosaFGSisal.html";
		mainWindows.filePathMiaFormazioneFantaGazzettaHTML= "/home/enrico/Scrivania/FantaFormazione/html/rosaFG.html";
		mainWindows.filePathFantaGazzettaTXT ="/home/enrico/Scrivania/FantaFormazione/txt/FantaGazzettaSquadre.txt";
		mainWindows.filePathGazzettaTXT="/home/enrico/Scrivania/FantaFormazione/txt/GazzettaSquadre.txt";
		mainWindows.filePathTuttiGiocatoriFinaleTXT ="/home/enrico/Scrivania/FantaFormazione/txt/Finale.txt";
		mainWindows.filePathMiaFormazioneFantaGazzettaSisalTXT ="/home/enrico/Scrivania/FantaFormazione/txt/MiaRosaFGSisal.txt";
		mainWindows.filePathMiaFormazioneFantaGazzettaTXT ="/home/enrico/Scrivania/FantaFormazione/txt/MiaRosaFG.txt";
		mainWindows.filePathMiglioreFormazioneSisal = "/home/enrico/Scrivania/FantaFormazione/txt/rosaFGSisal_migliore.txt";
		mainWindows.filePathMiglioreFormazione = "/home/enrico/Scrivania/FantaFormazione/txt/rosaFG_migliore.txt";
		mainWindows.filePathMiglioreFormazioneFantaGazzettaSisal ="/home/enrico/Scrivania/FantaFormazione/txt/rosaFGSisal_migliore_daFG.txt";
		mainWindows.filePathMiglioreFormazioneFantaGazzetta = "/home/enrico/Scrivania/FantaFormazione/txt/rosaFG_migliore_daFG.txt";
		
		mainWindows.filePathPartiteDiGiornata="/home/enrico/Scrivania/FantaFormazione/txt/partiteDiGiornata.txt";
		
		mainWindows.filePathVotiFantaGazzettaHTML ="/home/enrico/Scrivania/FantaFormazione/html/votiFantaGazzetta.html";
		mainWindows.filePathVotiFantaGazzettaTXT ="/home/enrico/Scrivania/FantaFormazione/txt/votiFantaGazzetta.txt";
		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Inserisci user accesso al sito: ");
		String user = dataIn.readLine();
		System.out.print("Inserisci pass accesso al sito: ");
		String pass = dataIn.readLine();
		mainWindows.execute(user, pass);

	}

}

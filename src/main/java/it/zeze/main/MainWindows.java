package it.zeze.main;

public class MainWindows extends Main {
	
	public void superMain() {
		super.execute();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		mainWindows.superMain();
	}

}

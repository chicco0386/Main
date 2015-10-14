package it.zeze.main;

public class MainLinux extends Main {
	
	public void superMain() {
		super.execute();
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		
		mainWindows.execute();

	}

}

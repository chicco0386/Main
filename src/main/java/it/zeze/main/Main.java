package it.zeze.main;

import it.zeze.bo.ListaGiocatori;
import it.zeze.bo.ListaPartite;
import it.zeze.bo.ListaStatistiche;
import it.zeze.selenium.SeleniumUtil;
import it.zeze.util.FantaFormazioneUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.htmlcleaner.XPatherException;

public class Main {

	protected String filePathFantaGazzettaHTML;
	protected String filePathGazzettaHTML;
	protected String filePathMiaFormazioneFantaGazzettaSisalHTML;
	protected String filePathMiaFormazioneFantaGazzettaHTML;
	protected String filePathFantaGazzettaTXT;
	protected String filePathGazzettaTXT;
	protected String filePathTuttiGiocatoriFinaleTXT;
	protected String filePathMiaFormazioneFantaGazzettaSisalTXT;
	protected String filePathMiaFormazioneFantaGazzettaTXT;
	protected String filePathMiglioreFormazioneSisal;
	protected String filePathMiglioreFormazione;
	protected String filePathMiglioreFormazioneFantaGazzettaSisal;
	protected String filePathMiglioreFormazioneFantaGazzetta;
	
	protected String filePathPartiteDiGiornata;

	protected String filePathVotiFantaGazzettaHTML;
	protected String filePathVotiFantaGazzettaTXT;

	public void execute() {
		try {
			SeleniumUtil.saveHTMLPage("http://www.fantagazzetta.com/probabili-formazioni-serie-A", filePathFantaGazzettaHTML);
			SeleniumUtil.saveHTMLPage("http://www.gazzetta.it/Calcio/prob_form/campo.shtml", filePathGazzettaHTML);
			FantaFormazioneUtil.salvaMiaFormazioneFantaGeniusSisal(filePathMiaFormazioneFantaGazzettaSisalHTML);
			FantaFormazioneUtil.salvaMiaFormazioneFantaGenius(filePathMiaFormazioneFantaGazzettaHTML);
			FantaFormazioneUtil.salvaVotiFantaGenius(filePathVotiFantaGazzettaHTML);

			System.out.println("--- Probabili formazioni FantaGazzetta ---");
			ListaGiocatori listaGiocatoriSquadre = new ListaGiocatori();
			listaGiocatoriSquadre.unmarshallFromHtmlFileFantaGazzettaConSquadre(filePathFantaGazzettaHTML);
			listaGiocatoriSquadre.pulisciCaratteriSpeciali();
			listaGiocatoriSquadre.scriviSuFileTabella(filePathFantaGazzettaTXT);
			listaGiocatoriSquadre.contaDuplicati();

			System.out.println("--- Probabili formazioni Gazzetta ---");
			ListaGiocatori listaGiocatoriGazzettaSquadre = new ListaGiocatori();
			listaGiocatoriGazzettaSquadre.unmarshallFromHtmlFileGazzettaConSquadre(filePathGazzettaHTML);
			listaGiocatoriGazzettaSquadre.pulisciCaratteriSpeciali();
			listaGiocatoriGazzettaSquadre.scriviSuFileTabella(filePathGazzettaTXT);
			listaGiocatoriGazzettaSquadre.contaDuplicati();

			System.out.println("--- Probabili formazioni Finale ---");
			List<ListaGiocatori> listeToCompare = new ArrayList<ListaGiocatori>();
			listeToCompare.add(listaGiocatoriSquadre);
			listeToCompare.add(listaGiocatoriGazzettaSquadre);
			ListaGiocatori finale = FantaFormazioneUtil.calcolaProbabilitaImpiego(listeToCompare);
			finale.scriviSuFileTabella(filePathTuttiGiocatoriFinaleTXT);

			// Leggi formazione Sisal
			ListaGiocatori listaFormazioneFantaGazzettaSisal = new ListaGiocatori();
			listaFormazioneFantaGazzettaSisal.unmarshallFormazioneFromHtmlFileFantaGazzetta(filePathMiaFormazioneFantaGazzettaSisalHTML);
			listaFormazioneFantaGazzettaSisal.pulisciCaratteriSpeciali();
			listaFormazioneFantaGazzettaSisal.scriviSuFileTabella(filePathMiaFormazioneFantaGazzettaSisalTXT);
			
			// Leggi formazione
			ListaGiocatori listaFormazioneFantaGazzetta = new ListaGiocatori();
			listaFormazioneFantaGazzetta.unmarshallFormazioneFromHtmlFileFantaGazzetta(filePathMiaFormazioneFantaGazzettaHTML);
			listaFormazioneFantaGazzetta.pulisciCaratteriSpeciali();
			listaFormazioneFantaGazzetta.scriviSuFileTabella(filePathMiaFormazioneFantaGazzettaTXT);
			
			System.out.println("--- Recupera voti FG ---");
			ListaStatistiche listaStatisticheFantaGazzetta = new ListaStatistiche();
			listaStatisticheFantaGazzetta.unmarshallFromFileVotiFantaGazzetta(filePathVotiFantaGazzettaHTML, true, false);
			listaStatisticheFantaGazzetta.scriviSuFileTabella(filePathVotiFantaGazzettaTXT);
			
			System.out.println("--- Crea partite di giornata ---");
			ListaPartite listaPartite = new ListaPartite();
			listaPartite.unmarshallFromHtmlFile(filePathFantaGazzettaHTML);
			listaPartite.scriviSuFileTabella(filePathPartiteDiGiornata);

			// Genera migliore formazione per FantaGazzetta Sisal
			System.out.println("--- Genera formazione Sisal FG/Gazzetta ---");
			ListaGiocatori listaMiglioreFormazioneFantaGazzettaSisal = FantaFormazioneUtil.generaFormazione(finale, listaFormazioneFantaGazzettaSisal);
			listaMiglioreFormazioneFantaGazzettaSisal.aggiornaListaGiocatori(listaPartite, listaStatisticheFantaGazzetta);
			listaMiglioreFormazioneFantaGazzettaSisal.setProvenienza("Migliore formazione Sisal");
			listaMiglioreFormazioneFantaGazzettaSisal.scriviSuFileTabella(filePathMiglioreFormazioneSisal);
			
			// Genera migliore formazione per FantaGazzetta
			System.out.println("--- Genera formazione FG/Gazzetta ---");
			ListaGiocatori listaMiglioreFormazioneFantaGazzetta = FantaFormazioneUtil.generaFormazione(finale, listaFormazioneFantaGazzetta);
			listaMiglioreFormazioneFantaGazzetta.aggiornaListaGiocatori(listaPartite, listaStatisticheFantaGazzetta);
			listaMiglioreFormazioneFantaGazzetta.setProvenienza("Migliore formazione");
			listaMiglioreFormazioneFantaGazzetta.scriviSuFileTabella(filePathMiglioreFormazione);

			System.out.println("--- Genera formazione Sisal FG ---");
			// Genera migliore formazione per FantaGazzettaSisal solo leggendo le
			// possibili formazioni fantagazzetta
			ListaGiocatori listaMiglioreFormazioneFantaGazzettaSisalDaFG = FantaFormazioneUtil.generaFormazione(listaGiocatoriSquadre, listaFormazioneFantaGazzettaSisal);
			listaMiglioreFormazioneFantaGazzettaSisalDaFG.aggiornaListaGiocatori(listaPartite, listaStatisticheFantaGazzetta);
			listaMiglioreFormazioneFantaGazzettaSisalDaFG.setProvenienza("Formazione solo da FG");
			listaMiglioreFormazioneFantaGazzettaSisalDaFG.scriviSuFileTabella(filePathMiglioreFormazioneFantaGazzettaSisal);
			
			System.out.println("--- Genera formazione FG ---");
			// Genera migliore formazione per FantaGazzetta solo leggendo le
			// possibili formazioni fantagazzetta
			ListaGiocatori listaMiglioreFormazioneFantaGazzettaDaFG = FantaFormazioneUtil.generaFormazione(listaGiocatoriSquadre, listaFormazioneFantaGazzetta);
			listaMiglioreFormazioneFantaGazzettaDaFG.aggiornaListaGiocatori(listaPartite, listaStatisticheFantaGazzetta);
			listaMiglioreFormazioneFantaGazzettaDaFG.setProvenienza("Formazione solo da FG");
			listaMiglioreFormazioneFantaGazzettaDaFG.scriviSuFileTabella(filePathMiglioreFormazioneFantaGazzetta);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SeleniumUtil.closeDriver();
		}
	}
}

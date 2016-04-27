package it.zeze.main;

import it.zeze.bo.ListaSquadre;
import it.zeze.selenium.SeleniumUtil;
import it.zeze.util.FantaFormazioneUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.htmlcleaner.XPatherException;

public class NewMain {

	protected String rootFileHTML;
	protected String rootFileTXT;

	private String pathFileHTMLSquadre;
	private String pathFileHTMLGiocatori;
	private String pathFileHTMLGiocatoriRuolo;
	private String templateUrlGiocatori;
	private String pathFileHTMLGiocatoriPortieri;
	private String pathFileHTMLGiocatoriDifensori;
	private String pathFileHTMLGiocatoriCentrocampisti;
	private String pathFileHTMLGiocatoriAttaccanti;
	private String pathFileHTMLCalendario;
	private String pathFileHTMLStatistiche;
	private String pathFileHTMLProbFormazioniFG;
	private String pathFileHTMLProbFormazioniGS;

	private void init() {
		pathFileHTMLSquadre = rootFileHTML + "/squadre.html";
		pathFileHTMLGiocatori = rootFileHTML + "/giocatori.html";
		pathFileHTMLGiocatoriRuolo = rootFileHTML + "/giocatori_{ruolo}.json";
		templateUrlGiocatori = "http://d22uzg7kr35tkk.cloudfront.net/web/quotazioni/milano/{ruolo}{stampa}.txt";
		pathFileHTMLGiocatoriPortieri = rootFileHTML + "/giocatoriP.html";
		pathFileHTMLGiocatoriDifensori = rootFileHTML + "/giocatoriD.html";
		pathFileHTMLGiocatoriCentrocampisti = rootFileHTML + "/giocatoriC.html";
		pathFileHTMLGiocatoriAttaccanti = rootFileHTML + "/giocatoriA.html";
		pathFileHTMLCalendario = rootFileHTML + "/calendario_{giornata}_.html";
		pathFileHTMLStatistiche = rootFileHTML + "/statisticheG{giornata}.html";
		pathFileHTMLProbFormazioniFG = rootFileHTML + "/probFormazioniFG{giornata}.html";
		pathFileHTMLProbFormazioniGS = rootFileHTML + "/probFormazioniGS{giornata}.html";
	}

	public void execute() {
		try {
			init();
			File cartellaDestHTML = new File(rootFileHTML);
			if (!cartellaDestHTML.exists()) {
				cartellaDestHTML.mkdirs();
			}
			File cartellaDestTXT = new File(rootFileTXT);
			if (!cartellaDestTXT.exists()) {
				cartellaDestTXT.mkdirs();
			}

			System.out.println("*** PROGRAMMA DI RECUPERO HTML FANTA FORMAZIONE ***");
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
			// Squadre
			System.out.print("Salva squadre (S/N): ");
			String paramInput = dataIn.readLine();
			if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
				FantaFormazioneUtil.salvaSquadre(pathFileHTMLSquadre);
				ListaSquadre listaSquadre = new ListaSquadre();
				listaSquadre.unmarshallFromHtmlFile(pathFileHTMLSquadre);
			}

			// Giocatori
			System.out.print("Salva giocatori (S/N): ");
			paramInput = dataIn.readLine();
			if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
//				FantaFormazioneUtil.salvaGiocatoriPortieri(pathFileHTMLGiocatoriPortieri);
//				FantaFormazioneUtil.salvaGiocatoriDifensori(pathFileHTMLGiocatoriDifensori);
//				FantaFormazioneUtil.salvaGiocatoriCentrocampisti(pathFileHTMLGiocatoriCentrocampisti);
//				FantaFormazioneUtil.salvaGiocatoriAttaccanti(pathFileHTMLGiocatoriAttaccanti);
				FantaFormazioneUtil.salvaTuttiGiocatoriNew(pathFileHTMLGiocatori, pathFileHTMLGiocatoriRuolo, templateUrlGiocatori);
			}

			// Calendario
			System.out.print("Salva calendario (S/N): ");
			paramInput = dataIn.readLine();
			if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
				FantaFormazioneUtil.salvaCalendario(pathFileHTMLCalendario);
			}

			// Probabili formazioni
			System.out.print("Salva probabili formazioni (S/N): ");
			paramInput = dataIn.readLine();
			if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
				salvaProbabiliFormazioni();
			}

			// Salva voti per giornata
			System.out.print("Salva statistiche (S/N): ");
			paramInput = dataIn.readLine();
			if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
//				System.out.print("Inserisci user accesso al sito: ");
//				String user = dataIn.readLine();
//				System.out.print("Inserisci pass accesso al sito: ");
//				String pass = dataIn.readLine();
				salvaStatistiche(null, null);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SeleniumUtil.closeDriver();
		}
	}

	public void salvaStatistiche(String user, String pass) {
		try {
			init();
			File cartellaDestHTML = new File(rootFileHTML);
			if (!cartellaDestHTML.exists()) {
				cartellaDestHTML.mkdirs();
			}
			File cartellaDestTXT = new File(rootFileTXT);
			if (!cartellaDestTXT.exists()) {
				cartellaDestTXT.mkdirs();
			}
			// Salva voti per giornata
			FantaFormazioneUtil.salvaStatistichePerTutteLeGiornate(pathFileHTMLStatistiche, user, pass);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvaProbabiliFormazioni() {
		try {
			init();
			File cartellaDestHTML = new File(rootFileHTML);
			if (!cartellaDestHTML.exists()) {
				cartellaDestHTML.mkdirs();
			}
			File cartellaDestTXT = new File(rootFileTXT);
			if (!cartellaDestTXT.exists()) {
				cartellaDestTXT.mkdirs();
			}
			FantaFormazioneUtil.salvaProbabiliFormazioniFG(pathFileHTMLProbFormazioniFG);
			FantaFormazioneUtil.salvaProbabiliFormazioniGazzetta(pathFileHTMLProbFormazioniGS);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package it.zeze.main;

import it.zeze.bo.ListaSquadre;
import it.zeze.selenium.SeleniumUtil;
import it.zeze.util.FantaFormazioneUtil;
import org.htmlcleaner.XPatherException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;

public class NewMain {

    private boolean useSelenium = false;

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
        templateUrlGiocatori = "https://d22uzg7kr35tkk.cloudfront.net/web/quotazioni/fantagazzetta/{ruolo}{stampa}.txt";
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
                FantaFormazioneUtil.salvaSquadre(pathFileHTMLSquadre, useSelenium);
                ListaSquadre listaSquadre = new ListaSquadre();
                listaSquadre.unmarshallFromHtmlFile(pathFileHTMLSquadre);
            }

            // Giocatori
            System.out.print("Salva giocatori (S/N): ");
            paramInput = dataIn.readLine();
            if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
                FantaFormazioneUtil.salvaTuttiGiocatoriNew(pathFileHTMLGiocatori, pathFileHTMLGiocatoriRuolo, templateUrlGiocatori, useSelenium);
            }

            // Calendario
            System.out.print("Salva calendario (S/N): ");
            paramInput = dataIn.readLine();
            if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
                FantaFormazioneUtil.salvaCalendario(pathFileHTMLCalendario, useSelenium);
            }

            // Probabili formazioni
            System.out.print("Salva probabili formazioni (S/N): ");
            paramInput = dataIn.readLine();
            if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
                salvaProbabiliFormazioni(useSelenium);
            }

            // Salva voti per giornata
            System.out.print("Salva statistiche (S/N): ");
            paramInput = dataIn.readLine();
            if (paramInput == null || paramInput.equalsIgnoreCase("s")) {
//				System.out.print("Inserisci user accesso al sito: ");
//				String user = dataIn.readLine();
//				System.out.print("Inserisci pass accesso al sito: ");
//				String pass = dataIn.readLine();
//              salvaStatistiche(null, null);
                salvaStatisticheNew();
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
        } catch (Exception e) {
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

    public void salvaStatisticheNew() {
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
        try {
            FantaFormazioneUtil.salvaStatistichePerTutteLeGiornateNew(pathFileHTMLStatistiche);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPatherException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salvaProbabiliFormazioni(boolean useSelenium) {
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
            FantaFormazioneUtil.salvaProbabiliFormazioniFG(pathFileHTMLProbFormazioniFG, useSelenium);
            FantaFormazioneUtil.salvaProbabiliFormazioniGazzetta(pathFileHTMLProbFormazioniGS, useSelenium);
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

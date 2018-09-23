import java.util.LinkedList;

import alimentazione.Alimento;
import alimentazione.AlimentoConfezionato;
import alimentazione.AlimentoNonTrovatoException;
import alimentazione.Ricetta;
import alimentazione.RicettaNonTrovataException;
import alimentazione.Sistema;

public class Esempio {

    public static void main(String[] args) throws AlimentoNonTrovatoException, RicettaNonTrovataException  {
        Sistema s = new Sistema();
        
		System.out.println("******************************************");
		System.out.println("*             R1. ALIMENTI               *");
		System.out.println("******************************************");

		System.out.println("\nAggiunto un nuovo alimento");

        Alimento zucchero = s.aggiungiAlimento("Zucchero", 400, 0, 100, 0);
        System.out.println("\nDettagli alimento: ");
        System.out.println(" Nome: "+zucchero.getNome()); 
        System.out.println(" Calorie: " + zucchero.getCalorie()); 
        System.out.println(" Proteine: " +zucchero.getProteine()); 
        System.out.println(" Carboidrati: " +zucchero.getCarboidrati()); 
        System.out.println(" Grassi: " +zucchero.getGrassi()); 
        
		System.out.println("\nAggiunti altri alimenti");
        Alimento mais = s.aggiungiAlimento("Mais", 70, 2.7, 12, 1.3);
        Alimento pasta = s.aggiungiAlimento("Pasta", 350, 12, 72.2, 1.5);
        Alimento riso = s.aggiungiAlimento("Riso", 300, 10, 60, 1.5);
        Alimento pomodoro = s.aggiungiAlimento("pomodoro", 17, 1, 3, 0.2);
        Alimento olio = s.aggiungiAlimento("Olio", 900, 0, 0, 100);
        Alimento pecorino = s.aggiungiAlimento("Pecorino romano", 400, 2, 26, 33);
        Alimento pepe = s.aggiungiAlimento("Pepe", 0, 0, 0, 0);

		System.out.println("\nAggiunto un nuovo alimento confezionato");
        Alimento nutella = s.aggiungiAlimentoConfezionato("Nutella", 530, 6.8, 56, 31, 50);
        
        System.out.println("\nDettagli alimento: ");
        System.out.println(" Nome: "+nutella.getNome()); 
        System.out.println(" Calorie: " + nutella.getCalorie()); 
        System.out.println(" Proteine: " +nutella.getProteine()); 
        System.out.println(" Carboidrati: " +nutella.getCarboidrati()); 
        System.out.println(" Grassi: " +nutella.getGrassi()); 

		System.out.println("\nCerca alimento 'Pasta'");
		Alimento a = s.cercaAlimento("Pasta");

		System.out.println("\nAlimento trovato:");
        System.out.println(" Nome: "+a.getNome()); 
        System.out.println(" Calorie: " + a.getCalorie()); 
        System.out.println(" Proteine: " +a.getProteine()); 
        System.out.println(" Carboidrati: " +a.getCarboidrati()); 
        System.out.println(" Grassi: " +a.getGrassi()); 

		System.out.println("\nElenco alimenti (ordine di inserimento):");
		LinkedList<Alimento> listaAlimenti = new LinkedList<Alimento>(s.elencoAlimentiInOrdineDiInserimento());
		for(Alimento atemp : listaAlimenti){
			System.out.println(" "+atemp.getNome()+", "+atemp.getCalorie()+", "+atemp.getProteine()+", "+atemp.getCarboidrati()+", "+atemp.getGrassi());
		}
        
		System.out.println("\n\n******************************************");
		System.out.println("*              R2. RICETTE               *");
		System.out.println("******************************************");

		System.out.println("\nDefinita una nuova ricetta 'Spaghetti Cacio e Pepe'");
        Ricetta r1 = s.aggiungiRicetta("Spaghetti Cacio e Pepe", "Grattugiare il Pecorino. Cuocere gli spaghetti. Mischiare il tutto aggiungendo pepe a volonta'", 4);
		
		System.out.println("\nAggiunti tre ingredienti alla ricetta");
        s.aggiungiIngrediente("Spaghetti Cacio e Pepe", "Pasta", 400);
        s.aggiungiIngrediente("Spaghetti Cacio e Pepe", "Pecorino romano", 200);
        s.aggiungiIngrediente("Spaghetti Cacio e Pepe", "Pepe", 30);
        
        System.out.println("\nDettagli ricetta: ");
        System.out.println(" Nome: "+r1.getNome());
        System.out.println(" Descrizione: "+r1.getDescrizione());
        System.out.println(" Numero porzioni: "+r1.getNumeroPorzioni());
        System.out.println(" Calorie porzione: "+r1.calcolaCaloriePorzione());
        System.out.println(" Carboidrati porzione: "+r1.calcolaCarboidratiPorzione());
        System.out.println(" Proteine porzione: "+r1.calcolaProteinePorzione());
        System.out.println(" Grassi porzione: "+r1.calcolaGrassiPorzione());

		System.out.println("\nAggiunte altre ricette");
        s.aggiungiRicetta("Pasta al pomodoro", "Cuocere gli spaghetti. Aggiungere il pomodoro, olio e pepe", 2);
        s.aggiungiIngrediente("Pasta al pomodoro", "Pasta", 160);
        s.aggiungiIngrediente("Pasta al pomodoro", "pomodoro", 100);
        s.aggiungiIngrediente("Pasta al pomodoro", "Olio", 20);
        s.aggiungiIngrediente("Pasta al pomodoro", "Pepe", 20);

        s.aggiungiRicetta("Insalata", "Mischiare il tutto", 4);
        s.aggiungiIngrediente("Insalata", "Mais", 100);
        s.aggiungiIngrediente("Insalata", "pomodoro", 200);
        s.aggiungiIngrediente("Insalata", "Olio", 10);
        s.aggiungiIngrediente("Insalata", "Pecorino romano", 10);
        s.aggiungiIngrediente("Insalata", "Pepe", 10);

        s.aggiungiRicetta("Riso all'olio", "Bollire il riso e condire con l'olio. Ricetta per quando non si sta bene", 1);
        s.aggiungiIngrediente("Riso all'olio", "Riso", 80);
        s.aggiungiIngrediente("Riso all'olio", "Olio", 10);
        
//       System.out.println(s.cercaRicetta("Riso all'olio").getIngredientiQuantita().toString());

		System.out.println("\nCerca ricetta 'Pasta al pomodoro'");
		Ricetta r2 = s.cercaRicetta("Pasta al pomodoro");
        System.out.println("\nDettagli ricetta: ");
        System.out.println(" Nome: "+r2.getNome());
        System.out.println(" Descrizione: "+r2.getDescrizione());
        System.out.println(" Numero porzioni: "+r2.getNumeroPorzioni());
        System.out.println(" Calorie porzione: "+r2.calcolaCaloriePorzione());
        System.out.println(" Carboidrati porzione: "+r2.calcolaCarboidratiPorzione());
        System.out.println(" Proteine porzione: "+r2.calcolaProteinePorzione());
        System.out.println(" Grassi porzione: "+r2.calcolaGrassiPorzione());
				
		System.out.println("\nElenco ricette (ordine alfabetico):");
		LinkedList<Ricetta> listaRicette = new LinkedList<Ricetta>(s.elencoRicetteInOrdineAlfabetico());
		for(Ricetta rtemp : listaRicette){
			System.out.println(" "+rtemp.getNome()+", "+rtemp.getDescrizione()+", "+rtemp.getNumeroPorzioni());
		}

		System.out.println("\nElenco ricette (calorie crescenti):");
		listaRicette = new LinkedList<Ricetta>(s.elencoRicetteOrdinatePerCalorieCrescenti());
		for(Ricetta rtemp : listaRicette){
			System.out.println(" "+rtemp.getNome()+", "+rtemp.getDescrizione()+", "+rtemp.getNumeroPorzioni()+", "+rtemp.calcolaCaloriePorzione());
		}
        
		System.out.println("\nElenco ricette (numero ingredienti crescenti):");
		listaRicette = new LinkedList<Ricetta>(s.elencoRicetteOrdinatePerNumeroIngredientiCrescente());
		for(Ricetta rtemp : listaRicette){
			System.out.println(" "+rtemp.getNome()+", "+rtemp.getDescrizione());
		}

		System.out.println("\n\n******************************************");
		System.out.println("*          R3. MENU GIORNALIERO          *");
		System.out.println("******************************************");

		System.out.println("\nAggiunta la ricetta 'Pasta al pomodoro' in data '20180914'");
		s.aggiungiRicettaInData("Pasta al pomodoro", "20180914");

		System.out.println("Aggiunta la ricetta 'Insalata' in data '20180914'");
		s.aggiungiRicettaInData("Insalata", "20180914");

		System.out.println("Aggiunta la ricetta 'Spaghetti Cacio e Pepe' in data '20180915'");
		s.aggiungiRicettaInData("Spaghetti Cacio e Pepe", "20180915");

		System.out.println("Aggiunta la ricetta 'Pasta al pomodoro' in data '20180915'");
		s.aggiungiRicettaInData("Pasta al pomodoro", "20180915");

		System.out.println("Aggiunta la ricetta 'Insalata' in data '20180916'");
		s.aggiungiRicettaInData("Insalata", "20180916");

		System.out.println("Aggiunta la ricetta 'Riso all'olio' in data '20180916'");
		s.aggiungiRicettaInData("Riso all'olio", "20180916");

		System.out.println("Aggiunta la ricetta 'Insalata' in data '20180917'");
		s.aggiungiRicettaInData("Insalata", "20180917");

		System.out.println("\nCalcolo calorie assunte");
		System.out.println("Calorie assunte in data '20180914': "+s.calcolaCalorieAssunteInData("20180914"));
		System.out.println("Calorie assunte in data '20180915': "+s.calcolaCalorieAssunteInData("20180915"));
		System.out.println("Calorie assunte in data '20180916': "+s.calcolaCalorieAssunteInData("20180916"));
		System.out.println("Calorie assunte in data '20180917': "+s.calcolaCalorieAssunteInData("20180917"));
		
		System.out.println("\nImpostazione limite calorie giornaliero a 400 calorie");
		s.setLimiteCalorieGiornaliere(400);

		System.out.println("\nElenco date oltre il limite di calorie");
		System.out.println(s.elencoDateOltreLimiteCalorie());
		
		
		System.out.println("\n\n******************************************");
		System.out.println("*           R4. LETTURA DA FILE          *");
		System.out.println("******************************************");

		System.out.println("\nLettura da file");
		s.leggiFile("input.txt");
		
		System.out.println("\nElenco alimenti (ordine di inserimento):");
		listaAlimenti = new LinkedList<Alimento>(s.elencoAlimentiInOrdineDiInserimento());
		for(Alimento atemp : listaAlimenti){
			System.out.println(" "+atemp.getNome()+", "+atemp.getCalorie()+", "+atemp.getProteine()+", "+atemp.getCarboidrati()+", "+atemp.getGrassi());
		}

		System.out.println("\nElenco ricette (ordine alfabetico):");
		listaRicette = new LinkedList<Ricetta>(s.elencoRicetteInOrdineAlfabetico());
		for(Ricetta rtemp : listaRicette){
			System.out.println(" "+rtemp.getNome()+", "+rtemp.getDescrizione()+", "+rtemp.getNumeroPorzioni());
		}
    }

}

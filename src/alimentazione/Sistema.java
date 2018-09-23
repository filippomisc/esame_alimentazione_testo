package alimentazione;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sistema {
	
	private List<Alimento> alimenti;
	private List<Ricetta> ricette;


	public Sistema() {
		this.alimenti = new ArrayList<>();
		this.ricette = new ArrayList<>();
	}

	public Alimento aggiungiAlimento(String nome, double calorie, double proteine, double carboidrati, double grassi) {
		
		Alimento alimento = new Alimento(nome, calorie, proteine, carboidrati, grassi);
		
		if(this.alimenti.contains(alimento))
			return null;
		
		alimenti.add(alimento);
		
		return alimento;
	}

	public Alimento aggiungiAlimentoConfezionato(String nome, double calorie, double proteine, double carboidrati, double grassi, double grammi) {
		
		AlimentoConfezionato alimentoConf = new AlimentoConfezionato(nome, calorie, proteine, carboidrati, grassi, grammi);
		
		if(this.alimenti.contains(alimentoConf))
			return null;
		
		alimenti.add(alimentoConf);
		return alimentoConf;
	}
	
	public Alimento cercaAlimento(String nome) throws AlimentoNonTrovatoException{
		
		Alimento result = null;
		
		String nDaCercare = nome.toLowerCase();
		
		
		
		for(Alimento a : this.alimenti) {
			
			if(a.getNome().toLowerCase().compareTo(nDaCercare)==0)
				result = a;
		}
		
		if(result== null)
			throw new AlimentoNonTrovatoException();
		
		return result;

	}

	public Collection<Alimento> elencoAlimentiInOrdineDiInserimento() {
		
		return this.alimenti;
	}
	
	public Ricetta aggiungiRicetta(String nome, String descrizione, int numeroPorzioni) {
		Ricetta ricetta = new Ricetta(nome, descrizione, numeroPorzioni);
		
		this.ricette.add(ricetta);
		return ricetta;
	}
																										//mi chiede di aggiungere le eccezioni. è normale?
	public void aggiungiIngrediente(String nomeRicetta, String nomeIngrediente, double quantita) throws AlimentoNonTrovatoException, RicettaNonTrovataException{
		
		Alimento alimento = cercaAlimento(nomeIngrediente);
		
		cercaRicetta(nomeRicetta).aggiungiIngrediente(alimento, quantita);
	}
	
	public Ricetta cercaRicetta(String nome) throws RicettaNonTrovataException{
		
		Ricetta result = null;
		
		for(Ricetta r : this.ricette) {
			
			if(r.getNome().compareTo(nome)==0)
				result = r;
		}
		
		if(result== null)
			throw new RicettaNonTrovataException();
		
		return result;
	}

	public Collection<Ricetta> elencoRicetteInOrdineAlfabetico() {
		
//		Collections.sort(ricette);
		
		return ricette;
	}

	public Collection<Ricetta> elencoRicetteOrdinatePerCalorieCrescenti() {
		return null;
	}

	public Collection<Ricetta> elencoRicetteOrdinatePerNumeroIngredientiCrescente() {
		return null;
	}

	public void aggiungiRicettaInData(String nomeRicetta, String giorno){
	}
	
	public double calcolaCalorieAssunteInData(String data){
		return 0.0;
	}

	public void setLimiteCalorieGiornaliere(double limiteCalorieGiornaliere){
	}
	
	public String elencoDateOltreLimiteCalorie(){
		return null;
	}
	
	public void leggiFile(String file) {
	}
}

package alimentazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Ricetta implements Comparable<Ricetta>{
	
	private String nome;
	private String descrizione;
	private int numPorzioni;
	
	private Map<String, Double> ingredientiQuantita;
	private List<Alimento> ingredientiRicetta;
	
	
    
	public Ricetta(String nome, String descrizione, int numPorzioni) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.numPorzioni = numPorzioni;
		
		this.ingredientiQuantita = new HashMap<>();
		this.ingredientiRicetta = new ArrayList<Alimento>();
	}

	public String getNome() { 
		return this.nome; 
	}
	
	public String getDescrizione() { 
		return this.descrizione; 
	}
	
	public int getNumeroPorzioni() { 
		return this.numPorzioni; 
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ricetta [nome=");
		builder.append(nome);
		builder.append(", descrizione=");
		builder.append(descrizione);
		builder.append(", numPorzioni=");
		builder.append(numPorzioni);
		builder.append("]");
		return builder.toString();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ricetta other = (Ricetta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void aggiungiIngrediente(Alimento alimento, double quantita) {
		
		this.ingredientiQuantita.put(alimento.getNome(), quantita);
		this.ingredientiRicetta.add(alimento);
		
		
	}

	public double calcolaCaloriePorzione() {
		
		double calorieRicetta = 0.0;
		
		for (String nomeIng : this.ingredientiQuantita.keySet()) {
			
			double quantita = this.ingredientiQuantita.get(nomeIng);
			
			Alimento iTemp = cercaIngrediente(nomeIng);
			
			 calorieRicetta +=  quantita*(iTemp.getCalorie()*100);
			
		}
		
		return calorieRicetta;
	}

	private Alimento cercaIngrediente(String nomeIng) {
		Alimento result = null;
		
		
		
		
		for(Alimento a : this.ingredientiRicetta) {
			
			if(a.getNome().compareTo(nomeIng)==0)
				result = a;
		}
		
		return result;

	}

	public double calcolaCarboidratiPorzione() {
		double carboidratiRicetta = 0.0;
		
		for (String nomeIng : this.ingredientiQuantita.keySet()) {
			
			double quantita = this.ingredientiQuantita.get(nomeIng);
			
			Alimento iTemp = cercaIngrediente(nomeIng);
			
			 carboidratiRicetta +=  quantita*(iTemp.getCarboidrati()*100);
			
		}
		
		return carboidratiRicetta;
	}

	
	public double calcolaProteinePorzione() {
		double proteineRicetta = 0.0;
		
		for (String nomeIng : this.ingredientiQuantita.keySet()) {
			
			double quantita = this.ingredientiQuantita.get(nomeIng);
			
			Alimento iTemp = cercaIngrediente(nomeIng);
			
			 proteineRicetta +=  quantita*(iTemp.getProteine()*100);
			
		}
		
		return proteineRicetta;
	}

	public double calcolaGrassiPorzione() {
		double grassiRicetta = 0.0;
		
		for (String nomeIng : this.ingredientiQuantita.keySet()) {
			
			double quantita = this.ingredientiQuantita.get(nomeIng);
			
			Alimento iTemp = cercaIngrediente(nomeIng);
			
			 grassiRicetta +=  quantita*(iTemp.getProteine()*100);
			
		}
		
		return grassiRicetta;
	}

	public Map<String, Double> getIngredientiQuantita() {
		return ingredientiQuantita;
	}

	@Override
	public int compareTo(Ricetta arg0) {
		return this.getNome().compareTo(arg0.getNome());
	}

}

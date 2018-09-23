package alimentazione;

public class AlimentoConfezionato extends Alimento{
	
	private double pesoPorzione;  //g/prozione
	private double caloriePerPorzione; //KCal/porzione
	
	public AlimentoConfezionato(String nome, double calorie, double proteine,
			double carboidrati, double grassi, double pesoPorzione) {
		super(nome, calorie, proteine, carboidrati, grassi);
		this.pesoPorzione = pesoPorzione;
	}
	
	

	public double getPesoPorzione() { 
		return this.pesoPorzione; 
	}
	
	public double getCaloriePerPorzione() {
		return (this.getCalorie()/100)*(this.pesoPorzione); //KCal/porzione
	}

}
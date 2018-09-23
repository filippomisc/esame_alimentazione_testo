package alimentazione;

public class Alimento{
	
	private String nome;
	private double calorie;		//KCal/100g
	private double proteine;	//g/100g
	private double carboidrati;	//g/100g
	private double grassi;		//g/100g
	
	
	
	public Alimento(String nome, double calorie2, double proteine2, double carboidrati2,
			double grassi2) {
		super();
		this.nome = nome;
		this.calorie = calorie2;
		this.proteine = proteine2;
		this.carboidrati = carboidrati2;
		this.grassi = grassi2;
	}

	public String getNome() { 
		return this.nome; 
	}
	
	public double getCalorie() { 
		return this.calorie; 
	}
	
	public double getProteine() { 
		return this.proteine; 
	}
	
	public double getCarboidrati() { 
		return this.carboidrati; 
	}
	
	public double getGrassi() { 
		return this.grassi; 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alimento [nome=");
		builder.append(nome);
		builder.append(", calorie=");
		builder.append(calorie);
		builder.append(", proteine=");
		builder.append(proteine);
		builder.append(", carboidrati=");
		builder.append(carboidrati);
		builder.append(", grassi=");
		builder.append(grassi);
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
		Alimento other = (Alimento) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}

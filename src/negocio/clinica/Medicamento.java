package negocio.clinica;

import java.time.LocalDate;

public class Medicamento extends Produto{
	private double dose;

	
	//construtor
	public Medicamento(String nome, double dose, LocalDate validade, LocalDate fabricacao, int quantidade, double valor) {
		super(nome, validade, fabricacao, quantidade, valor);
		this.dose = dose;
	}
	
	
	//getters e setters
	
	public void setDose(double dose) {
		this.dose = dose;
	}
	
	public double getDose() {
		return dose;
	}
	

	//
	
	
	@Override
	public boolean equals(Object obj) {
		Medicamento m = (Medicamento)obj;
		
		if(this.getNome().equals(m.getNome()) && this.dose == ((Medicamento)obj).getDose() ){
			return true;
		}
		return false;
	}
	
}

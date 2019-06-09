package negocio.clinica;

import java.util.ArrayList;

public class Vacinacao extends Procedimento{
	private ArrayList<Vacina> vacinas;
	
	public Vacinacao(double valor, String tipo) {	
		super(valor, tipo);
		this.vacinas = new ArrayList<Vacina>();
	}

	public void addVacina(Vacina v) {
		this.vacinas.add(v);
	}
	
	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	}
	
	@Override
	public boolean equals(Object obj) {
		Vacinacao v = (Vacinacao)obj;
		
		if(	this.getTipo().equals(v.getTipo()) && 
			this.getProficional().equals(v.getProficional()) &&
			this.getAnimal().equals(v.getAnimal()) &&
			this.getData().equals(v.getData()) && 
			this.getVacinas().equals(v.getVacinas())) {
			
			return true;
		}
		
		return false;
	}
	
}

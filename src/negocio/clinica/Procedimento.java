package negocio.clinica;

import java.time.LocalDate;
import negocio.Animal;
import negocio.Veterinario;

public class Procedimento {
	private double valor;
	private boolean realizado;
	private String tipo;			//banho e tosa, tipo de consulta ou cirurgia...
	private LocalDate data;
	private Veterinario proficional;
	private Animal animal;
	
	public Procedimento(double valor, String tipo) {
		this.valor = valor;
		this.tipo = tipo;	
		this.realizado = false;
	}
	
	public void setProficional(Veterinario proficional) {
		this.proficional = proficional;
	}
	
	public Veterinario getProficional() {
		return proficional;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}	
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	
	public boolean getRealizado() {
		return this.realizado;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	 
	public void setData(LocalDate data) {
		this.data = data;
	}
	 
	public LocalDate getData() {
		return data;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if( this.getTipo() == ((Procedimento)obj).getTipo() && 
			this.getProficional().equals(((Procedimento)obj).getProficional()) &&
			this.getAnimal().equals(((Procedimento)obj).getAnimal()) &&
			this.getData().equals(((Procedimento)obj).getData()) ){
					return true;
				}
		
		return false;
	}
	
}

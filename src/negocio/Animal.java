package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import negocio.clinica.Procedimento;

public class Animal {
	private String nome, raca;
	private double peso;
	private LocalDate dataNascmento;
	private ArrayList<Procedimento> historico;
	private Cliente dono;

	public Animal(String nome, Cliente dono, LocalDate dn) {
		this.historico = new ArrayList<Procedimento>();
		this.nome = nome;
		this.dono = dono;
		this.dataNascmento = dn;
		this.peso = 0;
	}
	
	public void addProcedimento(Procedimento p) {
		this.historico.add(p);
	}	
	
	public void atualizarDono(Cliente novo) {
		this.setDono(novo);
		novo.addAnimal(this);
	}
	
													//Getters e Setters
	
	public LocalDate getDataNascmento() {
		return dataNascmento;
	}
	
	public Cliente getDono() {
		return dono;
	}
	
	public ArrayList<Procedimento> getHistorico() {
		return historico;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setDataNascmento(LocalDate dataNascmento) {
		this.dataNascmento = dataNascmento;
	}
	
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
	public void setHistorico(ArrayList<Procedimento> historico) {
		this.historico = historico;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
}

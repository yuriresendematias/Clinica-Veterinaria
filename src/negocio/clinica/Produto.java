package negocio.clinica;

import java.time.LocalDate;

public abstract class Produto {
	private String nome;
	private LocalDate validade, fabricacao;
	private double valor;
	private int quantidade;
	
	
	//construtor
	public Produto (String nome,  LocalDate validade, LocalDate fabricacao, int quantidade, double valor) {
		this.nome = nome;
		this.validade = validade;
		this.fabricacao = fabricacao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	
	
	//getters e setters
	
	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	
	public LocalDate getFabricacao() {
		return fabricacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getValidade() {
		return validade;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}

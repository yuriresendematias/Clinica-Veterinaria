package negocio.clinica;

import java.time.LocalDate;

public class Vacina {
	private String lote, nome;
	private LocalDate validade, fabricacao;
	private int quantidade;
	
	
	//getters e setters
	
	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}
	
	public void setLote(String lote) {
		this.lote = lote;
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
	
	public String getLote() {
		return lote;
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
}

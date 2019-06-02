package negocio.clinica;

import java.time.LocalDate;

public class Medicamento {
	private String nome;
	private LocalDate validade, fabricacao;
	
	public LocalDate getFabricacao() {
		return fabricacao;
	}
	
	public LocalDate getValidade() {
		return validade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	

	@Override
	public boolean equals(Object obj) {
		Medicamento m = (Medicamento)obj;
		
		if(this.getNome().equals(m.getNome()) ){
			return true;
		}
		return false;
	}
	
}

package negocio.clinica;

import java.time.LocalDate;

public class Vacina extends Produto{
	private String lote;
	
	
	//construtor
	public Vacina (String nome, String lote, LocalDate validade, LocalDate fabricacao, int quantidade, double valor) {
		super(nome, validade, fabricacao, quantidade, valor);
		this.lote = lote;
	}
	
	
	//getters e setters
	
	public void setLote(String lote) {
		this.lote = lote;
	}
	
	public String getLote() {
		return lote;
	}
}

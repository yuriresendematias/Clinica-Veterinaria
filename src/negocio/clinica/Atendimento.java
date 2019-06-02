package negocio.clinica;

public class Atendimento extends Procedimento{
	private String descricao;			//observacoes a respeito do procedimento, medicamentos receitados, tratamento, diagnostico...
	
	public Atendimento(double valor, String tipo) {
		super(valor, tipo);
	}
	
	
	public void atualizarPeso(double peso) {
		this.getAnimal().setPeso(peso);
	}	
	
													//Getters e Setters
	
	public void setDescricao(String obs) {
		this.descricao = obs;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}

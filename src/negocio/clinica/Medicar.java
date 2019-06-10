package negocio.clinica;

import java.util.ArrayList;

import dados.RepositorioMedicamentos;
import excecoes.ProdutoInsulficienteException;

public class Medicar extends Procedimento{
	private ArrayList<Medicamento> medicamentos;

	public Medicar(double valor, String tipo) {
		super(valor, tipo);
	}
	
	//atualiza o repositorio de medicamentos
	public void medicar(RepositorioMedicamentos r) throws ProdutoInsulficienteException{
		for (Medicamento m : medicamentos) {
			if(m.getQuantidade() < 1) {
				throw new ProdutoInsulficienteException();
			}
			Medicamento nova = m;									//copia a vacina
			nova.setQuantidade(m.getQuantidade() - 1);				//diminui 1 da quantidade da vacina
			
			r.atualizar(m, nova);									//atualiza a quantidade no repositorio
		}	
		
	}
	
	//adiciona um medicamento a lista de medicamentos que serao aplicados no animal
	public void addMedicamento(Medicamento m) {
		this.medicamentos.add(m);
	}
	
	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
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

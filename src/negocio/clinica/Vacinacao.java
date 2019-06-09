package negocio.clinica;

import java.util.ArrayList;

import dados.RepositorioVacinas;
import excecoes.VacinaInsulficienteException;

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
	
	public void vacinar(RepositorioVacinas r) throws VacinaInsulficienteException{
		for (Vacina v : vacinas) {
			if(v.getQuantidade() < 1) {
				throw new VacinaInsulficienteException();
			}
			Vacina nova = v;									//copia a vacina
			nova.setQuantidade(v.getQuantidade() - 1);			//diminui 1 da quantidade da vacina
			
			if(nova.getQuantidade() > 0) {						//se ainda existir vacina em estoque
				r.atualizar(v, nova);							//atualiza a quantidade de vacina no repositorio
			}else {												//caso contrario
				r.remover(v);									//remove a vacina do repositorio
			}
		}
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

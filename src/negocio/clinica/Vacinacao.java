package negocio.clinica;

import java.util.ArrayList;

import dados.RepositorioVacinas;
import excecoes.ProdutoInsulficienteException;

public class Vacinacao extends Procedimento{
	private ArrayList<Vacina> vacinas;			//lista de vacinas que serao aplicadas nno animal

	//construtor
	public Vacinacao(String tipo) {	
		super(0, tipo);
		this.vacinas = new ArrayList<Vacina>();
	}

	//adiciona a vacina a lista de vacinas que serão aplicadas no anomal
	public void addVacina(Vacina v) {
		this.vacinas.add(v);
	}
	
	//retorna todas as vacinas que serão aplicadas no animal
	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	}
	
	//atualiza o repositorio de vacinas apos a aplicação das vacinas no animal
	public void vacinar(RepositorioVacinas r) throws ProdutoInsulficienteException{
		for (Vacina v : vacinas) {
			if(v.getQuantidade() < 1) {
				throw new ProdutoInsulficienteException();
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
			this.getData().equals(v.getData())) {
			
			return true;
		}
		
		return false;
	}
	
}

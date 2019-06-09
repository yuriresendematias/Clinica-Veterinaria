package dados;

import java.util.ArrayList;

import excecoes.ProcedimentoJaExisteException;
import negocio.clinica.Procedimento;

public class RepositorioProcedimentos {
	private ArrayList<Procedimento> procedimentos;
	
	public RepositorioProcedimentos() {
		this.procedimentos = new ArrayList<Procedimento>();
	}
	
	public void adicionar(Procedimento p) throws ProcedimentoJaExisteException{
		this.procedimentos.add(p);
	}
	
	public void remover (Procedimento p) {
		this.procedimentos.remove(p);
	}

	public void atualizar(Procedimento p, Procedimento novo) throws ProcedimentoJaExisteException{
		this.remover(p);
		this.adicionar(novo);
	}
	
	public Procedimento getProcedimento(String tipo) {
		for(Procedimento p : this.procedimentos) {
			if(p.getTipo().equals(tipo)) {
				return p;
			}
		}
		
		return null;
	}
	
	public static RepositorioProcedimentos iniciar() {
		return new RepositorioProcedimentos();
	}
	
}

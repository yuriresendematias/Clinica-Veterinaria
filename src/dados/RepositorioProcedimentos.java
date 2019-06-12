package dados;

import java.util.ArrayList;

import excecoes.ProcedimentoJaExisteException;
import negocio.clinica.Atendimento;
import negocio.clinica.Procedimento;
import negocio.clinica.Vacinacao;

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
		
		Procedimento p = new Atendimento(50, "Atendimento");
		Procedimento l = new Vacinacao("Vacinacao");
		Procedimento q = new Procedimento(25, "Banho");
		
		RepositorioProcedimentos r = new RepositorioProcedimentos();
		try {
			r.adicionar(p);
			r.adicionar(q);
			r.adicionar(l);

			
			
		} catch (ProcedimentoJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return r;
	}

	public ArrayList<Procedimento> getList() {
		return procedimentos;
	}
	
}

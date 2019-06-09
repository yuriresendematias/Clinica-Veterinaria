package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import dados.RepositorioProcedimentos;
import excecoes.ProcedimentoJaExisteException;
import excecoes.ProcedimentoNaoAgendadoException;
import negocio.clinica.Atendimento;
import negocio.clinica.Procedimento;

public class Veterinario extends Funcionario{
	ArrayList<Procedimento> listaDeProcedimentos;
	
	public Veterinario(String nome, String cpf, String telefone, LocalDate dataNascimento, String senha, Endereco end) {
		super(nome, cpf, telefone, dataNascimento, senha, end);
		this.listaDeProcedimentos = new ArrayList<Procedimento>();
	}
	
	public void atender(Procedimento p) {		
		this.cancelarProcedimento(p);				//retira o procedimento da agenda
		p.setRealizado(true);						//seta o procedimento como realizado
		this.adicionarProcedimento(p);				//adiciona o procedimento novamente na agenda, mas agora com realizado = true
		p.getAnimal().addProcedimento(p);			//adiciona o procedimento ao historico do animal
	}
	
	
	public void adicionarProcedimento(Procedimento p) {
		this.listaDeProcedimentos.add(p);
	}
	
	public void cancelarProcedimento(Procedimento p) {
		this.listaDeProcedimentos.remove(p);
	}
	
	public void cadastrarProcedimento(double valor, String tipo, RepositorioProcedimentos r) throws ProcedimentoJaExisteException{
		Procedimento p = new Procedimento(valor, tipo);
		r.adicionar(p);
	}
	
	public void removerProcedimento(Procedimento p, RepositorioProcedimentos r) {
		r.remover(p);
	}
	
	public ArrayList<Procedimento> getListaDeProcedimentos() {
		return listaDeProcedimentos;
	}
	
	public Procedimento getProcedimento(Animal a, String tipo) throws ProcedimentoNaoAgendadoException{
		for (Procedimento procedimento : listaDeProcedimentos) {
			if(procedimento.getTipo().equals(tipo) && procedimento.getAnimal().equals(a)) {
				return procedimento;
			}
		}
		
		throw new ProcedimentoNaoAgendadoException();
	}

}

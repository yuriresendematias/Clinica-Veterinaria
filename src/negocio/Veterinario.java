package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import dados.RepositorioMedicamentos;
import dados.RepositorioProcedimentos;
import dados.RepositorioRecepcionista;
import dados.RepositorioVacinas;
import dados.RepositorioVeterinario;
import excecoes.ProcedimentoJaExisteException;
import excecoes.ProcedimentoNaoAgendadoException;
import negocio.clinica.Atendimento;
import negocio.clinica.Medicamento;
import negocio.clinica.Procedimento;
import negocio.clinica.Vacina;
import negocio.clinica.Vacinacao;

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
	
	public void cadastrarVacina(Vacina v,  RepositorioVacinas r) {
		r.adicionar(v);
	}
	
	public void removerVacina(Vacina v, RepositorioVacinas r) {
		r.remover(v);		
	}
	
	public void cadastrarMedicamento(Medicamento m, RepositorioMedicamentos r) {
		r.adicionar(m);
	}
	
	public void removerMedicamento(Medicamento m, RepositorioMedicamentos r) {
		r.remover(m);
	}
	
	public void cadastrarRecepcionista(Recepcionista r, RepositorioRecepcionista rep) {
		rep.add(r);
	}
	
	public void cadastrarVeterinario(Veterinario v , RepositorioVeterinario r) {
		r.add(v);		
	}
	
	public void removerRecepcionista(Recepcionista r, RepositorioRecepcionista rep) {
		rep.remover(r);
	}
	
	public void removerVeterinario(Veterinario v , RepositorioVeterinario r) {
		r.remover(v);		
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

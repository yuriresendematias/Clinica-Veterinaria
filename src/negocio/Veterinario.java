package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import dados.RepositorioProcedimentos;
import negocio.clinica.Atendimento;
import negocio.clinica.Procedimento;

public class Veterinario extends Funcionario{
	ArrayList<Procedimento> listaDeProcedimentos;
	
	public Veterinario(String nome, String cpf, String telefone, LocalDate dataNascimento, String senha, Endereco end) {
		super(nome, cpf, telefone, dataNascimento, senha, end);
		this.listaDeProcedimentos = new ArrayList<Procedimento>();
	}
	
	public void adicionarProcedimento(Procedimento p) {
		this.listaDeProcedimentos.add(p);
	}
	
	public void cancelarProcedimento(Procedimento p) {
		this.listaDeProcedimentos.remove(p);
	}
	
	public void cadastrarProcedimento(double valor, String tipo, RepositorioProcedimentos r) {
		Procedimento p = new Procedimento(valor, tipo);
		r.adicionar(p);
	}
	
	public void removerProcedimento(Procedimento p, RepositorioProcedimentos r) {
		r.remover(p);
	}
	
	

}

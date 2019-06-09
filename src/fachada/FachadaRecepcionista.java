package fachada;

import java.security.spec.ECFieldF2m;
import java.time.LocalDate;

import dados.RepositorioCliente;
import dados.RepositorioProcedimentos;
import dados.RepositorioRecepcionista;
import dados.RepositorioVeterinario;
import excecoes.AnimalNaoCadastradoException;
import excecoes.PessoaJaCadastradaException;
import excecoes.PessoaNaoCadastradoException;
import negocio.Animal;
import negocio.Cliente;
import negocio.Endereco;
import negocio.Funcionario;
import negocio.Recepcionista;
import negocio.Veterinario;
import negocio.clinica.Procedimento;

public class FachadaRecepcionista {
	private RepositorioCliente rc;
	private RepositorioRecepcionista rr;
	private RepositorioVeterinario rv;
	private RepositorioProcedimentos rp;
	private Recepcionista r;
	private Cliente c;
	private Veterinario v;
	
	public FachadaRecepcionista(String login, String senha) {
		try {
			rr = RepositorioRecepcionista.iniciar();
			rc = RepositorioCliente.iniciar();
			rv = RepositorioVeterinario.iniciar();
			r  = (Recepcionista)Funcionario.login(login, senha, rr);
		}catch(PessoaNaoCadastradoException ex) {
			//tratar o erro
		}
	}
	
	
	public void cadastrarCliente(String nome, String cpf, String fone, LocalDate dn,
									String tipoLogradouro, String nomeLogradouro, String num,
									String bairro, String cep, String cidade, String estado, String pais) {
		
		Endereco end = new Endereco(tipoLogradouro, nomeLogradouro, num, bairro, cep, cidade, estado, pais);
		Cliente c = new Cliente(nome, cpf, fone, dn, end);
		
		try {
			this.r.cadastrarCliente(c, rc);
		}catch(PessoaJaCadastradaException e) {
			//tratar o erro
		}
	}
	
	public void cadastrarAnimal(String cpfDono, String nomeAnimal, String raca, LocalDate dn) {
		try {
			Cliente c = (Cliente) this.rc.getPessoa(cpfDono);
			Animal a = new Animal(nomeAnimal, raca, c, dn);
			c.addAnimal(a);
		}catch(PessoaNaoCadastradoException e) {
			//tratar o erro
		}//animal ja cadastrado
	}
	

	public void agendarProcedimento(String nomeProcedimento, LocalDate data, String nomeAnimal, String cpfDono, String cpfVeterinario) {
		try{
			Procedimento p = this.rp.getProcedimento(nomeProcedimento);
			Veterinario v = (Veterinario)this.rv.getPessoa(cpfVeterinario);
			Cliente c = (Cliente)this.rc.getPessoa(cpfDono);
			Animal a = c.getAnimal(nomeAnimal);
			
			p.setData(data);
			p.setAnimal(a);
			p.setProficional(v);
		}catch(AnimalNaoCadastradoException e) {
			//tratar o erro
		}catch(PessoaNaoCadastradoException e) {
			//tratr o erro
		}
		//procedimento nao cadastratado
	}
	
	/*
	 * remarca um procedimento agendado
	 */
	public void remarcarProcedimento(String nomeProcedimento, LocalDate data, LocalDate novaData, String nomeAnimal, String cpfDono, String cpfVeterinario) {
		this.cancelarProcedimento(nomeProcedimento, data, nomeAnimal, cpfDono, cpfVeterinario);
		this.agendarProcedimento(nomeProcedimento, novaData, nomeAnimal, cpfDono, cpfVeterinario);
	}
	
	/*
	 * cancela um procedimento agendado
	 */
	public void cancelarProcedimento(String nomeProcedimento, LocalDate data, String nomeAnimal, String cpfDono, String cpfVeterinario) {
		Procedimento p = this.getProcedimentoAgendado(nomeProcedimento, data, nomeAnimal, cpfDono, cpfVeterinario);
		p.getProficional().cancelarProcedimento(p);		
	}
	
	/*
	 * retorna um procedimento agendado
	 */
	private Procedimento getProcedimentoAgendado(String nomeProcedimento, LocalDate data, String nomeAnimal, String cpfDono, String cpfVeterinario) {
		try {
			Procedimento p = this.rp.getProcedimento(nomeProcedimento);
			Veterinario v = (Veterinario)this.rv.getPessoa(cpfVeterinario);
			Cliente c = (Cliente)this.rc.getPessoa(cpfDono);
			Animal a = c.getAnimal(nomeAnimal);
			
			p.setData(data);
			p.setAnimal(a);
			p.setProficional(v);
			
			return p;
		}catch(AnimalNaoCadastradoException e) {
			//tratar o erro
		}catch(PessoaNaoCadastradoException e) {
			//tratr o erro
		}
		//procedimento nao cadastratado
		return null;
	}
	
	public Recepcionista getRecepcionista() {
		return this.r;
	}
}

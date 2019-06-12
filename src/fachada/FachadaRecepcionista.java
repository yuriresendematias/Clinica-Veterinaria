package fachada;

import java.security.spec.ECFieldF2m;
import java.time.LocalDate;
import java.util.ArrayList;

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

public class FachadaRecepcionista implements Ifachada {
	private RepositorioCliente rc;
	private RepositorioRecepcionista rr;
	private RepositorioVeterinario rv;
	private RepositorioProcedimentos rp;
	private Recepcionista r;
	private Cliente c;
	private Veterinario v;
	
	public FachadaRecepcionista() {
			rr = RepositorioRecepcionista.iniciar();
			rc = RepositorioCliente.iniciar();
			rv = RepositorioVeterinario.iniciar();
			rp = RepositorioProcedimentos.iniciar();
	}
	
	@Override
	public FachadaRecepcionista login(String login, String senha) throws PessoaNaoCadastradoException{
		r  = (Recepcionista)Funcionario.login(login, senha, rr);
		return this;
	}
	
	
	public void cadastrarCliente(String nome, String cpf, String fone, LocalDate dn,
									String tipoLogradouro, String nomeLogradouro, String num,
									String bairro, String cep, String cidade, String estado, String pais) throws PessoaJaCadastradaException {
		
		Endereco end = new Endereco(tipoLogradouro, nomeLogradouro, num, bairro, cep, cidade, estado, pais);
		Cliente c = new Cliente(nome, cpf, fone, dn, end);
		
		this.r.cadastrarCliente(c, rc);
	}
	
	public void cadastrarAnimal(String cpfDono, String nomeAnimal, String raca, LocalDate dn) throws PessoaNaoCadastradoException{
		Cliente c = (Cliente) this.rc.getPessoa(cpfDono);
		Animal a = new Animal(nomeAnimal, raca, c, dn);
		c.addAnimal(a);
	}
	

	public void agendarProcedimento(String nomeProcedimento, LocalDate data, String nomeAnimal, String cpfDono, String cpfVeterinario)throws  PessoaNaoCadastradoException, AnimalNaoCadastradoException{
		Procedimento p = this.rp.getProcedimento(nomeProcedimento);
		Veterinario v = (Veterinario)this.rv.getPessoa(cpfVeterinario);
		Cliente c = (Cliente)this.rc.getPessoa(cpfDono);
		Animal a = c.getAnimal(nomeAnimal);
		
		p.setData(data);
		p.setAnimal(a);
		p.setProficional(v);
	}
	
	/*
	 * remarca um procedimento agendado
	 */
	public void remarcarProcedimento(String nomeProcedimento, LocalDate data, LocalDate novaData, String nomeAnimal, String cpfDono, String cpfVeterinario) throws PessoaNaoCadastradoException, AnimalNaoCadastradoException {
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
	

	/**
	 * @param cpf
	 * @return um cliente cadastrado no sistema
	 * @throws PessoaNaoCadastradoException
	 */
	public Cliente pesquisarCliente(String cpf) throws PessoaNaoCadastradoException {
		Cliente c = (Cliente) this.rc.getPessoa(cpf);
		return c;
	}
	
	/**
	 * 
	 * @return a lista de clientes cadastrados no sistema
	 */
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> clientes = rc.getPessoas();
		return clientes;
	}
	
	/**
	 * 
	 * @return a lista de veterinarios cadastrados no sistema
	 */
	public ArrayList<Veterinario> listarVeterinarios(){
		ArrayList<Veterinario> veterinarios = rv.getPessoas();
		return veterinarios;
	}

	public void atualizarCliente(Cliente novo) throws PessoaNaoCadastradoException {
		rc.atualizar(rc.getPessoa(novo.getCpf()), novo);
		
	}

	public ArrayList<Procedimento> listarProcedimentos() {
		return this.rp.getList();
	}
	
}

package fachada;

import java.time.LocalDate;

import dados.RepositorioCliente;
import dados.RepositorioRecepcionista;
import dados.RepositorioVeterinario;
import excecoes.RecepcionistaNaoCadastradoExeption;
import negocio.Cliente;
import negocio.Funcionario;
import negocio.Recepcionista;
import negocio.Veterinario;

public class FachadaRecepcionista {
	private RepositorioCliente rc;
	private RepositorioRecepcionista rr;
	private RepositorioVeterinario rv;
	private Recepcionista r;
	private Cliente c;
	private Veterinario v;
	
	public FachadaRecepcionista(String login, String senha) {
		try {
			rr = RepositorioRecepcionista.iniciar();
			r  = (Recepcionista)Funcionario.login(login, senha, rr);
		}//adicionar catch para RepositorioRecepcionista.iniciar();
		catch(RecepcionistaNaoCadastradoExeption ex) {
			ex.exibir("Login ou senha incorretos!");
		}
	}
	
	public void agendarProcedimento(String codVet, String codCli, String nomeAnimal, 
								String tipo, double valor, LocalDate data) {
		
	}
	
	public void cadastrarCliente() {
		
	}
	
	public void cadastrarAnimal() {
		
	}
	
	public void remarcarProcedimento() {
		
	}
	
	public void cancelarProcedimento() {
		
	}
	
	
	
	
	public Recepcionista getRecepcionista() {
		return this.r;
	}
}

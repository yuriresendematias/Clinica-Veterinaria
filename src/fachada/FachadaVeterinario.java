package fachada;

import negocio.*;
import negocio.clinica.Procedimento;
import negocio.clinica.Vacina;
import negocio.clinica.Vacinacao;
import dados.*;
import excecoes.AnimalNaoCadastradoException;
import excecoes.PessoaNaoCadastradoException;
import excecoes.ProcedimentoJaExisteException;
import excecoes.ProcedimentoNaoAgendadoException;
import excecoes.VacinaInsulficienteException;
import excecoes.VacinaNaoCadastradaException;

import java.time.LocalDate;
import java.util.ArrayList;

public class FachadaVeterinario {
	private Veterinario veterinario;
	private RepositorioVeterinario repVet;
	private RepositorioCliente repCli;
	private RepositorioProcedimentos repPro;
	private RepositorioRecepcionista repRec;
	private RepositorioVacinas repVacinas;
	
	
	public FachadaVeterinario (String login, String senha){
		try {
			this.repVet = RepositorioVeterinario.iniciar();
			this.repCli = RepositorioCliente.iniciar();
			this.repRec = RepositorioRecepcionista.iniciar();
			this.repPro = RepositorioProcedimentos.iniciar();
			this.repVacinas = RepositorioVacinas.iniciar();
			this.veterinario = (Veterinario)Veterinario.login(login, senha, this.repVet);
			
		}catch(PessoaNaoCadastradoException e) {
			//tratar o erro
		}
	}
	
	
	public void atender(String nomeAnimal, String cpfCliente, String nomeProcedimento) {
		
		
	}
	
	//medicar (criar um repositorio de medicamentos, criar o metodo medicar em Medimar)
	//seguir o modelo de vacina��o
	
	//vacina um animal, atualiza a agenda do veterinario, atualiza o historico do animal, e atualiza o repositorio de vacinas
	public void vacinar(String nomeAnimal, String cpfCliente, ArrayList<String> vacinas, ArrayList<String> lote) {
		try {
			Cliente c = (Cliente)this.repCli.getPessoa(cpfCliente);
			Animal a = c.getAnimal(nomeAnimal);
			Vacinacao p = (Vacinacao)this.veterinario.getProcedimento(a, "vacinacao");
			
			if(p.getData().equals(LocalDate.now()) && p.getRealizado() == false) {
			
				for (int i = 0; i < vacinas.size(); i++) {
					Vacina v = this.repVacinas.getVacina(vacinas.get(i), lote.get(i));
					p.addVacina(v);
				}
				
				p.vacinar(repVacinas);
				this.veterinario.atender(p);
			}else {
				
				//procedimento nao agendado ou ja realizado
			}
			
			
		}catch(PessoaNaoCadastradoException e) {
			//tratar erro
		} catch (AnimalNaoCadastradoException e) {
			// tratar erro
		} catch (VacinaNaoCadastradaException e) {
			// tratar erro
		} catch (ProcedimentoNaoAgendadoException e) {
			// tratar erro
		} catch (VacinaInsulficienteException e) {
			// tratar erro
		}
	}
	
	public void agendarProcedimento(String tipo, String nomeAnimal, String cpfDono, LocalDate data) {
		try {
			Cliente c = (Cliente) this.repCli.getPessoa(cpfDono);
			Animal animal = c.getAnimal(nomeAnimal);
			Procedimento p = this.repPro.getProcedimento(tipo);
			//verificar se o procedimento � retornado em forma de Procedimento ou no formao das suas subclasses!!
					
			p.setAnimal(animal);
			p.setData(data);
			p.setProficional(this.veterinario);
						
			this.veterinario.adicionarProcedimento(p);
			
		}catch(PessoaNaoCadastradoException e) {
			//tratar erro
		} catch (AnimalNaoCadastradoException e) {
			// Tratar erro
		}
		
	}
	
	public void cancelarProcedimento(String nomeAnimal, String cpfCliente, String tipoProcedimento, LocalDate data) {
		try {
			Cliente c = (Cliente) this.repCli.getPessoa(cpfCliente);
			Animal a = c.getAnimal(nomeAnimal);
			Procedimento p = this.repPro.getProcedimento(tipoProcedimento);
			
			p.setData(data);
			p.setAnimal(a);
			p.setProficional(this.veterinario);
		}catch(PessoaNaoCadastradoException e) {
			//tratar erro
		} catch (AnimalNaoCadastradoException e) {
			// Tratar erro
		}
	}
	
	public void cadastrarProcedimento(double valor, String tipo) {
		Procedimento p = new Procedimento(valor, tipo);
		
		try {
			this.repPro.adicionar(p);
		}catch(ProcedimentoJaExisteException e) {
			//tratar erro
		}
	}
	
	public void removerProcedimento(String tipo) {
		Procedimento p = this.repPro.getProcedimento(tipo);
		this.veterinario.removerProcedimento(p, repPro);
	}
	
	

}

package fachada;

import negocio.*;
import negocio.clinica.Atendimento;
import negocio.clinica.Medicamento;
import negocio.clinica.Medicar;
import negocio.clinica.Procedimento;
import negocio.clinica.Vacina;
import negocio.clinica.Vacinacao;
import dados.*;
import excecoes.AnimalNaoCadastradoException;
import excecoes.PessoaNaoCadastradoException;
import excecoes.ProcedimentoJaExisteException;
import excecoes.ProcedimentoNaoAgendadoException;
import excecoes.ProdutoInsulficienteException;
import excecoes.ProdutoNaoCadastradoException;

import java.time.LocalDate;
import java.util.ArrayList;

public class FachadaVeterinario {
	private Veterinario veterinario;
	private RepositorioVeterinario repVet;
	private RepositorioCliente repCli;
	private RepositorioProcedimentos repPro;
	private RepositorioRecepcionista repRec;
	private RepositorioVacinas repVacinas;
	private RepositorioMedicamentos repMedicamentos;
	
	//construtor
	public FachadaVeterinario (String login, String senha){
		try {
			this.repVet = RepositorioVeterinario.iniciar();
			this.repCli = RepositorioCliente.iniciar();
			this.repRec = RepositorioRecepcionista.iniciar();
			this.repPro = RepositorioProcedimentos.iniciar();
			this.repVacinas = RepositorioVacinas.iniciar();
			this.repMedicamentos = RepositorioMedicamentos.iniciar();
			this.veterinario = (Veterinario)Veterinario.login(login, senha, this.repVet);
			
		}catch(PessoaNaoCadastradoException e) {
			//tratar o erro
		}
	}
	
	

	
	
	
	//cadastrar
	
	
	public Endereco cadastrarEndereco(String tipo, String nome, String num, String bairro, String cep, String cidade, String estado, String pais) {
		return new Endereco(tipo, nome, num, bairro, cep, cidade, estado, pais);
	}

	public void cadastrarRecepcionista(String nome, String cpf, String telefone, LocalDate dataNascimento, String senha, Endereco end) {
		Recepcionista r = new Recepcionista(nome, cpf, telefone, dataNascimento, senha, end);
		this.veterinario.cadastrarRecepcionista(r, this.repRec);
	}
	
	public void cadastrarVeterinario(String nome, String cpf, String telefone, LocalDate dataNascimento, String senha, Endereco end) {
		Veterinario v = new Veterinario(nome, cpf, telefone, dataNascimento, senha, end);
		this.veterinario.cadastrarVeterinario(v, repVet);
	}
	
	public void cadastrarVacina(String nome, String lote, LocalDate validade, LocalDate fabricacao, int quantidade, double valor) {
		Vacina v = new Vacina(nome, lote, validade, fabricacao, quantidade, valor);
		this.veterinario.cadastrarVacina(v, repVacinas);
	}
	
	public void cadastrarMedicamento(String nome, double dose, LocalDate validade, LocalDate fabricacao, int quantidade, double valor) {
		Medicamento m = new Medicamento (nome, dose, validade, fabricacao, quantidade, valor);
		this.veterinario.cadastrarMedicamento(m, repMedicamentos);
	}
	
	/**
	 * Cadastra um novo Procedimento no repositorio de procedimentos
	 * @param valor
	 * @param tipo
	 */
	public void cadastrarProcedimento(double valor, String tipo) {
		Procedimento p = new Procedimento(valor, tipo);
		
		try {
			this.repPro.adicionar(p);
		}catch(ProcedimentoJaExisteException e) {
			//tratar erro
		}
	}
	
	/**
	 * Cadastra um procedimento no repositorio de procedimentos. 
	 * OP = 1 cadastra um atendimento (cirurgia ou consulta)
	 * op = 2 cadastra uma vacinacao
	 * op = 3 cadastra medicar
	 * @param valor
	 * @param tipo
	 * @param op
	 */
	public void cadastrarProcedimento(double valor, String tipo, int op) {
		Procedimento p = new Procedimento(valor, tipo);
		
		switch(op) {
			case 1:
				p = new Atendimento(valor, tipo);
				break;
			case 2:
				p = new Vacinacao(tipo);
				break;
			case 3:
				p = new Medicar(valor, tipo);
				break;
			default:
				break;
		}
		try {
			this.repPro.adicionar(p);
		}catch(ProcedimentoJaExisteException e) {
			//tratar erro
		}
	}
	
	
	
	
	
	
	
	
	
	

	
	//remover
	public void removerRecepcionista(String cpf) {
		try {
			this.veterinario.removerRecepcionista((Recepcionista)(this.repRec.getPessoa(cpf)), this.repRec);
		} catch (PessoaNaoCadastradoException e) {
			//tratar o erro
		}
	}
	
	public void removerVeterinario(String cpf){
		try {
			this.veterinario.removerVeterinario((Veterinario)(this.repRec.getPessoa(cpf)), this.repVet);
		} catch (PessoaNaoCadastradoException e) {
			//tratar o erro
		}
	}
	
	public void removerVacina(String nome, String lote){
		try {
			this.veterinario.removerVacina((Vacina)this.repVacinas.getProduto(nome, lote), repVacinas);
		} catch (ProdutoNaoCadastradoException e) {
			//tratar o erro
		}
	}
	
	public void removerMedicamento(String nome, String dose){
		try {
			this.veterinario.removerMedicamento((Medicamento)this.repMedicamentos.getProduto(nome, dose), repMedicamentos);
		} catch (ProdutoNaoCadastradoException e) {
			//tratar o erro
		}
	}
	

	/**
	 * Remove um procedimento do repositorio de procedimentos
	 * @param tipo
	 */
	public void removerProcedimento(String tipo) {
		Procedimento p = this.repPro.getProcedimento(tipo);
		this.veterinario.removerProcedimento(p, repPro);
	}
	

	
	


	
	
	
	
	
	//funcionalidades do veterinario
	
	/**
	 * Atende um animal (procedimentos que nao precisam de observações, como banho e tosa)
	 * atualiza o historico do animal e a agenda do veterinario
	 * @param nomeAnimal
	 * @param cpfCliente
	 * @param nomeProcedimento
	 */
	public void atender(String nomeAnimal, String cpfCliente, String nomeProcedimento) {//usado para atendimentos como banho e tosa que nao precisam de descrição
		try {
			Cliente c = (Cliente)this.repCli.getPessoa(cpfCliente);
			Animal a = c.getAnimal(nomeAnimal);
			Procedimento p = this.veterinario.getProcedimento(a, nomeProcedimento);
			
			this.veterinario.atender(p); 						//atualiza o historico do animal e a agenda do veterinario
			
			
		}catch(PessoaNaoCadastradoException e) {
			//tratar erro
		} catch (AnimalNaoCadastradoException e) {
			// tratar erro
		} catch (ProcedimentoNaoAgendadoException e) {
			// tratar erro
		}
	}
	
	/**
	 * Atende um animal (procedimentos que tenham observações, como cirurgias, ou atendimentos no consultorio)
	 * atualiza o historico do animal e a agenda do veterinario
	 * @param nomeAnimal
	 * @param cpfCliente
	 * @param nomeProcedimento
	 * @param observacoes
	 */
	public void atender(String nomeAnimal, String cpfCliente, String nomeProcedimento, String observacoes) {
		try {
			Cliente c = (Cliente)this.repCli.getPessoa(cpfCliente);
			Animal a = c.getAnimal(nomeAnimal);
			Atendimento p = (Atendimento)veterinario.getProcedimento(a, nomeProcedimento);
			
			p.setDescricao(observacoes);
			
			veterinario.atender(p);
			
		} catch (PessoaNaoCadastradoException e) {
			// tratar o erro
		} catch (AnimalNaoCadastradoException e) {
			//tratar o erro
		} catch (ProcedimentoNaoAgendadoException e) {
			// tratar o erro
		}
	}
	
	/**
	 * Medica um animal, atualiza a agenda do veterinario, atualiza o historico do animal e  atualiza o repositorio de medicamentos
	 * @param nomeAnimal
	 * @param cpfCliente
	 * @param nomeMedicamento
	 * @param doseMedicamento
	 * @param quantidade
	 */
	public void medicar(String nomeAnimal, String cpfCliente, ArrayList<String> nomeMedicamento, ArrayList<String> doseMedicamento, ArrayList<Integer> quantidade) {
		//medicar (criar um repositorio de medicamentos, criar o metodo medicar em Medimar)
		//seguir o modelo de vacinação
		
		try {
			Cliente c = (Cliente)this.repCli.getPessoa(cpfCliente);
			Animal a = c.getAnimal(nomeAnimal);
			Medicar p = (Medicar)this.veterinario.getProcedimento(a, "medicar");
			
			if(p.getData().equals(LocalDate.now()) && p.getRealizado() == false) {
				
				for (int i = 0; i < nomeMedicamento.size(); i++) {
					Medicamento m = this.repMedicamentos.getProduto(nomeMedicamento.get(i), doseMedicamento.get(i));
					
					for(i = 0; i < quantidade.get(i).intValue(); i++) {		
						p.addMedicamento(m);
						p.setValor(p.getValor()+m.getValor());
					}
					
				}
				
				p.medicar(repMedicamentos);						//atualiza o repositorio de medicamentos
				this.veterinario.atender(p);					//atualiza a agendaa do veterinario e o historico do animal, alem de marcar o procedimento como realizado
			}else {
				
				//procedimento nao agendado para hoje ou ja realizado
			}

		} catch (PessoaNaoCadastradoException e) {
			// tratar o erro
		} catch (AnimalNaoCadastradoException e) {
			//tratar o erro
		} catch (ProcedimentoNaoAgendadoException e) {
			//tratar erro
		} catch (ProdutoInsulficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProdutoNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Vacina um animal, atualiza a agenda do veterinario, atualiza o historico do animal e atualiza o repositorio de vacinas
	 * @param nomeAnimal
	 * @param cpfCliente
	 * @param vacinas
	 * @param lote
	 */
	public void vacinar(String nomeAnimal, String cpfCliente, ArrayList<String> vacinas, ArrayList<String> lote) {
		try {
			Cliente c = (Cliente)this.repCli.getPessoa(cpfCliente);
			Animal a = c.getAnimal(nomeAnimal);
			Vacinacao p = (Vacinacao)this.veterinario.getProcedimento(a, "vacinacao");
			
			if(p.getData().equals(LocalDate.now()) && p.getRealizado() == false) {
			
				for (int i = 0; i < vacinas.size(); i++) {
					Vacina v = this.repVacinas.getProduto(vacinas.get(i), lote.get(i));
					p.addVacina(v);
					p.setValor(p.getValor()+v.getValor());
				}
				
				p.vacinar(repVacinas);						//atualiza o repositorio de vacinas
				this.veterinario.atender(p);				//atualiza a agendaa do veterinario e o historico do animal, alem de marcar o procedimento como realizado
			}else {
				
				//procedimento nao agendado ou ja realizado
			}
			
			
		}catch(PessoaNaoCadastradoException e) {
			//tratar erro
		} catch (AnimalNaoCadastradoException e) {
			// tratar erro
		} catch (ProdutoNaoCadastradoException e) {
			// tratar erro
		} catch (ProcedimentoNaoAgendadoException e) {
			// tratar erro
		} catch (ProdutoInsulficienteException e) {
			// tratar erro
		}
	}

	
	/**
	 * Agenda um Procedimento na agenda do Veterinario, adicionanco o Procedimento na lista de Procedimentos do Veterinario
	 * @param tipo
	 * @param nomeAnimal
	 * @param cpfDono
	 * @param data
	 */
	public void agendarProcedimento(String tipo, String nomeAnimal, String cpfDono, LocalDate data) {
		try {
			Cliente c = (Cliente) this.repCli.getPessoa(cpfDono);
			Animal animal = c.getAnimal(nomeAnimal);
			Procedimento p = this.repPro.getProcedimento(tipo);
			//verificar se o procedimento é retornado em forma de Procedimento ou no formao das suas subclasses!!
					
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
	
	/**
	 * Cancela um Procedimento agendado para o Veterinario
	 * @param nomeAnimal
	 * @param cpfCliente
	 * @param tipoProcedimento
	 * @param data
	 */
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
}

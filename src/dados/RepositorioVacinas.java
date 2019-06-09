package dados;

import java.util.ArrayList;

import excecoes.VacinaNaoCadastradaException;
import negocio.clinica.Vacina;

public class RepositorioVacinas{
	private ArrayList<Vacina> lista;
	
	public RepositorioVacinas() {
		this.lista = new ArrayList<Vacina>();
	}
	
	public void adicionar(Vacina v) {
		this.lista.add(v);
	}
	
	public void remover(Vacina v) {
		this.lista.remove(v);
	}
	
	public void atualizar(Vacina v, Vacina nova) {
		this.lista.remove(v);
		this.lista.add(nova);
	}
	
	public Vacina getVacina(String nome, String lote) throws VacinaNaoCadastradaException{
		for (Vacina vacina : lista) {
			if (vacina.getNome().equals(nome) && vacina.getLote().equals(lote)){
				return vacina;
			}
		}
		
		throw new VacinaNaoCadastradaException();
	}
	
	public static RepositorioVacinas iniciar() {
		return new RepositorioVacinas();
	}
}

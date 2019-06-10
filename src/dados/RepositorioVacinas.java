package dados;

import java.util.ArrayList;

import excecoes.ProdutoNaoCadastradoException;
import negocio.clinica.Produto;
import negocio.clinica.Vacina;

public class RepositorioVacinas implements IrepositorioProdutos{
	private ArrayList<Vacina> lista;
	
	public RepositorioVacinas() {
		this.lista = new ArrayList<Vacina>();
	}


	@Override
	public void adicionar(Produto p) {
		this.lista.add((Vacina)p);
	}

	@Override
	public void remover(Produto v) {
		this.lista.remove(v);
		
	}

	@Override
	public void atualizar(Produto v, Produto nova) {
		this.remover(v);
		this.adicionar(nova);
	}
	
	@Override
	public Vacina getProduto(String nome, String lote) throws ProdutoNaoCadastradoException{
		for (Vacina vacina : lista) {
			if (vacina.getNome().equals(nome) && vacina.getLote().equals(lote)){
				return vacina;
			}
		}
		
		throw new ProdutoNaoCadastradoException();
	}
	
	
	public static RepositorioVacinas iniciar() {
		return new RepositorioVacinas();
	}
}

package dados;

import java.util.ArrayList;
import excecoes.ProdutoNaoCadastradoException;
import negocio.clinica.Medicamento;
import negocio.clinica.Produto;



public class RepositorioMedicamentos implements IrepositorioProdutos{
	private ArrayList<Medicamento> lista;
	
	public RepositorioMedicamentos(){
		this.lista = new ArrayList<Medicamento>();
	}

	@Override
	public void adicionar(Produto p) {
		this.lista.add((Medicamento)p);
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
	public Medicamento getProduto(String nome, String dose) throws ProdutoNaoCadastradoException{
		for (Medicamento medicamento : lista) {
			if(medicamento.getNome().equals(nome) && medicamento.getDose() == Double.parseDouble(dose) ) {
				return null;
			}
		}
		
		throw new ProdutoNaoCadastradoException();
	}
	
	public static RepositorioMedicamentos iniciar() {
		return new RepositorioMedicamentos();
	}
}

package dados;

import excecoes.ProdutoNaoCadastradoException;
import negocio.clinica.Produto;
import negocio.clinica.Vacina;

public interface IrepositorioProdutos {
	public void adicionar(Produto p);	
	public void remover(Produto v);
	public void atualizar(Produto v, Produto nova);	
	public Produto getProduto(String nome, String lote) throws ProdutoNaoCadastradoException;
	
}

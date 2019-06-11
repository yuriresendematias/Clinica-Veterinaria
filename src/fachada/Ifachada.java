package fachada;

import excecoes.PessoaNaoCadastradoException;

public interface Ifachada {
	public Ifachada login(String login, String senha) throws PessoaNaoCadastradoException;
}

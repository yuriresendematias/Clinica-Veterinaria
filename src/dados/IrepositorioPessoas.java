package dados;

import excecoes.PessoaNaoCadastradoException;
import negocio.Pessoa;

public interface IrepositorioPessoas {
    void add(Pessoa p);
    void remover(Pessoa p);
    void atualizar(Pessoa p, Pessoa nova);
    Pessoa getPessoa(String cpf) throws PessoaNaoCadastradoException;
    IrepositorioPessoas iniciar();

}

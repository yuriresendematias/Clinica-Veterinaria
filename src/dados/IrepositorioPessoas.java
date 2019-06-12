package dados;

import java.util.ArrayList;

import excecoes.PessoaJaCadastradaException;
import excecoes.PessoaNaoCadastradoException;
import negocio.Pessoa;

public interface IrepositorioPessoas {
    void add(Pessoa p) throws PessoaJaCadastradaException;
    void remover(Pessoa p);
    void atualizar(Pessoa p, Pessoa nova);
    Pessoa getPessoa(String cpf) throws PessoaNaoCadastradoException;
    ArrayList getPessoas ();
}

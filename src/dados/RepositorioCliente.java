package dados;

import java.util.ArrayList;

import excecoes.PessoaNaoCadastradoException;
import negocio.Cliente;
import negocio.Pessoa;

public class RepositorioCliente implements IrepositorioPessoas {
    private ArrayList<Cliente> lista;


    public RepositorioCliente() {
        this.lista = new ArrayList<Cliente>();
    }

    @Override
    public void add(Pessoa p) {
        this.lista.add((Cliente) p);
    }

    @Override
    public void remover(Pessoa p) {
        this.lista.remove(p);
    }

    @Override
    public void atualizar(Pessoa p, Pessoa nova) {
        this.lista.remove(p);
        this.lista.add((Cliente)nova);
    }

    @Override
    public Pessoa getPessoa(String cpf) throws PessoaNaoCadastradoException{
  
        for(Cliente c : lista){
            if(c.getCpf().equals(cpf))
                return c;
        }
        throw new PessoaNaoCadastradoException();
    }
    
    public static RepositorioCliente iniciar() {
    	return new RepositorioCliente();
    }
}

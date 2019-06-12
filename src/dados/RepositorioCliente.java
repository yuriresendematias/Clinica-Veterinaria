package dados;

import java.time.LocalDate;
import java.util.ArrayList;

import excecoes.PessoaNaoCadastradoException;
import negocio.Animal;
import negocio.Cliente;
import negocio.Endereco;
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
    
    @Override
    public ArrayList getPessoas(){
    	return this.lista;
    }
    
    public static RepositorioCliente iniciar() {
    	Endereco end = new Endereco("Rua", "nao sei o nome da rua", "23454", "onde judas perdeu as botas", "55123-333", "garanhuns", "pernambuco", "Brasil ");
		Cliente c = new Cliente("nome do cliente nao sei de que", "111", "(87)98112-4567", LocalDate.now(), end);
		Animal a = new Animal("zezin", "raça", c, LocalDate.of(2000, 11, 20) );
		Animal b = new Animal("nome animal", "cachorro", c, LocalDate.now());
		
		c.addAnimal(a);
		c.addAnimal(b);
    	
		RepositorioCliente r = new RepositorioCliente();
		r.add(c);
				
		return r;
    }
}

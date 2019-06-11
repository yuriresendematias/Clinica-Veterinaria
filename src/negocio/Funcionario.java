package negocio;

import java.time.LocalDate;
import dados.IrepositorioPessoas;
import excecoes.PessoaNaoCadastradoException;

public abstract class Funcionario extends Pessoa {
    private String senha;

    public Funcionario(String nome, String cpf, String telefone, LocalDate dataNascimento, String senha, Endereco end) {
        super(nome, cpf, telefone, dataNascimento, end);
        this.senha = senha;
    }

    /**
     *
     * @param cpf
     * @param senha
     * @return True se a senha e o login passados como parametro forem igual ao login e a senha do funcionario
     */
    public static Funcionario login(String cpf, String senha, IrepositorioPessoas r) throws PessoaNaoCadastradoException{
    	if(r.getPessoa(cpf) instanceof Funcionario) {
    		Funcionario f = (Funcionario)r.getPessoa(cpf);
    		if(f.getSenha().equals(senha)) {
    			return f;
    		}
    	}
    	
    	throw new PessoaNaoCadastradoException();
    	
    }


    //getters e setters

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

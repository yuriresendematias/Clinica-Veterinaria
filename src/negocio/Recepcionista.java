package negocio;

import java.time.LocalDate;

import dados.RepositorioCliente;
import negocio.clinica.Procedimento;

public class Recepcionista extends Funcionario {
    public Recepcionista(String nome, String cpf, String telefone, LocalDate dataNascimento, String senha, Endereco end) {
        super(nome, cpf, telefone, dataNascimento, senha, end);
    }

    
    public void agendarProcedimento(Procedimento p, Veterinario v, LocalDate data, Animal a) {
    	p.setProficional(v);
    	p.setAnimal(a);
    	p.setData(data);
    	v.adicionarProcedimento(p);
    }
    
    public void cadastrarCliente(Cliente c, RepositorioCliente r){
        r.add(c);
    }

    public void atualizarCliente(Cliente c, Cliente novo, RepositorioCliente r){
        r.atualizar(c, novo);
    }

    public void cadastrarAnimal(Animal a, Cliente c){
    	c.addAnimal(a);
    }

    public void atualizarAnimal(Animal a, Animal novo, Cliente c){
    	c.atualizarAnimal(a, novo);
    }
    
    public void remarcarProcedimento(Procedimento p, LocalDate data){
    	this.cancelarProcedimento(p);
    	p.getProficional().adicionarProcedimento(p);
    }
    
    public void cancelarProcedimento(Procedimento p) {
    	p.getProficional().cancelarProcedimento(p);
    }
}

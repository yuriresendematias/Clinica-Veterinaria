package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa {
    ArrayList<Animal> listaAnimais;
	
	public Cliente(String nome, String cpf, String telefone, LocalDate dataNascimento, Endereco end) {
        super(nome, cpf, telefone, dataNascimento, end);
        this.listaAnimais = new ArrayList<Animal>();
    }
	
	
	public void addAnimal(Animal a) {
		this.listaAnimais.add(a);
	}
	
	private void removerAnimal(Animal a) {
		this.listaAnimais.remove(a);
	}
	
	public void atualizarAnimal(Animal a, Animal novo) {
		this.removerAnimal(a);
		this.addAnimal(novo);
	}
}

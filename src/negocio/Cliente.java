package negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import excecoes.AnimalNaoCadastradoException;

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
	
	public ArrayList<Animal> getListaAnimais() {
		return listaAnimais;
	}
	
	public void setListaAnimais(ArrayList<Animal> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}
	
	public Animal getAnimal(String nome) throws AnimalNaoCadastradoException{
		for (Animal a : this.listaAnimais) {
			if(a.getNome().equals(nome)) {
				return a;
			}
		}
		throw new AnimalNaoCadastradoException();
	}
}

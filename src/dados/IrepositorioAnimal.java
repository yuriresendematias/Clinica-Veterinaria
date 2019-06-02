package dados;

import negocio.Animal;
import negocio.Pessoa;

public interface IrepositorioAnimal {
    void add(Animal a);
    void remover(Animal a);
    void atualizar(Animal a, Animal b);
    Animal getAnimal(Pessoa dono, String nome);
}

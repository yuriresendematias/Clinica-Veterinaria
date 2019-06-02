package dados;

import java.util.ArrayList;

import negocio.Pessoa;
import negocio.Veterinario;

public class RepositorioVeterinario implements IrepositorioPessoas{
	ArrayList<Veterinario> lista;
	
	
	public RepositorioVeterinario() {
		this.lista = new ArrayList<Veterinario>();
	}


	@Override
	public void add(Pessoa p) {
		this.lista.add((Veterinario)p);
	}


	@Override
	public void remover(Pessoa p) {
		this.lista.remove((Veterinario)p);		
	}


	@Override
	public void atualizar(Pessoa p, Pessoa nova) {
		this.remover(p);
		this.add(nova);
		
	}


	@Override
	public Pessoa getPessoa(String cpf) {
		for(Veterinario v : this.lista) {
			if(v.getCpf().equals(cpf)) {
				return v;
			}
		}
		return null;
	}
}

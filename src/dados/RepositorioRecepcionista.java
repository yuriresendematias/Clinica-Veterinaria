package dados;

import java.time.LocalDate;
import java.util.ArrayList;

import negocio.Pessoa;
import negocio.Recepcionista;

public class RepositorioRecepcionista implements IrepositorioPessoas{
	ArrayList<Recepcionista> lista;
	
	
	public RepositorioRecepcionista() {
		this.lista = new ArrayList<Recepcionista>();
	}	
	
	@Override
	public void add(Pessoa p) {
		this.lista.add((Recepcionista)p);
	}
	@Override
	public void atualizar(Pessoa p, Pessoa nova) {
		this.lista.remove((Recepcionista) p);
		this.lista.add((Recepcionista)nova);
	}
	
	@Override
	public Pessoa getPessoa(String cpf) {
		for(Recepcionista r : lista) {
			if(r.getCpf().equals(cpf)) {
				return r;
			}
		}
		return null;
	}
	
	@Override
	public void remover(Pessoa p) {
		this.lista.remove((Recepcionista)p);
	}

	
	public static RepositorioRecepcionista iniciar() {
		Recepcionista novo = new Recepcionista("nome", "123", "999", LocalDate.now(), "321", null);
		RepositorioRecepcionista r = new RepositorioRecepcionista();
		r.add(novo);
		return r;
		
	}
}

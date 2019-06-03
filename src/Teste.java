import java.time.LocalDate;

import dados.RepositorioRecepcionista;
import fachada.FachadaRecepcionista;
import negocio.Recepcionista;


public class Teste {
    public static void main(String[] args) {
	
    	
    	
    	
        FachadaRecepcionista recep = new FachadaRecepcionista("123", "321");
        
        recep.cadastrarCliente("nome", "cpf"," fone", LocalDate.now(), "tipoLogradouro", "nomeLogradouro", "num", "bairro", "cep", "cidade", "estado", "pais");
        recep.cadastrarAnimal("cpf", "nomeAnimal", "raca", LocalDate.now());
        
    }
}

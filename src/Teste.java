import java.time.LocalDate;

import dados.RepositorioRecepcionista;
import fachada.FachadaRecepcionista;
import negocio.Recepcionista;


public class Teste {
    public static void main(String[] args) {
	
    	
    	
    	
        FachadaRecepcionista recep = new FachadaRecepcionista("123", "321");
        
        System.out.println(recep.getRecepcionista().toString());
    }
}

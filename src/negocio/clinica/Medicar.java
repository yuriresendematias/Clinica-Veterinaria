package negocio.clinica;

public class Medicar extends Procedimento{
	private Medicamento medicamento;
	private double dose;

	public Medicar(double valor, String tipo) {
		super(valor, tipo);
	}
	
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	public double getDose() {
		return dose;
	}
	
	public void setDose(double dose) {
		this.dose = dose;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( this.getTipo() == ((Procedimento)obj).getTipo() && 
				this.getProficional().equals(((Procedimento)obj).getProficional()) &&
				this.getAnimal().equals(((Procedimento)obj).getAnimal()) &&
				this.getData().equals(((Procedimento)obj).getData()) &&
				this.getMedicamento().equals(((Medicar)obj).getMedicamento()) ){
		
				return true;
		}
		
		return false;
	}
	
	
}

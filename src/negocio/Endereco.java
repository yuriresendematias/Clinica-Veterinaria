package negocio;

public class Endereco {
    private String tipo, nome, num, bairro, cep, cidade, estado, pais;

                                                            //getters and setters

    public Endereco(String tipo, String nome, String num, String bairro, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.nome = nome;
        this.num = num;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
    
    public String getCep() {
		return cep;
	}
    
    public void setCep(String cep) {
		this.cep = cep;
	}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    //sobreescrevendo o toString
    @Override
    public String toString(){
        return this.getTipo() +
                " " +this.getNome() +
                ", n� " + this.getNum() +
                "\nBairro: " +this.getBairro()+
                "\nCidade: " +this.getCidade()+
                "\nEstado: " +this.getEstado()+
                "\nPa�s: " +this.getPais();
    }
}

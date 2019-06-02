package negocio;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome, cpf, telefone;
    private LocalDate dataNascimento;
    private Endereco end;

    public Pessoa(String nome, String cpf, String telefone, LocalDate dataNascimento, Endereco end) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.end = end;
    }

    //getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object obj){
        return this.cpf.equals(((Pessoa)obj).getCpf());
    }

    @Override
    public String toString(){
        if(this.end == null) {
            return "Nome:" +this.getNome()+
                    "\nCPF:" + this.getCpf()+
                    "\nEndereço:" +
                    "\nData de Nascimento:" + this.getDataNascimento()+
                    "\nTelefone:"+ this.getTelefone();
        }
        return "Nome:" +this.getNome()+
                "\nCPF:" + this.getCpf()+
                "\nEndereço:" + this.end.toString() +
                "\nData de Nascimento:" + this.getDataNascimento()+
                "\nTelefone:"+ this.getTelefone();
    }
}

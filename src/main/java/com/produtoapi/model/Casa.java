package com.produtoapi.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int numero;

    @NotEmpty (message = "A rua não pode ser nula")
    private String endereco;
    private String bairro;
    private String cidade;

    public Casa (int numero, String endereco, String bairro, String cidade){

        this.numero = numero;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Casa(){

    }

    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getBairro(){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro=bairro;
    }

    public String getCidade(){
        return cidade;
    }
    public void setCidade (String cidade){
        this.cidade = cidade;
    }
}

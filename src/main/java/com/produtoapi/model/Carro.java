package com.produtoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "A marca do carro não pode ser nula")
    private String marca;
    @NotEmpty(message = "O nome do carro não pode ser nulo")
    private String nome;

    private double valor;
    @NotEmpty(message = "O nome do carro não pode ser nulo")
    private String placa;

    public Carro (String marca, String nome, double valor,String placa ){
        this.marca = marca;
        this.nome = nome;
        this.valor = valor;
        this.placa = placa;
    }
    public Carro(){
        //vazio
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double getValor(){
        return valor;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placa){
        this.placa=placa;
    }

}

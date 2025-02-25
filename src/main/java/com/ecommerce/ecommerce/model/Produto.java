package com.ecommerce.ecommerce.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Float preco;
    private Integer estoque;

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Float getPreco(){
        return preco;
    }

    public void setPreco(Float preco){
        this.preco = preco;
    }

    public Integer getEstoque(){
        return estoque;
    }

    public void setEstoque(Integer estoque){
        this.estoque = estoque;
    }

}

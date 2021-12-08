package com.cursomc.dto;

import com.cursomc.domain.Produto;

import java.io.Serializable;

public class ProdutoDTO  implements Serializable {
    private Integer id;
    private String name;
    private Double preco;

    public ProdutoDTO(){

    }
    public ProdutoDTO(Produto obj){
        id = obj.getId();
        name = obj.getName();
        preco = obj.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

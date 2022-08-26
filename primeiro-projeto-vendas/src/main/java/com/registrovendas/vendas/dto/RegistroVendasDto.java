package com.registrovendas.vendas.dto;

import com.registrovendas.vendas.model.RegistroVendasModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
//Essa classe irá verificar se os campos apontados não são vazios ou nulos.

public class RegistroVendasDto {

    @Autowired
    private RegistroVendasModel registroVendasModel;


    @NotBlank
    private Integer id;


    @NotBlank
    private String produtoComprado;
    @NotBlank
    private String codigoProduto;
    @NotBlank
    private String quantidadeProduto;
    @NotBlank
    private String valorProduto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getProdutoComprado() {
        return produtoComprado;
    }

    public void setProdutoComprado(String produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(String quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(String valorProduto) {
        this.valorProduto = valorProduto;
    }
}


package com.registrovendas.vendas.dto;

import javax.validation.constraints.NotBlank;
//Essa classe irá verificar se os campos apontados não são vazios ou nulos.

public class RegistroVendasDto {
    @NotBlank
    private String nomeCliente;
    @NotBlank
    private int celularCliente;
    @NotBlank
    private String produtoComprado;
    @NotBlank
    private int quantidadeProduto;
    @NotBlank
    private float valorProduto;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(int celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getProdutoComprado() {
        return produtoComprado;
    }

    public void setProdutoComprado(String produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }
}


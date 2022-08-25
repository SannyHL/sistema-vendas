package com.registrovendas.vendas.dto;

import com.registrovendas.vendas.model.RegistroVendasModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
//Essa classe irá verificar se os campos apontados não são vazios ou nulos.

public class RegistroVendasDto {

    @Autowired
    private RegistroVendasModel registroVendasModel;

    @NotBlank
    private String nomeCliente;
    private String telefoneFixoCliente;
    private String whatsappCliente;
    private String emailCliente;

    @NotBlank
    private String celularCliente;
    @NotBlank
    private String produtoComprado;
    @NotBlank
    private String codigoProduto;
    @NotBlank
    private String quantidadeProduto;
    @NotBlank
    private String valorProduto;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneFixoCliente() {
        return telefoneFixoCliente;
    }

    public void setTelefoneFixoCliente(String telefoneFixoCliente) {
        this.telefoneFixoCliente = telefoneFixoCliente;
    }

    public String getWhatsappCliente() {
        return whatsappCliente;
    }

    public void setWhatsappCliente(String whatsappCliente) {
        this.whatsappCliente = whatsappCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
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


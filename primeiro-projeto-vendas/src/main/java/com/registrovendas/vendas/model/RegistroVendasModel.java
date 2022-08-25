package com.registrovendas.vendas.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity //transforma a classe em entidade, ou seja cada a classe corresponderá a uma tabela.
@Table(name = "CADASTRO_VENDAS")
public class RegistroVendasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //Adição do id da classe, do gerador automatico de id e o tipo de identificador, no caso UUID:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //Adição das colunas na tabela:
    // Colunas: Nome cliente, telefone fixo, celular, whatsapp idade, email, produto comprado, quantidade do produto, valor produto.

    @Column(nullable = false, unique = true, length = 100)
    private String nomeCliente;
    @Column(nullable = true, unique = true, length = 15)
    private String telefoneFixoCliente;
    @Column(nullable = false, unique = false, length = 15)
    private String celularCliente;
    @Column(nullable = true, unique = true, length = 15)
    private String whatsappCliente;
    @Column(nullable = true, unique = false, length = 50)
    private String emailCliente;
    @Column(nullable = false, unique = true, length = 50)
    private String produtoComprado;
    @Column(nullable = false, unique = true, length = 50)
    private String codigoProduto;
    @Column(nullable = false, unique = true, length = 5)
    private String quantidadeProduto;
    @Column(nullable = false, unique = true, length = 7)
    private String valorProduto;
    @Column(nullable = false)
    private LocalDateTime dataCompra;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
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

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }
}



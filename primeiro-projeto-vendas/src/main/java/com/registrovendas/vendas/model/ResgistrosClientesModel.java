package com.registrovendas.vendas.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity //transforma a classe em entidade, ou seja cada a classe corresponderá a uma tabela.
@Table(name = "CADASTRO_CLIENTE")
public class ResgistrosClientesModel implements Serializable {
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
    private int telefoneFixoCliente;
    @Column(nullable = false, unique = false, length = 15)
    private int celularCliente;
    @Column(nullable = true, unique = true, length = 15)
    private int whatsappCliente;
    @Column(nullable = true, unique = false, length = 50)
    private String emailCliente;
    @Column(nullable = false, unique = true, length = 50)
    private String produtoComprado;
    @Column(nullable = false, unique = true, length = 5)
    private int quantidadeProduto;
    @Column(nullable = false, unique = true, length = 7)
    private float valorProduto;
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

    public int getTelefoneFixoCliente() {
        return telefoneFixoCliente;
    }

    public void setTelefoneFixoCliente(int telefoneFixoCliente) {
        this.telefoneFixoCliente = telefoneFixoCliente;
    }

    public int getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(int celularCliente) {
        this.celularCliente = celularCliente;
    }

    public int getWhatsappCliente() {
        return whatsappCliente;
    }

    public void setWhatsappCliente(int whatsappCliente) {
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

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }
}

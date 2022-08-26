package com.registrovendas.vendas.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //transforma a classe em entidade, ou seja cada a classe corresponderá a uma tabela.
@Table(name = "CADASTRO_VENDAS")
public class RegistroVendasModel {


    //Adição do id da classe, do gerador automatico de id e o tipo de identificador, no caso UUID:
    @Id
    private String id;

    //Adição das colunas na tabela:
    // Colunas: Nome cliente, telefone fixo, celular, whatsapp idade, email, produto comprado, quantidade do produto, valor produto.

    @Column(nullable = false, length = 50)
    private String produtoComprado;
    @Column(nullable = false, length = 50)
    private String codigoProduto;
    @Column(nullable = false, length = 5)
    private String quantidadeProduto;
    @Column(nullable = false, length = 7)
    private String valorProduto;
    @Column(nullable = false)
    private LocalDateTime dataCompra;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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


    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    @ManyToOne
    @JoinColumn(name = "registroClientesModel_id")
    private RegistroClientesModel registroClientesModel;


}



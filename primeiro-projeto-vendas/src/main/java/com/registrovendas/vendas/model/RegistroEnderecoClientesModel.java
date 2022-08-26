package com.registrovendas.vendas.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REGISTROS_ENDERECO_CLIENTES")
public class RegistroEnderecoClientesModel {


    @Id
    private String id;

    @Column(length = 50)
    private String rua;
    @Column(length = 5)
    private String numero;
    @Column(length = 50)
    private String bairro;
    @Column(length = 50)
    private String cidade;
    @Column(length = 50)
    private String estado;
    @Column(length = 50)
    private  String pais;
    @Column(nullable = false)
    private LocalDateTime dataCadastroEndereco;


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDataCadastroEndereco() {
        return dataCadastroEndereco;
    }

    public void setDataCadastroEndereco(LocalDateTime dataCadastroEndereco) {
        this.dataCadastroEndereco = dataCadastroEndereco;
    }


    @OneToOne
    @JoinColumn(name = "registroClientesModel_id")
    private RegistroClientesModel registroClientesModel;


}

package com.registrovendas.vendas.model;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "REGISTROS_CLIENTES")
public class RegistroClientesModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nomeCliente;
    @Column(length = 15)
    private String telefoneFixoCliente;
    @Column(nullable = false, unique = true, length = 15)
    private String celularCliente;
    @Column(unique = true, length = 15)
    private String whatsappCliente;
    @Column(unique = true, length = 50)
    private String emailCliente;
    @Column(unique = true, length = 15)
    private String cpfCliente;
    @Column(nullable = false)
    private LocalDateTime dataCadastroCliente;


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

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public LocalDateTime getDataCadastroCliente() {
        return dataCadastroCliente;
    }

    public void setDataCadastroCliente(LocalDateTime dataCadastroCliente) {
        this.dataCadastroCliente = dataCadastroCliente;
    }

    @OneToOne(mappedBy = "registroClientesModel")
    private RegistroEnderecoClientesModel registroEnderecoClientesModel;

    @OneToMany(mappedBy = "registroClientesModel")
    private List<RegistroVendasModel> registroVendasModel;

}

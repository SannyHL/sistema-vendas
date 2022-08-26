package com.registrovendas.vendas.dto;
import javax.validation.constraints.NotBlank;

public class RegistroClientesDto {


    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String celularCliente;
    @NotBlank
    private String cpfCliente;
    private String telefoneFixoCliente;
    private String whatsappCliente;
    private String emailCliente;


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
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

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}

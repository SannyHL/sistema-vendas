package com.registrovendas.vendas.services;

import com.registrovendas.vendas.repository.RegistroVendasRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroVendasService {
    // criação de um ponto de injeção do repository no service:

    final RegistroVendasRepository registroVendasRepository;

    public RegistroVendasService(RegistroVendasRepository registroVendasRepository) {
        this.registroVendasRepository = registroVendasRepository;
    }
}

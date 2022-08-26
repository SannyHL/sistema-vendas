package com.registrovendas.vendas.services;

import com.registrovendas.vendas.model.RegistroVendasModel;
import com.registrovendas.vendas.repository.RegistroVendasRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrosVendasService {
    // criação de um ponto de injeção do repository no service:

    final RegistroVendasRepository registroVendasRepository;

    public RegistrosVendasService(RegistroVendasRepository registroVendasRepository) {
        this.registroVendasRepository = registroVendasRepository;
    }

    @Transactional
    public RegistroVendasModel create(RegistroVendasModel registroVendasModel) {
        return registroVendasRepository.save(registroVendasModel);
    }

}

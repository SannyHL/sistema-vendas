package com.registrovendas.vendas.services;

import com.registrovendas.vendas.dto.RegistroVendasDto;
import com.registrovendas.vendas.model.RegistroVendasModel;
import com.registrovendas.vendas.repository.RegistroVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class RegistrosVendasService {
    // criação de um ponto de injeção do repository no service:

    @Autowired
    private RegistroVendasRepository registroVendasRepository;

    @Transactional
    public RegistroVendasModel create(RegistroVendasModel registroVendasModel) {
        return registroVendasRepository.save(registroVendasModel);
    }

    @Transactional


    public List<RegistroVendasModel> findAll() {
        return registroVendasRepository.findAll();
    }

    public Optional<RegistroVendasModel> findById(String id) {
        return registroVendasRepository.findById(id);
    }

    public void delete(RegistroVendasModel registroVendasModel) {
        registroVendasRepository.delete(registroVendasModel);
    }

}

package com.registrovendas.vendas.services;


import com.registrovendas.vendas.model.RegistroClientesModel;
import com.registrovendas.vendas.repository.RegistroClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistroClientesService {
    @Autowired
    private RegistroClientesRepository registroClientesRepository;

    @Transactional
    public RegistroClientesModel created(RegistroClientesModel registroClientesModel){
        return registroClientesRepository.save(registroClientesModel);
    }


    public List<RegistroClientesModel> findAll() {
        return registroClientesRepository.findAll();
    }

    public Optional<RegistroClientesModel> findById(UUID id) {
        return registroClientesRepository.findById(id);
    }

    public void delete(RegistroClientesModel registroClientesModel) {
        registroClientesRepository.delete(registroClientesModel);
    }


}

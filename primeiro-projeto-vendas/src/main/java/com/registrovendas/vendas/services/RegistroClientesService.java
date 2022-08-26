package com.registrovendas.vendas.services;


import com.registrovendas.vendas.model.RegistroClientesModel;
import com.registrovendas.vendas.repository.RegistroClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistroClientesService {
    @Autowired
    private RegistroClientesRepository registroClientesRepository;


    public RegistroClientesService(RegistroClientesRepository registroClientesRepository) {
        this.registroClientesRepository = registroClientesRepository;
    }

    @Transactional
    public RegistroClientesModel created(RegistroClientesModel registroClientesModel){
        return registroClientesRepository.save(registroClientesModel);
    }


}

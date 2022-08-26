package com.registrovendas.vendas.services;


import com.registrovendas.vendas.model.RegistroClientesModel;
import com.registrovendas.vendas.repository.ResgistroClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistroClientesService {
    @Autowired
    private ResgistroClientesRepository resgistroClientesRepository;


    public RegistroClientesService(ResgistroClientesRepository resgistroClientesRepository) {
        this.resgistroClientesRepository = resgistroClientesRepository;
    }

    @Transactional
    public RegistroClientesModel created(RegistroClientesModel registroClientesModel){
        return resgistroClientesRepository.save(registroClientesModel);
    }


}

package com.registrovendas.vendas.services;
import com.registrovendas.vendas.model.RegistroEnderecoClientesModel;
import com.registrovendas.vendas.repository.RegistroEnderecoClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class RegistroEnderecoClientesService {

    @Autowired
    private RegistroEnderecoClientesRepository registroEnderecoClientesRepository;

    public RegistroEnderecoClientesService(RegistroEnderecoClientesRepository registroEnderecoClientesRepository) {
        this.registroEnderecoClientesRepository = registroEnderecoClientesRepository;
    }


    @Transactional
    public RegistroEnderecoClientesModel create(RegistroEnderecoClientesModel registroEnderecoClientesModel){
        return registroEnderecoClientesRepository.save(registroEnderecoClientesModel);
    }

}

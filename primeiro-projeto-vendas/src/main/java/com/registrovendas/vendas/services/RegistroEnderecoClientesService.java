package com.registrovendas.vendas.services;
import com.registrovendas.vendas.model.RegistroEnderecoClientesModel;
import com.registrovendas.vendas.repository.RegistroEnderecoClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public List<RegistroEnderecoClientesModel> findAll() {
        return registroEnderecoClientesRepository.findAll();
    }

    public Optional<RegistroEnderecoClientesModel> findById(String id) {
        return registroEnderecoClientesRepository.findById(id);
    }

    public void delete(RegistroEnderecoClientesModel registroEnderecoClientesModel) {
        registroEnderecoClientesRepository.delete(registroEnderecoClientesModel);
    }

}

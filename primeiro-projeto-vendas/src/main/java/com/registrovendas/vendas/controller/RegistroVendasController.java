package com.registrovendas.vendas.controller;

import com.registrovendas.vendas.model.RegistroVendasModel;
import com.registrovendas.vendas.repository.RegistroVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class RegistroVendasController {

    @Autowired
    RegistroVendasRepository registroVendasRepository;
    //Pegar uma lista de todas as vendas:
    @GetMapping("/vendas")
    public ResponseEntity<List<RegistroVendasModel>> getAllRegistro(){
        return new ResponseEntity<List<RegistroVendasModel>>(registroVendasRepository.findAll(), HttpStatus.OK);
    }
    //Pegar o registro de uma venda via id:
    @GetMapping("/vendas/{id}")
    public ResponseEntity<RegistroVendasModel> getOneRegistro(@PathVariable(value = "id") UUID id){
        Optional<RegistroVendasModel> registroVendasModelOptional = registroVendasRepository.findById(id);
        if(registroVendasModelOptional.isPresent()){
            return new ResponseEntity<RegistroVendasModel>(registroVendasModelOptional.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<RegistroVendasModel>(HttpStatus.FOUND);
        }

    }


}

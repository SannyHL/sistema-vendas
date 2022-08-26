package com.registrovendas.vendas.controller;

import com.registrovendas.vendas.dto.RegistroClientesDto;
import com.registrovendas.vendas.model.RegistroClientesModel;
import com.registrovendas.vendas.repository.RegistroClientesRepository;
import com.registrovendas.vendas.repository.RegistroEnderecoClientesRepository;
import com.registrovendas.vendas.services.RegistroClientesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@ResponseBody
@RequestMapping("/clientes")
public class RegistroClientesController {

    @Autowired
    private RegistroClientesRepository registroClientesRepository;

    @Autowired
    private RegistroClientesService registroClientesService;

    public RegistroClientesController(RegistroEnderecoClientesRepository registroEnderecoClientesRepository, RegistroClientesRepository registroClientesRepository, RegistroClientesService registroClientesService) {
        this.registroClientesRepository = registroClientesRepository;
        this.registroClientesService = registroClientesService;
    }

    @PostMapping("/")
    public ResponseEntity<RegistroClientesModel> saveRegistroClientesModel(@RequestBody @Valid RegistroClientesDto registroClientesDto){
        var registroClientesModel = new RegistroClientesModel();
        BeanUtils.copyProperties(registroClientesDto, registroClientesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroClientesService.created(registroClientesModel));
    }

    @GetMapping("/")
    public ResponseEntity<List<RegistroClientesModel>> getAll(){
        return new ResponseEntity<List<RegistroClientesModel>>(registroClientesRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroClientesModel> getId(@PathVariable(value = "id")UUID id){
        Optional<RegistroClientesModel> registroClientesModelOptional = registroClientesRepository.findById(id);
        if (registroClientesModelOptional.isPresent()){
            return new ResponseEntity<RegistroClientesModel>(registroClientesModelOptional.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<RegistroClientesModel>(HttpStatus.FOUND);
        }
    }
}

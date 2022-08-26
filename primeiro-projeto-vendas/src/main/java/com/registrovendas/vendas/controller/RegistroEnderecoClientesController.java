package com.registrovendas.vendas.controller;

import com.registrovendas.vendas.dto.RegistroEnderecoClientesDto;
import com.registrovendas.vendas.model.RegistroEnderecoClientesModel;
import com.registrovendas.vendas.repository.RegistroEnderecoClientesRepository;
import com.registrovendas.vendas.services.RegistroEnderecoClientesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping("/endereco_cliente")
public class RegistroEnderecoClientesController {

    @Autowired
    private RegistroEnderecoClientesRepository registroEnderecoClientesRepository;

    @Autowired
    private RegistroEnderecoClientesService registroEnderecoClientesService;

    public RegistroEnderecoClientesController(RegistroEnderecoClientesRepository registroEnderecoClientesRepository, RegistroEnderecoClientesService registroEnderecoClientesService) {
        this.registroEnderecoClientesRepository = registroEnderecoClientesRepository;
        this.registroEnderecoClientesService = registroEnderecoClientesService;
    }

    @PostMapping("/")
    public ResponseEntity<RegistroEnderecoClientesModel> saveEnderecos(@RequestBody @Valid RegistroEnderecoClientesDto registroEnderecoClientesDto){
        var registroEnderecoClientesModel = new RegistroEnderecoClientesModel();
        BeanUtils.copyProperties(registroEnderecoClientesDto, registroEnderecoClientesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroEnderecoClientesService.create(registroEnderecoClientesModel));
    }

    @GetMapping("/")
    public ResponseEntity<List<RegistroEnderecoClientesModel>> getAllEnderecos(){
        return new ResponseEntity<List<RegistroEnderecoClientesModel>>(registroEnderecoClientesRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroEnderecoClientesModel> getId(@PathVariable(value = "id")String id){
        Optional<RegistroEnderecoClientesModel> registroEnderecoClientesModelOptional = registroEnderecoClientesRepository.findById(id);
        if(registroEnderecoClientesModelOptional.isPresent()){
            return new ResponseEntity<RegistroEnderecoClientesModel>(registroEnderecoClientesModelOptional.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<RegistroEnderecoClientesModel>(HttpStatus.FOUND);
        }
    }

}

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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@ResponseBody
@RequestMapping("/clientes")
public class RegistroClientesController {


    @Autowired
    private RegistroClientesService registroClientesService;

    public RegistroClientesController(RegistroEnderecoClientesRepository registroEnderecoClientesRepository, RegistroClientesRepository registroClientesRepository, RegistroClientesService registroClientesService) {
        this.registroClientesService = registroClientesService;
    }

    @PostMapping("/")
    public ResponseEntity<RegistroClientesModel> saveRegistroClientesModel(@RequestBody @Valid RegistroClientesDto registroClientesDto){
        var registroClientesModel = new RegistroClientesModel();
        BeanUtils.copyProperties(registroClientesDto, registroClientesModel);
        registroClientesModel.setDataCadastroCliente(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(registroClientesService.created(registroClientesModel));
    }

    @GetMapping("/")
    public ResponseEntity<List<RegistroClientesModel>> getAll(){
        return new ResponseEntity<>(registroClientesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroClientesModel> getId(@PathVariable(value = "id")UUID id){
        Optional<RegistroClientesModel> registroClientesModelOptional = registroClientesService.findById(id);
        if (registroClientesModelOptional.isPresent()){
            return new ResponseEntity<>(registroClientesModelOptional.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroClientesModel> deleteCliente(@PathVariable(value = "id") UUID id){
        Optional<RegistroClientesModel> registroClientesModelOptional = registroClientesService.findById(id);
        if(registroClientesModelOptional.isPresent()){
            registroClientesService.delete(registroClientesModelOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<RegistroClientesModel> updateCliente(@PathVariable(value = "id") UUID id, @RequestBody @Valid RegistroClientesDto registroClientesDto){
        Optional<RegistroClientesModel> registroClientesModelOptional = registroClientesService.findById(id);
        if (registroClientesModelOptional.isPresent()){
            var registroClientesModel = new RegistroClientesModel();
            BeanUtils.copyProperties(registroClientesDto, registroClientesModel);
            registroClientesModel.setId(registroClientesModelOptional.get().getId());
            registroClientesModel.setDataCadastroCliente(registroClientesModelOptional.get().getDataCadastroCliente());
            return new ResponseEntity<>(registroClientesService.created(registroClientesModel), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

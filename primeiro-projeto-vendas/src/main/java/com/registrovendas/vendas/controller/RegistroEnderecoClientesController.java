package com.registrovendas.vendas.controller;

import com.registrovendas.vendas.dto.RegistroEnderecoClientesDto;
import com.registrovendas.vendas.model.RegistroEnderecoClientesModel;
import com.registrovendas.vendas.services.RegistroEnderecoClientesService;
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

@RestController
@ResponseBody
@RequestMapping("/endereco_cliente")
public class RegistroEnderecoClientesController {

    @Autowired
    private RegistroEnderecoClientesService registroEnderecoClientesService;

    @PostMapping("/")
    public ResponseEntity<RegistroEnderecoClientesModel> saveEnderecos(@RequestBody @Valid RegistroEnderecoClientesDto registroEnderecoClientesDto){
        var registroEnderecoClientesModel = new RegistroEnderecoClientesModel();
        BeanUtils.copyProperties(registroEnderecoClientesDto, registroEnderecoClientesModel);
        registroEnderecoClientesModel.setDataCadastroEndereco(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(registroEnderecoClientesService.create(registroEnderecoClientesModel));
    }

    @GetMapping("/")
    public ResponseEntity<List<RegistroEnderecoClientesModel>> getAllEnderecos(){
        return new ResponseEntity<>(registroEnderecoClientesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroEnderecoClientesModel> getId(@PathVariable(value = "id")String id){
        Optional<RegistroEnderecoClientesModel> registroEnderecoClientesModelOptional = registroEnderecoClientesService.findById(id);
        if(registroEnderecoClientesModelOptional.isPresent()){
            return new ResponseEntity<>(registroEnderecoClientesModelOptional.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroEnderecoClientesModel> deleteEndereco(@PathVariable(value = "id") String id){
        Optional<RegistroEnderecoClientesModel> registroEnderecoClientesModelOptional = registroEnderecoClientesService.findById(id);
        if(registroEnderecoClientesModelOptional.isPresent()){
            registroEnderecoClientesService.delete(registroEnderecoClientesModelOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<RegistroEnderecoClientesModel> updateEndereco(@PathVariable(value = "id") String id, @RequestBody @Valid RegistroEnderecoClientesDto registroEnderecoClientesDto){
        Optional<RegistroEnderecoClientesModel> registroEnderecoClientesModelOptional = registroEnderecoClientesService.findById(id);
        if (registroEnderecoClientesModelOptional.isPresent()){
            var registroEnderecoClientesModel = new RegistroEnderecoClientesModel();
            BeanUtils.copyProperties(registroEnderecoClientesDto, registroEnderecoClientesModel);
            registroEnderecoClientesModel.setDataCadastroEndereco(registroEnderecoClientesModelOptional.get().getDataCadastroEndereco());
            return new ResponseEntity<>(registroEnderecoClientesService.create(registroEnderecoClientesModel), HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

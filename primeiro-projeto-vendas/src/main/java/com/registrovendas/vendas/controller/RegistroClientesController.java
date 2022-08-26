package com.registrovendas.vendas.controller;

import com.registrovendas.vendas.dto.RegistroClientesDto;
import com.registrovendas.vendas.model.RegistroClientesModel;
import com.registrovendas.vendas.services.RegistroClientesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ResponseBody
@RequestMapping("/clientes")
public class RegistroClientesController {

    @Autowired
    private RegistroClientesService registroClientesService;

    public RegistroClientesController(RegistroClientesService registroClientesService) {
        this.registroClientesService = registroClientesService;
    }

    @PostMapping("/")
    public ResponseEntity<RegistroClientesModel> saveRegistroClientesModel(@RequestBody @Valid RegistroClientesDto registroClientesDto){
        var registroClientesModel = new RegistroClientesModel();
        BeanUtils.copyProperties(registroClientesDto, registroClientesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroClientesService.created(registroClientesModel));
    }
}

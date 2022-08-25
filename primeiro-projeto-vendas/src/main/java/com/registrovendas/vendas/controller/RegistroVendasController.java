package com.registrovendas.vendas.controller;

import com.registrovendas.vendas.dto.RegistroVendasDto;
import com.registrovendas.vendas.model.RegistroVendasModel;
import com.registrovendas.vendas.services.RegistroVendasService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@ResponseBody
@RequestMapping("/vendas")
public class RegistroVendasController {

    @Autowired
    private RegistroVendasService registroVendasService;

    public RegistroVendasController(RegistroVendasService registroVendasService) {
        this.registroVendasService = registroVendasService;
    }

    @PostMapping("/")
    public ResponseEntity<RegistroVendasModel> saveRegistroVendasModel(@RequestBody @Valid RegistroVendasDto registroVendasDto){
        var registroVendasModel = new RegistroVendasModel();
        BeanUtils.copyProperties(registroVendasDto, registroVendasModel);
        registroVendasModel.setDataCompra(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(registroVendasService.create(registroVendasModel));
    }


}

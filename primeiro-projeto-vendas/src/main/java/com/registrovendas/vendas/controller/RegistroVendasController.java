package com.registrovendas.vendas.controller;

import com.registrovendas.vendas.dto.RegistroVendasDto;
import com.registrovendas.vendas.model.RegistroVendasModel;
import com.registrovendas.vendas.services.RegistrosVendasService;
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
@RequestMapping("/venda")
public class RegistroVendasController {


    @Autowired
    private RegistrosVendasService registrosVendasService;

    @PostMapping("/")
    public ResponseEntity<RegistroVendasModel> saveRegistroVendasModel(@RequestBody @Valid RegistroVendasDto registroVendasDto){
        var registroVendasModel = new RegistroVendasModel();
        BeanUtils.copyProperties(registroVendasDto, registroVendasModel);
        registroVendasModel.setDataCompra(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(registrosVendasService.create(registroVendasModel));
    }

    @GetMapping("/")
    public ResponseEntity<List<RegistroVendasModel>> getAll(){
        return new ResponseEntity<>(registrosVendasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroVendasModel> getId(@PathVariable(value = "id") String id){
        Optional<RegistroVendasModel> registroVendasModelOptional = registrosVendasService.findById(id);
        if(registroVendasModelOptional.isPresent()){
            return new ResponseEntity<>(registroVendasModelOptional.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroVendasModel> deleteVenda(@PathVariable(value = "id") String id){
        Optional<RegistroVendasModel> registroVendasModelOptional = registrosVendasService.findById(id);
        if (registroVendasModelOptional.isPresent()){
            registrosVendasService.delete(registroVendasModelOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroVendasModel> updateVenda(@PathVariable(value = "id") String id, @RequestBody @Valid RegistroVendasDto registroVendasDto){
        Optional<RegistroVendasModel> registroVendasModelOptional = registrosVendasService.findById(id);
        if(registroVendasModelOptional.isPresent()){
            var registroVendasModel = new RegistroVendasModel();
            BeanUtils.copyProperties(registroVendasDto, registroVendasModel);
            registroVendasModel.setDataCompra(registroVendasModelOptional.get().getDataCompra());
            return new  ResponseEntity<>(registrosVendasService.create(registroVendasModel), HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

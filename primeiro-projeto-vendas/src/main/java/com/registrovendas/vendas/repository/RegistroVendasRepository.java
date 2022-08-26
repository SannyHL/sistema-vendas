package com.registrovendas.vendas.repository;

import com.registrovendas.vendas.model.RegistroVendasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Essa Inteface está estendendo o JpaRepository, pois ele trás muitas facilidades de simplificação dos metodos, como delete.
//O RegistroVendasRepository irá extender o JpaRepository<tipo de dominio que o repositorio gerencia, o tipo de identificador da entidade que o repositorio gerencia>
//No caso como o repositorio irá gerenciar o Model, esse está sendo informardo, e o id dele também.
@Repository
public interface RegistroVendasRepository extends JpaRepository<RegistroVendasModel, String> {

}

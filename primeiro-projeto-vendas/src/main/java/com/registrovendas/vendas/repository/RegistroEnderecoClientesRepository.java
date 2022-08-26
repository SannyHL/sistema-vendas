package com.registrovendas.vendas.repository;

import com.registrovendas.vendas.model.RegistroEnderecoClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistroEnderecoClientesRepository extends JpaRepository<RegistroEnderecoClientesModel, String> {
}

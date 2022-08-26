package com.registrovendas.vendas.repository;

import com.registrovendas.vendas.model.RegistroClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResgistroClientesRepository extends JpaRepository<RegistroClientesModel, UUID> {
}

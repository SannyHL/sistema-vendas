package com.registrovendas.vendas.repository;

import com.registrovendas.vendas.model.ResgistrosClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistroVendasRepository extends JpaRepository<ResgistrosClientesModel, UUID> {
}

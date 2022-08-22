package com.registrovendas.vendas.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity //transforma a classe em entidade, ou seja cada a classe corresponderá a uma tabela.
@Table(name = "REGISTROS_VENDAS")
public class ResgistrosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //Adição do id da classe, do gerador automatico de id e o tipo de identificador, no caso UUID:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //Adição das colunas na tabela:
    // Colunas: Nome cliente, telefone, idade, email, produto comprado, quantidade do produto, valor produto.

}

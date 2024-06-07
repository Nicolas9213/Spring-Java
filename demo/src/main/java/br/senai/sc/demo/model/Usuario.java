package br.senai.sc.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false)
    private String nome;
    @Column (unique = true)
    private String email;
    @Column (name = "password")
    private String senha;
    @Column (length = 50)
    private String nomePet;
    @Column(unique = true, precision = 11, updatable = false)
    private Long cpf;
}

package br.senai.sc.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id // Indica a primary key da identidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz com que o banco gere um valor aleatório
    private Integer id;
    @Column (nullable = false)
    @Getter
    private String nome;
    @Column (unique = true)
    private String email;
    @ToString.Exclude
    @Column (name = "password")
    private String senha;
    @Column (length = 50)
    private String nomePet;
    @Column(unique = true, precision = 11, updatable = false)
    private Long cpf;
}

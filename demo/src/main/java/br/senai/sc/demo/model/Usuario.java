package br.senai.sc.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id // Indica a primary key da identidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz com que o banco gere um valor aleatório
    private Integer id;
    @Column (nullable = false)
    private String nome;
    @Column (unique = true)
    private String email;
    @ToString.Exclude
    @JsonIgnore
    @Column (name = "password")
    private String senha;
    @Column (length = 50)
    private String nomePet;
    @Column(unique = true, precision = 11, updatable = false)
    private Long cpf;
}

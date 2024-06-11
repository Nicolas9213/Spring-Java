package br.senai.sc.demo.controller;

import br.senai.sc.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController //Notação que determina o estereótipo dessa classe

@RequestMapping("/usuario")

public class UsuarioController {

//    @GetMapping
//    public String endpointGet() {
//        return "Get!";
//    } //São as interfaces de comunicação com o ambiente externo
//    //O Retorno do Get pode ser um objeto único(Recebe o id e busca um elemento no Banco de Dados) ou reber um
//    //status e retornar uma lista

    @PostMapping
    public String cadastroUsuario(@RequestBody Usuario usuario) { //Body é a informação bruta que está sendo passada
        // (Get e Delete não usam)
        return "Olá " + usuario.getNome() + ".\n" + usuario;
        //Post recebe as informações e salva em algum lugar
    }

//    @PutMapping("/{idPut}")
//    public String endpointPut(@PathVariable("idPut") int id, @RequestBody String nome) { // Faz a alteração ou ajuste de uma
//        // quantidade maior de informações
//        return "Olá " + nome + "de ID = " + id + ".";
//    }
//
//    @PatchMapping
//    public String endpointPatch(@RequestParam int id, @RequestBody String nome) { //Alteração ou atualização de um ou dois atrtibutos
//        return "Olá " + nome + " de ID = " + id + ".";
//    }
//
//    @DeleteMapping("/{id}")
//    public String endpointDelete(@PathVariable int id) { //Pode deletar ou desabilitar alguma informação do banco
//        return "Objeto de ID " + id + " deletado.";
//    }
//    //Get, Put, Patch, Post, Delete são métodos HTTP
}

package org.example.resources;


import org.example.entities.Endereco;
import org.example.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    // Busca todos os usuários
    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> endereco = enderecoService.findAll();
        return ResponseEntity.ok(endereco);

    }

    // Busca por id
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.findById(id);
        return endereco.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    //Insere
    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco) {
        Endereco created = enderecoService.insert(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Atualiza
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Endereco endereco) {
        if (enderecoService.update(id, endereco)) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

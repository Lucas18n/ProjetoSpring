package org.example.resources;

import org.example.entities.Contato;
import org.example.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class ContatoResource {

    @Autowired
    private ContatoService contatoService;

    // Busca todos os usuários
    @GetMapping
    public ResponseEntity<List<Contato>> findAll() {
        List<Contato> contato = contatoService.findAll();
        return ResponseEntity.ok(contato);

    }

    // Busca por id
    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        Optional<Contato> contato = contatoService.findById(id);
        return contato.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    //Insere
    @PostMapping
    public ResponseEntity<Contato> insert(@RequestBody Contato contato) {
        Contato created = contatoService.insert(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Atualiza
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Contato contato) {
        if (contatoService.update(id, contato)) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

package org.example.resources;


import org.example.entities.FormaPagamento;
import org.example.services.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/formapagamentos")
public class FormaPagamentoResource {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    // Busca todos
    @GetMapping
    public ResponseEntity<List<FormaPagamento>> findAll() {
        List<FormaPagamento> formaPagamento = formaPagamentoService.findAll();
        return ResponseEntity.ok(formaPagamento);

    }

    // Busca por id
    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> findById(@PathVariable Long id) {
        Optional<FormaPagamento> formaPagamento = formaPagamentoService.findById(id);
        return formaPagamento.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    //Insere
    @PostMapping
    public ResponseEntity<FormaPagamento> insert(@RequestBody FormaPagamento formaPagamento) {
        FormaPagamento created = formaPagamentoService.insert(formaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        formaPagamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Atualiza
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody FormaPagamento formaPagamento) {
        if (formaPagamentoService.update(id, formaPagamento)) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

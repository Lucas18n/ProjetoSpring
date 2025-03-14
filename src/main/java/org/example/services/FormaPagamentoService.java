package org.example.services;

import org.example.entities.FormaPagamento;
import org.example.repositories.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository repository;

    //Listar todos
    public List<FormaPagamento> findAll() {
        return repository.findAll();
    }

    //Listar por id
    public Optional<FormaPagamento> findById(Long id) {
        return repository.findById(id);
    }

    //Inserir
    public FormaPagamento insert(FormaPagamento formaPagamento) {
        return repository.save(formaPagamento);
    }

    //Deletar
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //Atualizar
    public boolean update(Long id, FormaPagamento formaPagamento) {
        Optional<FormaPagamento> optional = repository.findById(id);
        if (optional.isPresent()) {
            FormaPagamento formaPagamento1 = optional.get();
            formaPagamento1.setDescricao(formaPagamento.getDescricao());
            formaPagamento1.setTipo(formaPagamento.getTipo());
            repository.save(formaPagamento1);
            return true;
        }
        return false;
    }
}

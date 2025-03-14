package org.example.services;

import org.example.entities.Contato;
import org.example.entities.Usuario;
import org.example.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    //Listar todos
    public List<Contato> findAll() {
        return repository.findAll();
    }

    //Listar por id
    public Optional<Contato> findById(Long id) {
        return repository.findById(id);
    }

    //Inserir
    public Contato insert(Contato contato) {
        return repository.save(contato);
    }

    //Deletar
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //Atualizar
    public boolean update(Long id, Contato contato) {
        Optional<Contato> optional = repository.findById(id);
        if (optional.isPresent()) {
            Contato contato1 = optional.get();
            contato1.setTelefone(contato.getTelefone());
            contato1.setCelular(contato.getCelular());
            contato1.setEmail(contato.getEmail());
            repository.save(contato1);
            return true;
        }
        return false;
    }
}

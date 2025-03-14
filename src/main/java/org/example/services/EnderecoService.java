package org.example.services;


import org.example.entities.Endereco;
import org.example.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    //Listar todos
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    //Listar por id
    public Optional<Endereco> findById(Long id) {
        return repository.findById(id);
    }

    //Inserir
    public Endereco insert(Endereco endereco) {
        return repository.save(endereco);
    }

    //Deletar
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //Atualizar
    public boolean update(Long id, Endereco endereco) {
        Optional<Endereco> optional = repository.findById(id);
        if (optional.isPresent()) {
            Endereco endereco1 = optional.get();
            endereco1.setLogradouro(endereco.getLogradouro());
            endereco1.setNumero(endereco.getNumero());
            endereco1.setComplemento(endereco.getComplemento());
            endereco1.setBairro(endereco.getBairro());
            endereco1.setCidade(endereco.getCidade());
            endereco1.setEstado(endereco.getEstado());
            endereco1.setCep(endereco.getCep());
            repository.save(endereco1);
            return true;
        }
        return false;
    }
}

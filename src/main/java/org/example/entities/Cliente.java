package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Cliente implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(length = 55, name = "NOME", nullable = false)
    private String nome;

    @Column(length = 25, name = "CPFCNPJ", nullable = false)
    private String CpfCnpj;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento ;

    @Column(length = 20, name = "FORMA_PAGAMENTO", nullable = false)
    private String formaPagamento ;


    //Construtor vazio
    public Cliente() {
    }


    //Construtor com argumentos
    public Cliente(Long id, String nome, String cpfCnpj, LocalDate dataNascimento, String formaPagamento) {
        this.id = id;
        this.nome = nome;
        CpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.formaPagamento = formaPagamento;
    }


    //Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return CpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        CpfCnpj = cpfCnpj;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}

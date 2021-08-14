package crudspring.wrock.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    private Integer idade;

    private String sexo;

    private String telefone;

    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = true)
    private Turma turma;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Date getNascimento() {
        return nascimento;
    }


    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }


    public Integer getIdade() {
        return idade;
    }


    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public String getSexo() {
        return sexo;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeTurma() {
        return turma.getNome();
    }

    public Long getTurmaId() {
        return turma.getId();
    }
}
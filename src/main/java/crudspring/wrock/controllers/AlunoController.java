package crudspring.wrock.controllers;

import crudspring.wrock.forms.AlunoForm;
import crudspring.wrock.models.Aluno;
import crudspring.wrock.models.Turma;
import crudspring.wrock.repositories.AlunoRepository;
import crudspring.wrock.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    TurmaRepository turmaRepository;


    @GetMapping
    public List<Aluno> listaAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("{id}")
    public Aluno listaAlunoUnico(@PathVariable(value = "id") long id) {

        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado!");
        }
        return alunoOptional.get();

    }

    @PostMapping
    public Aluno salvaAluno(@Valid @RequestBody AlunoForm alunoForm) throws Exception {
        Aluno aluno = new Aluno();
        aluno.setEmail(alunoForm.getEmail());
        aluno.setNascimento(alunoForm.getNascimento());
        aluno.setNome(alunoForm.getNome());
        aluno.setIdade(alunoForm.getIdade());
        aluno.setTelefone(alunoForm.getTelefone());
        aluno.setSexo(alunoForm.getSexo());

        Optional<Turma> turmaOptional = turmaRepository.findById(Long.valueOf(alunoForm.getTurmaId()));
        if (turmaOptional.isEmpty()) {
            throw new EntityNotFoundException("A turma informada não existe!");
        }

        if (turmaOptional.get().getVagas() <= turmaOptional.get().getAlunos().stream().count()) {
            throw new Exception("Não existe vaga para essa turma!");
        }

        aluno.setTurma(turmaOptional.get());
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizaAluno(@PathVariable(value = "id") long id, @Valid @RequestBody AlunoForm alunoForm) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isEmpty()) {
            throw new EntityNotFoundException("Aluno não foi encontrado!");
        }

        Aluno aluno = alunoOptional.get();
        aluno.setEmail(alunoForm.getEmail());
        aluno.setNascimento(alunoForm.getNascimento());
        aluno.setNome(alunoForm.getNome());
        aluno.setIdade(alunoForm.getIdade());
        aluno.setTelefone(alunoForm.getTelefone());
        aluno.setSexo(alunoForm.getSexo());

        Optional<Turma> turmaOptional = turmaRepository.findById(Long.valueOf(alunoForm.getTurmaId()));
        if (turmaOptional.isEmpty()) {
            throw new EntityNotFoundException("A turma informada não existe!");
        }
        aluno.setTurma(turmaOptional.get());
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void deletaAluno(@PathVariable long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isEmpty()) {
            throw new EntityNotFoundException("Aluno não foi encontrado!");
        }
        alunoRepository.delete(alunoOptional.get());
    }
}

package crudspring.wrock.controllers;

import crudspring.wrock.forms.TurmaForm;
import crudspring.wrock.models.Turma;
import crudspring.wrock.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/turmas")
public class TurmaController {

    @Autowired
    TurmaRepository turmaRepository;

    @GetMapping
    public List<Turma> listaTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Turma listaTurma(@PathVariable(value = "id") long id) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if (turmaOptional.isEmpty()) {
            throw new EntityNotFoundException("Turma não encontrada!");
        }
        return turmaOptional.get();
    }

    @PostMapping
    public Turma salvaTurma(@Valid @RequestBody TurmaForm turmaForm) {
        Turma turma = new Turma();
        turma.setData(turmaForm.getData());
        turma.setHorario(turmaForm.getHorario());
        turma.setNome(turmaForm.getNome());
        turma.setVagas(turmaForm.getVagas());
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma atualizaTurma(@PathVariable(value = "id") long id, @Valid @RequestBody TurmaForm turmaForm) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if (turmaOptional.isEmpty()) {
            throw new EntityNotFoundException("Turma não encontrada!");
        }
        Turma turma = turmaOptional.get();
        turma.setData(turmaForm.getData());
        turma.setHorario(turmaForm.getHorario());
        turma.setNome(turmaForm.getNome());
        turma.setVagas(turmaForm.getVagas());
        return turmaRepository.save(turma);
    }

    @DeleteMapping("/{id}")
    public void deletaTurma(@PathVariable long id) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if (turmaOptional.isEmpty()) {
            throw new EntityNotFoundException("Turma não encontrada!");
        }

        turmaRepository.delete(turmaOptional.get());
    }
}


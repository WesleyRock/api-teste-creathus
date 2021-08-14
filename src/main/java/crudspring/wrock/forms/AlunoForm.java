package crudspring.wrock.forms;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AlunoForm {

    @Length(max = 100, message = "No máximo 100 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotNull(message = "Campo obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    @NotNull(message = "Campo obrigatório")
    private Integer idade;

    @Length(max = 1, message = "No máximo 1 caractere")
    @NotBlank(message = "Campo obrigatório")
    private String sexo;

    @Length(max = 16, message = "No máximo 16 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String telefone;

    @NotBlank(message = "Campo obrigatório")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    private String turmaId;

    public String getNome() {
        return nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTurmaId() {
        return turmaId;
    }
}

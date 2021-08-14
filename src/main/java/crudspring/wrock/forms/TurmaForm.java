package crudspring.wrock.forms;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class TurmaForm {

    @Length(max = 100)
    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotNull(message = "Campo obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @NotBlank(message = "Campo obrigatório")
    private String horario;

    @NotNull(message = "Campo obrigatório")
    private Integer vagas;

    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public Integer getVagas() {
        return vagas;
    }
}

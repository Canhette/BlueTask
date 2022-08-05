package br.com.softblue.bluetask.domain.task;

import br.com.softblue.bluetask.domain.user.AppUser;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "A descrição da tarefa é obrigatoria")
    @Length(min = 2, max = 40, message = "O tamanho é invalido")
    private String description;

    @NotNull(message = "A data da tarefa é obrigatoria")
    @FutureOrPresent(message = "A data da tarefa não pode estar no passado")
    private LocalDate whenToDo;

    private Boolean done = false;

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Task() {
    }

    public Task(String desciption, LocalDate whenToDo, Boolean done) {
        this.description = desciption;
        this.whenToDo = whenToDo;
        this.done = done;
    }
}

package br.com.softblue.bluetask.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name ="app_user")
public class AppUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome do usuario é obrigatorio")
    private String username;

    @NotEmpty(message = "Senha é obrigatoria")
    private String password;

    @NotEmpty(message = "Nome de exibição é obrigatorio")
    private String displayName;

    public AppUser(){

    }

    public AppUser(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }
}

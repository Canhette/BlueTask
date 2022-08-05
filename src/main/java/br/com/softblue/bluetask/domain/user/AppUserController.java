package br.com.softblue.bluetask.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://editor.swagger.io")
public class AppUserController {

    @Autowired
    public AppUserRepository user;

    @GetMapping(path= "/retornaUser")
    @ResponseBody
    public List<AppUser> retornaAppUser(){
        return user.retornaUser();
    }

    @GetMapping(path= "/retornaId")
    @ResponseBody
    public Optional<AppUser> retornaId(@RequestParam("id") Integer id){
        return user.findById(id);
    }

    @PostMapping(path= "/criarUsuario")
    public AppUser newAppUser(@RequestBody AppUser appUser){
        return user.save(appUser);
    }

    @DeleteMapping(path = "/deletarusuario")
    public String deletarUsuario(@RequestParam("id")Integer id){
        user.deleteById(id);
        return "usuario Excluido";
    }
}

package br.com.softblue.bluetask.teste;

import br.com.softblue.bluetask.domain.task.Task;
import br.com.softblue.bluetask.domain.task.TaskRepository;
import br.com.softblue.bluetask.domain.user.AppUser;
import br.com.softblue.bluetask.domain.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InsertTestData {

    private AppUserRepository appUserRepository;
    private TaskRepository taskREpository;

    @Autowired
    public InsertTestData(AppUserRepository appUserRepository, TaskRepository taskREpository) {
        this.appUserRepository = appUserRepository;
        this.taskREpository = taskREpository;
    }

    @EventListener
    private void onApplicationEvent(ContextRefreshedEvent event){

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        AppUser appUser = new AppUser("joao", encoder.encode("abc"), "John Coner");
        appUserRepository.save(appUser);

        LocalDate baseDate = LocalDate.parse("2025-02-01");

        for (int i = 1; i <=10 ; i++){
            Task task = new Task("Tarefa #" + i , baseDate.plusDays(i), false);
            task.setAppUser(appUser);
            taskREpository.save(task);
        }
    }
}

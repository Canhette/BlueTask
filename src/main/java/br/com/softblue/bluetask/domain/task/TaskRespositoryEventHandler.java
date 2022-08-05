package br.com.softblue.bluetask.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Task.class)
public class TaskRespositoryEventHandler {

    private TaskRepository taskRepository;

    @Autowired
    public TaskRespositoryEventHandler(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @HandleBeforeSave //chamado antes da gravação no repositorio
    @HandleBeforeCreate
    public void handle(Task task) throws DuplicateTaskException {

        Task taskDB = taskRepository.findByDescription(task.getDescription());
        Boolean duplicate = false;

        if(taskDB != null){
            if((task.getId() == null || task.getId() == 0) && task.getDescription().equals(taskDB.getDescription())){
                duplicate = true;
            }

            if (task.getId() != null && task.getId() > 0 && !task.getId().equals(taskDB.getId())) {
                duplicate = true;
            }
        }

        if (duplicate){
            throw new DuplicateTaskException("Já existe uma tarefa com esta descrição");
        }
    }
}

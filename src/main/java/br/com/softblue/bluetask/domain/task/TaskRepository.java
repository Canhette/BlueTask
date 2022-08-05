package br.com.softblue.bluetask.domain.task;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {

    Task findByDescription(String description);
}

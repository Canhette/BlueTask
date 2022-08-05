package br.com.softblue.bluetask.domain.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUsername(String username);
    Optional<AppUser> findById(Integer id);

    @Query(value = "Select * from APP_USER", nativeQuery = true)
    List<AppUser> retornaUser();

}

package app.repositories;

import app.models.ManageUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cjl20 on 2016/1/3.
 */
public interface ManageUserRepository extends CrudRepository<ManageUser, Long> {
    ManageUser findByNameAndPhone(String name, String Phone);
}

package app.repositories;

import app.models.ManageUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cjl20 on 2016/1/3.
 */
public interface ManageUserRepository extends CrudRepository<ManageUser, String> {
    ManageUser findByNameAndPhone(String name, String Phone);
    ManageUser findByOpenid(String Openid);
    List<ManageUser> findAll();

}

package app.repositories;

import app.models.Dealer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
public interface DealerRepository extends CrudRepository<Dealer, String> {
    Dealer findByNameAndPhone(String name, String Phone);

    Dealer findByOpenid(String OpenId);

}
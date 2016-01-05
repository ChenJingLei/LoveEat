package app.repositories;

import app.models.OrderForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
public interface OrderFormRepository extends CrudRepository<OrderForm, Long> {
    OrderForm findByGidAndDid(String gid, String did);
    OrderForm findByOfid(Long ofid);
    List<OrderForm> findAll();

}

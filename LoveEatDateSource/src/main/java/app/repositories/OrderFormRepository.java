package app.repositories;

import app.models.OrderForm;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
public interface OrderFormRepository extends CrudRepository<OrderForm, Long> {
    OrderForm findByGidAndDid(Long gid, Long did);
}

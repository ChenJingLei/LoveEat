package app.repositories;

import app.models.Goods;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
public interface GoodsRepository extends CrudRepository<Goods, Long> {
    Goods findByNameAndOplace(String name, String place);
    Goods findByName(String name);
    List<Goods> findAll();

}


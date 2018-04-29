package tk.bghgu.security.repository;

import org.springframework.data.repository.CrudRepository;
import tk.bghgu.security.domain.USER;

/**
 * Created by ds on 2018-04-29.
 */

public interface UserRepositiry extends CrudRepository<USER, String> {

}

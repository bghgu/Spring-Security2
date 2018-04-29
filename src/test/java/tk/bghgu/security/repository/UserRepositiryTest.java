package tk.bghgu.security.repository;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.bghgu.security.domain.USER;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by ds on 2018-04-29.
 */

/**
 * @DataJpaTest는 Test후 DB Rollback
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositiryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepositiry userRepositiry;

    @Test
    public void testFindById() {
        Optional<USER> user1 = userRepositiry.findById("2");
        if(user1.isPresent()) {
            logger.info(user1.get().toString());
        }else {
            logger.info("No USER");
        }
    }
}
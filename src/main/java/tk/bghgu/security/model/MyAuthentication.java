package tk.bghgu.security.model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import tk.bghgu.security.domain.USER;

/**
 * Created by ds on 2018-04-30.
 */

@Data
public class MyAuthentication extends UsernamePasswordAuthenticationToken {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private USER user;

    public MyAuthentication (final UserDetailsImpl userDetails) {
        super(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        logger.info("테스트 : MyAuthentication");
        this.user = userDetails.getUser();
    }

}

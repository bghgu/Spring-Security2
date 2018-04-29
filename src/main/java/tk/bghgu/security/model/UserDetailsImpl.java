package tk.bghgu.security.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import tk.bghgu.security.domain.USER;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ds on 2018-04-29.
 */

public class UserDetailsImpl extends User {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private USER user;

    public UserDetailsImpl(final USER user) {
        super(user.getId(), user.getPw(), authorities(user));
        logger.info("테스트 : UserDetailsImpl");
        this.user = user;
    }

    /**
     * 사용자 권한 부여
     * @param user 사용자 객체
     * @return 인가 객체
     */
    private static Collection<? extends GrantedAuthority> authorities(final USER user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getType() == 1) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }

    public USER getUser() {
        return user;
    }
}

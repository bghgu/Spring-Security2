package tk.bghgu.security.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.bghgu.security.domain.USER;
import tk.bghgu.security.model.MyAuthentication;
import tk.bghgu.security.model.UserDetailsImpl;
import tk.bghgu.security.repository.UserRepositiry;

import java.util.Optional;

/**
 * Created by ds on 2018-04-29.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepositiry userRepositiry;

    /**
     * DB에 접근해서 사용자 정보를 가져온다.
     * @param id 사용자 id
     * @return UserDetails 구현체
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String id) throws UsernameNotFoundException {
        logger.info("테스트 : loadUserByUsername " + id);
        Optional<USER> user = userRepositiry.findById(id);
        if(!user.isPresent()) {
            logger.info("No USER");
            throw  new UsernameNotFoundException(id);
        }
        return new UserDetailsImpl(user.get());
    }
}

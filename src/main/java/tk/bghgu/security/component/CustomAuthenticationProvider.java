package tk.bghgu.security.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tk.bghgu.security.model.MyAuthentication;
import tk.bghgu.security.model.UserDetailsImpl;
import tk.bghgu.security.service.impl.UserDetailsServiceImpl;

/**
 * Created by ds on 2018-04-29.
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("테스트 : authenticate1");
        String id = authentication.getName();
        String pw = authentication.getCredentials().toString();
        return authentication(id, pw);
    }

    private Authentication authentication(final String id, final String pw) throws AuthenticationException {
        logger.info("테스트 : authenticate2");
        UserDetailsImpl userDetails;
        try {
            userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(id);
            if (!pw.equals(userDetails.getPassword())) throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        } catch (UsernameNotFoundException e) {
            logger.info(e.toString());
            throw new UsernameNotFoundException(e.getMessage());
        } catch (BadCredentialsException e) {
            logger.info(e.toString());
            throw new BadCredentialsException(e.getMessage());
        } catch (Exception e) {
            logger.info(e.toString());
            throw new RuntimeException(e.getMessage());
        }
        return new MyAuthentication(userDetails);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}

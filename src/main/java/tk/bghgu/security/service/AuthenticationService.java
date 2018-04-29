package tk.bghgu.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tk.bghgu.security.domain.USER;
import tk.bghgu.security.model.MyAuthentication;

/**
 * Created by ds on 2018-04-30.
 */

@Service
public class AuthenticationService {

    /**
     * 현재 로그인한 사용자 정보 리턴
     * @return 사용자 객체
     */
    public static USER getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof MyAuthentication)
            return ((MyAuthentication) authentication).getUser();
        return null;
    }

    /**
     * 사용자 할당
     * @param user 사용자 객체
     */
    public static void setCurrentUser(USER user) {
        ((MyAuthentication)
                SecurityContextHolder.getContext().getAuthentication()).setUser(user);
    }
}

package busanIt403.Instagram.config.auth;

import busanIt403.Instagram.mapper.UserMapper;
import busanIt403.Instagram.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    // 시큐리티 session = Authentication = UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userMapper.findByUsername(username);
        if (userModel != null){
            return new PrincipalDetails(userModel);
        }
        return null;
    }
}

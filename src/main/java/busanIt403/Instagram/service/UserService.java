package busanIt403.Instagram.service;

import busanIt403.Instagram.mapper.UserMapper;
import busanIt403.Instagram.model.UserModel;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Log
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void register(UserModel userModel) {
        userMapper.register(userModel);
    }
}

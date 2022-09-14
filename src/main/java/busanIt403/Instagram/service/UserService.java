package busanIt403.Instagram.service;

import busanIt403.Instagram.mapper.UserMapper;
import busanIt403.Instagram.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserModel selectUser() {
        return userMapper.selectUser();
    }
}

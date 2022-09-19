package busanIt403.Instagram.mapper;

import busanIt403.Instagram.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void register(UserModel userModel);

    UserModel findByUsername(String username);
}

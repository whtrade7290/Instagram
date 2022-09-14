package busanIt403.Instagram.mapper;

import busanIt403.Instagram.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserModel selectUser();
}

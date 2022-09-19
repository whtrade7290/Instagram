package busanIt403.Instagram.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class UserModel {

    private int num;
    private String username;
    private String password;
    private String role;

}

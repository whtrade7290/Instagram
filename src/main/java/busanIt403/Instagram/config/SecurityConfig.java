package busanIt403.Instagram.config;




import busanIt403.Instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/css/**","/account/**").permitAll() // 아래에 적힌 페이지들은 로그인 안해도 접속 가능
                .anyRequest().authenticated() // 모든 요청은 로그인 필요
                .and()
                .formLogin() // form을 통해 로그인한다.
                .loginPage("/account/login")// 그 페이지는 /account/login
                .loginProcessingUrl("/account/login") // 로그인 form 서브밋 post 요청을 Security가 가로챔
                .defaultSuccessUrl("/account/success")// 로그인 성공하면 가는 페이지
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    // 비밀번호 인코딩 메서드
    @Bean
	public BCryptPasswordEncoder encryptPassword() {
		return new BCryptPasswordEncoder();
	}




}

package vn.DungVipPro.restAPIAndHibernate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserSecurity {

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails u1 = User.builder().username("hanh").password("{noop}123").roles("admin").build();
//        UserDetails u2 = User.builder().username("dung").password("{noop}123").roles("manager").build();
//        UserDetails u3 = User.builder().username("duy").password("{noop}123").roles("user").build();
//        return new InMemoryUserDetailsManager(u1, u2, u3);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->{
            configurer
                    .requestMatchers(HttpMethod.GET, "/students").hasAnyRole("ADMIN", "USER", "MANAGER")
                    .requestMatchers(HttpMethod.GET, "/students/**").hasAnyRole("ADMIN", "USER", "MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/students/**").hasAnyRole("ADMIN", "MANAGER")
                    .requestMatchers(HttpMethod.POST, "/students/**").hasAnyRole("ADMIN", "MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/students/**").hasRole("ADMIN");
        });
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }


}

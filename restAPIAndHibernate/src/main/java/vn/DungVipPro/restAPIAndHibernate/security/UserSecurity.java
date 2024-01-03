package vn.DungVipPro.restAPIAndHibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserSecurity {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails u1 = User.builder().username("hanh").password("{noop}123").roles("admin").build();
        UserDetails u2 = User.builder().username("dung").password("{noop}123").roles("manager").build();
        UserDetails u3 = User.builder().username("duy").password("{noop}123").roles("user").build();
        return new InMemoryUserDetailsManager(u1, u2, u3);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->{
            configurer
                    .requestMatchers(HttpMethod.GET, "/students").hasAnyRole("admin", "user", "manager")
                    .requestMatchers(HttpMethod.GET, "/students/**").hasAnyRole("admin", "user", "manager")
                    .requestMatchers(HttpMethod.PUT, "/students/**").hasAnyRole("admin", "manager")
                    .requestMatchers(HttpMethod.POST, "/students/**").hasAnyRole("admin", "manager")
                    .requestMatchers(HttpMethod.DELETE, "/students/**").hasRole("admin");
        });
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}

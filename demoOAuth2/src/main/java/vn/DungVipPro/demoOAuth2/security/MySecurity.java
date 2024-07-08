package vn.DungVipPro.demoOAuth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import vn.DungVipPro.demoOAuth2.oauth2User.CustomOAuth2User;
import vn.DungVipPro.demoOAuth2.oauth2User.CustomOAuth2UserService;

import javax.sql.DataSource;

@Configuration
public class MySecurity {
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    public MySecurity(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
           request.requestMatchers("/**").permitAll()
        ).oauth2Login(oauth -> {
            oauth.loginPage("/login")
                    .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig.userService(customOAuth2UserService))
                    .successHandler((request, response, authentication) -> {
                        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
                        String email = oAuth2User.getAttribute("email");
                        String locale  = oAuth2User.getAttribute("locale");
                        String given_name  = oAuth2User.getAttribute("given_name");
                        String family_name  = oAuth2User.getAttribute("family_name");
                        System.out.println(email);
                        System.out.println(locale);
                        System.out.println(given_name);
                        System.out.println(family_name);
                        response.sendRedirect(email.equals("daoducdung2000@gmail.com") == true ? "/success" : "/index");
                    });
        });
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}

package kr.co.ubcn.welpoint.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Configuration
@CrossOrigin("*")
// @EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected UserDetailsService userDetailsService() {
        //return super.userDetailsService();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/v1/**").permitAll()
//                .anyRequest().authenticated()
//        .and()
//                .formLogin()
//                .loginPage("/v1/login")
//                .permitAll()
//        .and()
//                .logout()
//                .permitAll()
        .and().cors().and().csrf().disable()
        .authorizeRequests();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        log.info("!!!!!:{}",Arrays.asList("*"));
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        // AS-IS: corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowedMethods(Arrays.asList("HEAD","GET", "POST", "PUT", "DELETE"));
        //corsConfiguration.addAllowedOrigin("*");
        //corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        corsConfiguration.addAllowedOriginPattern("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);

        return source;
    }


}

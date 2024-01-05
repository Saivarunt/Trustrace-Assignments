package com.example.supply_chain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.supply_chain.filter.AuthFilter;
import com.example.supply_chain.model.User;
import com.example.supply_chain.service.impl.UserService;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    AuthFilter authFilter;

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/login/**").permitAll())
                .authorizeHttpRequests(requests -> requests
                .requestMatchers(HttpMethod.GET,"/facilities/select/facilities","/facilities/select/facilitiesbyId/{*id}","/facilities/withImage/**")
                .permitAll())
                // .authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.POST).authenticated())
                // .authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.PUT).authenticated())
                // .authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.DELETE).authenticated())
                // .authorizeHttpRequests(requests -> requests.requestMatchers("/**").authenticated())
                .authorizeHttpRequests(requests -> requests.anyRequest().hasAuthority("admin"))
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
// username, email, pwd, role
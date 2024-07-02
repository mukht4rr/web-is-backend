//package com.web_is.Security;
//
//import com.web_is.Service.StudentService;
//import com.web_is.Service.UserService;
//import com.web_is.User.Student;
//import com.web_is.User.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private StudentService studentService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("*").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/auth/login")
//                        .defaultSuccessUrl("/home", true)
//                )
//                .logout((logout) -> logout
//                        .logoutUrl("/auth/logout")
//                        .logoutSuccessUrl("/auth/login")
//                );
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return (username) -> {
//            User user = userService.findByUsername(username);
//            if (user != null) {
//                return user;
//            }
//            Student student = studentService.findByRegistrationNumber(username);
//            if (student != null) {
//                return student;
//            }
//            throw new UsernameNotFoundException("User not found");
//        };
//    }
//}

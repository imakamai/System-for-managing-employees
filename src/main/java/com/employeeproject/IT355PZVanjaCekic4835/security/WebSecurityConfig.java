package com.employeeproject.IT355PZVanjaCekic4835.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
    final
    EmployeeDetailsService employeeDetailsService;

    public WebSecurityConfig(EmployeeDetailsService employeeDetailsService) {
        this.employeeDetailsService = employeeDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(employeeDetailsService);
        authenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("http://localhost:4200/login-page")
                                .defaultSuccessUrl("http://localhost:4200/employees", true)
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .deleteCookies("JSESSIONID")
                                .logoutSuccessUrl("http://localhost:4200/login-page?logout")
                                .permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection for simplicity, enable in production
                .addFilter(corsFilter());

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:4200"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
////                                .requestMatchers("/login-page", "/index.html", "/static/**").permitAll()
//                                .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
//                                .requestMatchers("/login").permitAll()
//                                .requestMatchers("/").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("http://localhost:4200/login-page")
//                                .defaultSuccessUrl("http://localhost:4200/employee", true)
//                                .permitAll()
//                )
//                .logout(logout ->
//                        logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .deleteCookies("JSESSIONID")
//                                .logoutSuccessUrl("http://localhost:4200/login-page?logout")
//                                .permitAll()
//                )
//                .cors(cors -> cors.configurationSource(request -> {
//                    CorsConfiguration config = new CorsConfiguration();
//                    config.setAllowedOrigins(List.of("http://localhost:4200"));
//                    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//                    config.setAllowedHeaders(List.of("*"));
//                    config.setAllowCredentials(true);
//                    return config;
//                }));
//
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
//                                .requestMatchers("/login").permitAll()
//                                .requestMatchers("/").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login")
//                                .defaultSuccessUrl("/employee", true)
//                                .permitAll()
//                )
//                .logout(logout ->
//                        logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .deleteCookies("JSESSIONID")
//                                .logoutSuccessUrl("/login?logout")
//                                .permitAll()
//                );
//
//        return http.build();
//    }
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//            .cors().and()
//            .authorizeHttpRequests(authorizeRequests ->
//                    authorizeRequests
//                            .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
//                            .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
//                            .requestMatchers("/login").permitAll()
//                            .requestMatchers("/").permitAll()
//                            .anyRequest().authenticated()
//            )
//            .formLogin(formLogin ->
//                    formLogin
//                            .loginPage("/login")
//                            .defaultSuccessUrl("/employee", true)
//                            .permitAll()
//            )
//            .logout(logout ->
//                    logout
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                            .deleteCookies("JSESSIONID")
//                            .logoutSuccessUrl("/login?logout")
//                            .permitAll()
//            );
//
//    return http.build();
//}
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:4200")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                        .allowedHeaders("*")
//                        .allowCredentials(true);
//            }
//        };
//    }
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:4200");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("DELETE");
//        config.addAllowedMethod("OPTIONS");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
//                                .requestMatchers("/login").permitAll()
//                                .requestMatchers("/").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login")
//                                .defaultSuccessUrl("/employee", true)
//                                .permitAll()
//                )
//                .logout(logout ->
//                        logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .deleteCookies("JSESSIONID")
//                                .logoutSuccessUrl("/login?logout")
//                                .permitAll()
//                );
//
//        return http.build();
//    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//                        authorizationManagerRequestMatcherRegistry
//                                .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
//                                .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/employee/employees", true)
//                        .permitAll())
//                .logout(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
//                        .deleteCookies("JSESSIONID")
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/login")
//                        .permitAll());
//
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//                        authorizationManagerRequestMatcherRegistry
//                                .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
//                                .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/employee/employees", true)
//                        .permitAll())
//                .logout(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
//                        .deleteCookies("JSESSIONID")
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/login")
//                        .permitAll());
//
//        return http.build();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//                authorizationManagerRequestMatcherRegistry
//                        .requestMatchers("/employee/**").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
////                        .requestMatchers("/employee/**").hasAnyRole("ADMIN")
//
//                        .requestMatchers("/").permitAll()
//                        .anyRequest().authenticated());
//        http.formLogin(fl -> fl.defaultSuccessUrl("/employee"));
//
//        http.logout(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
//                .deleteCookies("JSESSIONID")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//        );
//
//        return http.build();
//    }



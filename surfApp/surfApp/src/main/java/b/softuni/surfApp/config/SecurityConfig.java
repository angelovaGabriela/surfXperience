package b.softuni.surfApp.config;

import b.softuni.surfApp.repository.UserRepository;
import b.softuni.surfApp.service.impl.SurfAppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
      return  httpSecurity.authorizeHttpRequests(
              //Setup which URLs are available to who
              authorizeRequests ->
                      authorizeRequests
                              // All static resources in "common locations" (css, images, js) are available to anyone
                              .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                              // Some more resources for all users
                              .requestMatchers("/", "/login", "/register").permitAll()
                              // All other Urls should be authenticated
                              .anyRequest()
                              .authenticated()
              )
                .formLogin(formLogin ->
                        formLogin
                                // Where is our custom login form ?
                                .loginPage("/login")
                                // What is the name of the username parameter in the Login POST request?
                                .usernameParameter("username")
                                // What is the name of the password parameter in the Login POST request?
                                .passwordParameter("password")
                                // What happens if the Login is successful ?
                                .defaultSuccessUrl("/", true)
                                //What happens if the Login fails ?
                                .failureForwardUrl("/login-error")
                )
                .logout(
                        logout ->
                                // Which is the logout URL
                                logout.logoutUrl("/logout")
                                        // Where to go in case of success
                                        .logoutSuccessUrl("/")
                                        // invalidate the session after logout
                                        .invalidateHttpSession(true)
                )
                .build();

    }

    @Bean
    public SurfAppUserDetailsService userDetailsService(UserRepository userRepository) {
        return new SurfAppUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder
                .defaultsForSpringSecurity_v5_8();
    }
}

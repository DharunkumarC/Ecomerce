package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {


    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

//        this code not working spring boot 3+ version
        //        http
//                .authorizeRequests()
//                .requestMatchers("/public/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                //.logout()
//                .logoutUrl("/logout") // URL to trigger logout
//                .logoutSuccessUrl("/login?logout") // URL to redirect after successful logout
//                .invalidateHttpSession(true) // Invalidate session
//                .deleteCookies("JSESSIONID"); // Delete cookies

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**").permitAll() // Allow access to public endpoints
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .permitAll() // Allow access to the login page
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL to trigger logout
                        .logoutSuccessUrl("/login?logout") // URL to redirect after successful logout
                        .invalidateHttpSession(true) // Invalidate session
                        .deleteCookies("JSESSIONID") // Delete session cookies
                        .permitAll() // Allow access to logout
                );
        return http.build();
    }
}

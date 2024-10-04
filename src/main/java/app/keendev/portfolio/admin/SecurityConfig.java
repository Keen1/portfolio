package app.keendev.portfolio.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http.authorizeHttpRequests((authorize) -> authorize
               .requestMatchers("/","/home","/blog/**").permitAll()
               .requestMatchers("/styles/**", "/images/**").permitAll()
               .requestMatchers("/admin/**", "/create", "/edit/**", "/delete/**").hasRole("ADMIN")
               .anyRequest().permitAll()

            )
               .formLogin(form -> form.permitAll())
               .logout(logout -> logout
                       .logoutSuccessUrl("/")
                       .permitAll()
               );

       return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

package gsohz.dio_spring_security.config;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    @Autowired
    private SecurityDatabaseService securityService;

    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder()
                .username("gsohz")
                .password(bCryptPasswordEncoder().encode("1234"))
                .authorities("ROLE_USER")
                .build();

        UserDetails admin = User.builder()
                .username("manager")
                .password(bCryptPasswordEncoder().encode("1234"))
                .authorities("ROLE_MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user1,admin);
    }
    */


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers("/public/**", "/auth/**").permitAll())
                .authorizeHttpRequests(req -> req.requestMatchers("/users/**").hasAnyRole("USER", "MANAGER"))
                .authorizeHttpRequests(req -> req.requestMatchers("/managers/**").hasRole("MANAGER"))
                .authorizeHttpRequests(req -> req.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .maximumSessions(1) // Configura apenas uma sessão por usuário
                        .maxSessionsPreventsLogin(true)); // Evita login múltiplo

        return http.build();
    }

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionEventPublisher() {
            @Override
            public void sessionCreated(HttpSessionEvent event) {
                super.sessionCreated(event);
                event.getSession().setMaxInactiveInterval(0); // Define o tempo de vida da sessão como 0 (invalida a sessão)
            }
        };
    }
}
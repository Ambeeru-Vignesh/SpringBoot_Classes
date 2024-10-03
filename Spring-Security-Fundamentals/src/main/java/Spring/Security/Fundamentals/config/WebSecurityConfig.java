package Spring.Security.Fundamentals.config;

import Spring.Security.Fundamentals.entities.enums.Role;
import Spring.Security.Fundamentals.filters.JwtAuthFilter;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    private static final String[] publicRoutes = {
            "/error", "/auth/**", "/home.html"
    };


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity
               .authorizeHttpRequests(auth -> auth
                       .requestMatchers(publicRoutes).permitAll()
                       .requestMatchers(HttpMethod.GET, "/posts/**").permitAll()
                       .requestMatchers(HttpMethod.POST, "/posts/**")
                       .hasAnyRole(Role.ADMIN.name(), Role.CREATOR.name())
                       .anyRequest().authenticated())
               .csrf(csrfConfig -> csrfConfig.disable())
               .sessionManagement(sessionConfig -> sessionConfig
                       .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .addFilterBefore((Filter) jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

       return httpSecurity.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

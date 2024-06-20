package project.mdm.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import project.mdm.security.jwt.JwtAuthenticationEntryPoint;
import project.mdm.security.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CorsConfigurationSource corsConfigurationSource;

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(httpBasic -> httpBasic.disable())
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .authorizeHttpRequests(authorize
                                -> authorize
                                .requestMatchers("/board/list",
                                        "/board/{boardId}",
                                        "/board/search",
                                        "/user/checkId",
                                        "/user/register",
                                        "/user/login",
                                        "/board/{boardId}/comment/list/**",
                                        "/board/{boardId}/file/download/**",
                                        "/review/list",
                                        "/review/{reviewId}",
                                        "/review/search",
                                        "/review/{reviewId}/comment/list/**",
                                        "/inquiry/{inquiryId}",
                                        "/inquiry/list",
                                        "/inquiry/search",
                                        "/user/**",
                                        "/board/**",
                                        "/admin/**",
                                        "/video/**",
                                        "/notice/**",
                                        "/history/**",
                                        "/**"
                                ).permitAll()
/*                      .requestMatchers("/video/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/board/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/inquiry/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/mypage/**").hasRole("USER")
                        .requestMatchers("/board/{boardId}/comment/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/review/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/review/{reviewId}/comment/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/board/{boardId}/file/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")*/
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(excep -> excep.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

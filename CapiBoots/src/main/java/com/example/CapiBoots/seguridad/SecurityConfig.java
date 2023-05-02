package com.example.CapiBoots.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public UserDetailsService userDetailsService;

    //Codificador de contraseña
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Configuramos el autenticador diciéndole que usamos el userDetailsService y el codificador de contraseña
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    //TODO Aplicar el .csrf().disable(); al http si los th dejan de funcionar.
    //TODO aplicar las direcciones de pantallas a este método
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize ->authorize

                        //Plantillas de html a los que el usuario puede o no acceder

                        // Peticiones permitidas para todos los usuarios
                        .requestMatchers("/index","/","").permitAll()
                        .requestMatchers("/webjars/**", "/js/**","/css/**","/img/**","/fonts/**","/favicon.ico").permitAll()
                        .requestMatchers("*css", "*js").permitAll()
                        .requestMatchers("/registro/**","/forgot_password" ,"/reset_password","/signup", "/inicio","/error", "/login").permitAll()
                        //Peticiones asociadas a las notificaciones y conexiones websocket
                        .requestMatchers("/gs-guide-websocket/**").permitAll()
                        // Peticiones permitidas sólo para usuarios con rol ADMIN
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/users").hasRole("ADMIN")

                        // Peticiones permitidas sólo para usuarios autenticados
                        .requestMatchers("/chat","/videos","/files/**","/upload","/userFiles/**","/databasefiles/**").authenticated()
                        .requestMatchers("/uploadUserFileToDatabase","/uploadUserFileToFileSystem","/uploadToFileSystem","/uploadToDatabase").authenticated()



                        //Aceptar a todos los usuarios para stream de videos
                        .requestMatchers("/stream/**").authenticated()

                        // Peticiones permitidas sólo para usuarios autenticados con rol USER
                        .requestMatchers("/user/**").hasRole("USER")
                ).formLogin(
                        form -> form
                                .loginPage("/login") // Establece la ruta a la página de inicio de sesión
                                .loginProcessingUrl("/login") // Establece la ruta de procesamiento del formulario de inicio de sesión
                                .defaultSuccessUrl("/") // Establece la ruta de redirección después de que el usuario inicia sesión correctamente
                                .permitAll() // Permite a cualquier usuario acceder a la página de inicio de sesión
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Establece la ruta para procesar la petición de cierre de sesión
                                .permitAll() // Permite a cualquier usuario acceder a la página de cierre de sesión
                );
        return http.build();
    }
}

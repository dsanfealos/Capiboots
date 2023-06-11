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

    //Configuramos el autentificador diciéndole que usamos el userDetailsService y el codificador de contraseña
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize ->authorize

                        //Plantillas de html a los que el usuario puede o no acceder

                        // Peticiones permitidas para todos los usuarios
                        .requestMatchers("/inicio","/","").permitAll()
                        .requestMatchers("/webjars/**", "/static/files/js/**", "/static/files/css/**","/img/**","/fonts/**","/favicon.ico").permitAll()
                        .requestMatchers("*css", "*js").permitAll()
                        .requestMatchers("/registro/**", "/register/**","/forgot_password" ,"/reset_password","/signup", "/error", "/login", "/login/**").permitAll()
                        .requestMatchers("/template_menus/**", "/template_inicio/**", "/template_home/**", "/videos/**").permitAll()
                        .requestMatchers("/reproducir/**","/uploads/**","/files/**").permitAll()
                        .requestMatchers("/empieza/**").permitAll()
                        .requestMatchers("/termina/**").permitAll()
                        //Peticiones asociadas a las notificaciones y conexiones websocket
                        .requestMatchers("/gs-guide-websocket/**").permitAll()
                        // Peticiones permitidas sólo para usuarios con rol ADMIN
                        .requestMatchers("/admin/**","/nuevo-usuario","/nuevo-logro","/nuevo-contenido","/nuevo-comentario","/nueva-temporada","/nueva-serie","/nueva-categoria").hasRole("ADMIN")
                        .requestMatchers("/lista-usuarios","/lista-series","/lista-temporadas","/lista-categorias","/lista-comentarios","/lista-contenidos","/lista-pendientes").hasRole("ADMIN")
                        .requestMatchers("/usuario/**").hasRole("ADMIN")

                        // Peticiones permitidas solo para usuarios autenticados
                        .requestMatchers("/chat","/videos","/favoritos" ,"/moviebox","/upload","/userFiles/**","/databasefiles/**","/empezar/**","/terminar/**").authenticated()
                        .requestMatchers("/showbox","/bookbox", "/home", "/favoritos","/ajustes","/logros","/suscripcion","/forms/**","/busqueda", "/gestion", "/gestion/**","/busqueda/**" ).authenticated()
                        .requestMatchers("/uploadUserFileToDatabase","/uploadUserFileToFileSystem","/uploadToFileSystem","/uploadToDatabase","/temporada/**").authenticated()
                        .requestMatchers("/ajustes/**","/contenido/**","/serie/**","/lista-pendientes/**","/acceso/**","/reproducir-l/**","/reproducir-t/**" ).authenticated()



                        //Aceptar a todos los usuarios para stream de videos
                        .requestMatchers("/stream/**").authenticated()


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

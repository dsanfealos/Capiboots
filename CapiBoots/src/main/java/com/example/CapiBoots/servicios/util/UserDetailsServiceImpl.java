package com.example.CapiBoots.servicios.util;



import com.example.CapiBoots.modelos.Rol;
import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


/**
 * Esta clase es una implementación personalizada de UserDetailsService para manejar
 * la autenticación de usuarios en la aplicación. Utiliza el UserRepository para
 * buscar y cargar la información del usuario en la base de datos.
 * <br>
 * Es una implementación de la interfaz UserDetailsService de Spring Security.
 * Su propósito es proporcionar una forma de cargar y devolver los detalles del usuario en un objeto UserDetails,
 * que es necesario para la autenticación y autorización en Spring Security.
 * <br>
 * En resumen, esta clase se utiliza para cargar los detalles de usuario
 * (como el nombre de usuario, la contraseña y los roles)
 * desde el repositorio de usuarios de la aplicación y devolverlos en un objeto
 * UserDetails para ser utilizado por Spring Security en la autenticación y autorización de los usuarios.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UsuarioRepositorio userRepository; // Inyección de dependencia del UserRepository

    /**
     * Constructor de la clase UserDetailsServiceImpl que inicializa el UserRepository.
     *
     * @param userRepository Repositorio de usuarios que se utiliza para buscar y cargar usuarios.
     */
    public UserDetailsServiceImpl(UsuarioRepositorio userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Este método es utilizado por Spring Security para buscar y cargar el usuario en función del
     * email proporcionado.
     *
     * @param email Email del usuario a buscar.
     * @return UserDetails Una instancia de UserDetails con los datos del usuario encontrado.
     * @throws UsernameNotFoundException Excepción lanzada si no se encuentra ningún usuario con el email proporcionado.
     */
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        // Buscar el usuario por su email utilizando el UserRepository
        Usuario user = userRepository.findByNombreUsuario(nombre);

        // Si el usuario es encontrado, crear una instancia de UserDetails utilizando los datos del usuario
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getNombreUsuario(),
                    user.getClave(),
                    mapRolesToAuthorities(user.getRoles())); // mapRolesToAuthorities es una función auxiliar que se define más abajo
        }else{
            // Si el usuario no es encontrado, lanzar una excepción UsernameNotFoundException
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    /**
     * Esta función auxiliar se utiliza para convertir la lista de roles del usuario en una colección de
     * autoridades que pueden ser utilizadas por Spring Security.
     *
     * @param roles Lista de roles del usuario.
     * @return Collection< ? extends GrantedAuthority> Colección de autoridades.
     */
    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(List<Rol> roles) {
        // Utilizar streams de Java para mapear cada rol a una instancia de SimpleGrantedAuthority
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList(); // Convertir el stream en una lista
    }
}

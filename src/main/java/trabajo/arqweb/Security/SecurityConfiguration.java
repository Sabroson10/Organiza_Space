package trabajo.arqweb.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    private static final String[] AUTH_WHITELIST ={
            // -- Swagger
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui/**",

            // -- Login
            "/api/users/login/**",

            // -- Resigtro
            "/api/users/register/**"
    };

    // Authentication Manager
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Security Filter Chain

    /*

    1. Cuales van a ser los Request(pedidos) que seran evaluados para saber si el usuario tiene permisos sobre estos
        a. AnyRequest -> Todos los pedidos
        b. RequestMatchers -> Se evalua solo los que coincidan con las rutas
        c. RequestMatches + HttpMethod -> Se evalua a los que coincidan con la ruta y con el metodo (GET, POST, etc.)

    2. Cual es la regla de autorización que se van a aplicar sobre estos Request(pedidos)
        a. permitAll()
        b. denyAll()
        c. requestMatchers()
        d. hasRole()
        e. hayAnyRole()
        f. hasAuthority()
        g. hasAnyAuthority()
        h. SpEL Spring Expression Language
        i. authenticated()

    */

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.addFilterBefore( jwtRequestFilter , UsernamePasswordAuthenticationFilter.class );


        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(Customizer.withDefaults());

        http.authorizeHttpRequests( (auth) -> auth
                //.anyRequest().permitAll()
                .requestMatchers(AUTH_WHITELIST).permitAll()


                //Poner una cadena de filtros iniciando por el más especifico hacia el más genérico
                .requestMatchers(HttpMethod.POST, "/tienda/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/tienda/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/tienda/actualizar/{id}/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/tienda/eliminar/{id}/**").hasAuthority("ADMIN")

                //suscripcion
                .requestMatchers(HttpMethod.POST, "/suscripcion/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/suscripcion/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/suscripcion/actualizar/{id}/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/suscripcion/eliminar/{id}/**").hasAuthority("ADMIN")
                //servicios
                .requestMatchers(HttpMethod.POST, "/servicios/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/servicios/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/servicios/eliminar/{id}/**").hasAuthority("ADMIN")
                //reseñas
                .requestMatchers(HttpMethod.POST, "/reseña/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/reseña/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/reseña/eliminar/{id}/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/reseña/producto/{idProducto}/cantidad").hasAuthority("ADMIN")
                //productos
                .requestMatchers(HttpMethod.POST, "/producto/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/producto/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/producto/actualizar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/producto/eliminar/{id}/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/producto/mayor-a/{precio}/**").hasAuthority("ADMIN")
                //peticion
                .requestMatchers(HttpMethod.POST, "/peticion/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticion/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticion/eliminar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticion/diseñadores/carga-alta/{minProyectos/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticion/diseñadores/mas-activas/**").hasAuthority("ADMIN")
                //espacios
                .requestMatchers(HttpMethod.POST, "/espacios/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/espacios/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/espacios/actualizar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/espacios/eliminar/{id}**").hasAuthority("ADMIN")
                //PeticionProducto
                .requestMatchers(HttpMethod.POST, "/peticionProducto/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticionProducto/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticionProducto/actualizar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticionProducto/eliminar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticionProducto/recomendados/diseñador/{idDisenador}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticionProducto/recomendados/ultimos-30-dias/tienda/{idTienda}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticionProducto/disenador/{idDisenador}/totales-categoria**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/peticionProducto/multiples-tiendas**").hasAuthority("ADMIN")
                //Tiendas
                .requestMatchers(HttpMethod.POST, "/tienda/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/tienda/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/tienda/actualizar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/tienda/eliminar/{id}**").hasAuthority("ADMIN")
                //Pregunta
                .requestMatchers(HttpMethod.POST, "/pregunta/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pregunta/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pregunta/actualizar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pregunta/eliminar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pregunta/cliente/{idCliente}**").hasAuthority("ADMIN")
                //Promocion
                .requestMatchers(HttpMethod.POST, "/promocion/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/actualizar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/eliminar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/activas**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/{idPromocion}/clientes-usaron**").hasAuthority("ADMIN")
                //Diseñadores
                .requestMatchers(HttpMethod.POST, "/promocion/insertar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/mostrar/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/actualizar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/eliminar/{id}**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/promocion/disponibles**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
        );

        http.sessionManagement(
                (session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        return http.build();
    }



    // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

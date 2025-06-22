package trabajo.arqweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import trabajo.arqweb.entities.*;
import trabajo.arqweb.repositories.SuscripcionRepository;
import trabajo.arqweb.services.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ArqWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArqWebApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            UserService userService,
            AuthorityService authorityService,
            TiendasService tiendasservice,
            SuscripcionService suscripcionservice,
            ServiciosService serviciosservice,
            ReseñaService reseñaservice,
            ClienteService clienteservice,
            ProductoService productoservice,
            DiseñadorService diseñadorService,
            PeticionProductoService peticionProductoService,
            PeticionService peticionService,
            PreguntaService preguntaService,

            PromocionService promocionService, EspaciosService espaciosService) {

        return args -> {
            Authority authority1 = authorityService.addAuthority(new Authority("ADMIN"));
            Authority authority2 = authorityService.addAuthority(new Authority("USER"));
            userService.addUser(new User(null, "javier","123",true,
                    List.of(authority1)));

            userService.addUser(new User(null, "alejandro","456",true,
                    List.of(authority2)));

            Tiendas tienda1 = new Tiendas(null,"Minka");
            Tiendas tienda2 = new Tiendas(null,"Sodimac");
            Tiendas tienda3 = new Tiendas(null,"Ripley");

            tiendasservice.insertarTiendas(tienda1);
            tiendasservice.insertarTiendas(tienda2);
            tiendasservice.insertarTiendas(tienda3);

            Suscripcion s1 = new Suscripcion(null,"Plan Básico", 19.90,
                    LocalDate.now(), LocalDate.now().plusMonths(1));

            Suscripcion s2 = new Suscripcion(null,"Plan Premium", 49.90,
                    LocalDate.now(), LocalDate.now().plusMonths(3));

            Suscripcion s3 = new Suscripcion(null,"Plan Anual", 99.90,
                    LocalDate.now(), LocalDate.now().plusYears(1));

            suscripcionservice.insertarSuscripcion(s1);
            suscripcionservice.insertarSuscripcion(s2);
            suscripcionservice.insertarSuscripcion(s3);

            Servicios z1=new Servicios(null,"Quiero limpiar");
            Servicios z2=new Servicios(null,"Quiero ordenar");
            Servicios z3=new Servicios(null,"Quiero remodelar");
            serviciosservice.insertarServicios(z1);
            serviciosservice.insertarServicios(z2);
            serviciosservice.insertarServicios(z3);

            Cliente c1=new Cliente(null,"Fabricio","Rioja","123345","123@gmail.com",s1);
            Cliente c2=new Cliente(null,"Alonso","Ocrospoma","6789","456@gmail.com",s2);
            Cliente c3=new Cliente(null,"Matias","Daniek","10111213","789@gmail.com",s3);
            clienteservice.insertarCliente(c1);
            clienteservice.insertarCliente(c2);
            clienteservice.insertarCliente(c3);

            Producto p1=new Producto(null,"Lampara",12.0,"http://sagafalabella.com",tienda1);
            Producto p2=new Producto(null,"Jarron",16.0,"http://Osechel.com",tienda2);
            Producto p3=new Producto(null,"Messa",50.0,"http://Ripley.com",tienda3);
            productoservice.insertarProducto(p1);
            productoservice.insertarProducto(p2);
            productoservice.insertarProducto(p3);

            Reseña r1=new Reseña(null,c1,"Me gusto la atención",p1);
            Reseña r2=new Reseña(null,c2,"No me gusto la atención",p2);
            Reseña r3=new Reseña(null,c3,"Muy atentos todos, que increible",p3);
            reseñaservice.insetarReseña(r1);
            reseñaservice.insetarReseña(r2);
            reseñaservice.insetarReseña(r3);

            Promocion pr1=new Promocion(null,c1,"XW1","Existe promoción",true);
            Promocion pr2=new Promocion(null,c2,"XW2","Accediste a una promocion",true);
            Promocion pr3=new Promocion(null,c3,"XW3","Tienes una promoción",true);
            promocionService.insertarPromocion(pr1);
            promocionService.insertarPromocion(pr2);
            promocionService.insertarPromocion(pr3);

            Espacios e1=new Espacios(null,"Sala","La sala tiene 12m^2");
            Espacios e2=new Espacios(null,"Cuarto","El cuarto es grande y tiene 25m^2");
            Espacios e3=new Espacios(null,"Cocina","La cocina tiene varios compartimientos");
            espaciosService.insertarEspacios(e1);
            espaciosService.insertarEspacios(e2);
            espaciosService.insertarEspacios(e3);

            Diseñador d1=new Diseñador(null,"Michael","Mazuelos", "987654321","mikemg@gmail.com",true);
            Diseñador d2=new Diseñador(null,"Piero","Aguirre","958188123","pieroam@gmail.com",true);
            Diseñador d3=new Diseñador(null,"Anthony","Crisostomo","958154123","anthonycs@gmail.com",false);
            diseñadorService.insetarDiseñador(d1);
            diseñadorService.insetarDiseñador(d2);
            diseñadorService.insetarDiseñador(d3);

            Peticion pt1=new Peticion(null,c1,e1,z1,d1,"Deseo poder volver mi sala más vintage","Le sugerimos cambiar de muebles y cuadros","PENDIENTE");
            Peticion pt2=new Peticion(null,c2,e2,z2,d2,"Deseo volver a mi cuarto gamer","Le sugerimos comprar un mueble para computadoras y silla gamer","PENDIENTE");
            Peticion pt3=new Peticion(null,c3,e3,z3,d3,"Deseo volver mi cocina como la de un chef","Le sugerimos cambiar de ornillas y aparadores","PENDIENTE");
            peticionService.insertarPeticion(pt1);
            peticionService.insertarPeticion(pt2);
            peticionService.insertarPeticion(pt3);

            PeticionProducto pp1=new PeticionProducto(null,pt1,p1);
            PeticionProducto pp2=new PeticionProducto(null,pt2,p2);
            PeticionProducto pp3=new PeticionProducto(null,pt3,p3);
            peticionProductoService.insertarPeticionProducto(pp1);
            peticionProductoService.insertarPeticionProducto(pp2);
            peticionProductoService.insertarPeticionProducto(pp3);

            Pregunta pg1=new Pregunta(null,"¿Puedes ayudarme a mejorar mi sala?",pt1);
            Pregunta pg2=new Pregunta(null,"¿Puedes ayudarme a transformar mi cuarto?",pt2);
            Pregunta pg3=new Pregunta(null,"¿Puedes ayudarme a cambiar mi cocina?",pt3);
            preguntaService.insertarPregunta(pg1);
            preguntaService.insertarPregunta(pg2);
            preguntaService.insertarPregunta(pg3);

        };

    }
}

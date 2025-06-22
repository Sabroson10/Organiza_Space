package trabajo.arqweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Peticion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeticion;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="id_espacio")
    private Espacios espacios;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicios servicios;

    @ManyToOne
    @JoinColumn(name="id_diseñador")
    private Diseñador diseñador;

    private String descripcion;
    private String recomendacion;
    private String estado;
}

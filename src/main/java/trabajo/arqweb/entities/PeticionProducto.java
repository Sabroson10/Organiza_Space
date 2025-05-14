package trabajo.arqweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PeticionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeticionProducto;

    @ManyToOne
    @JoinColumn(name="id_Peticion")
    private Peticion peticion;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;
}

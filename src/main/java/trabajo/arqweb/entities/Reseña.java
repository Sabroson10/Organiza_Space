package trabajo.arqweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReseña;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}

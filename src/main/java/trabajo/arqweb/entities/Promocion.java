package trabajo.arqweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocion;
    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;
    private String nombreCodigo;
    private String descripcion;
    private Boolean redimido;
}

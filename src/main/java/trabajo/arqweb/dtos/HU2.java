package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU2 {
    private Long idPeticion;
    private String descripcion;
    private String recomendacion;
    private String nombreCliente; // nombre + apellido
}

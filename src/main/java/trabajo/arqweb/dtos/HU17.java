package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU17 {
    private Long idPeticion;
    private String nombreCliente;
    private int cantidadTiendas;
}

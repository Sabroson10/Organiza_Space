package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU4 {
    private Long idPromocion;
    private String nombreCodigo;
    private String descripcion;
    private String nombreCliente; // opcional
}

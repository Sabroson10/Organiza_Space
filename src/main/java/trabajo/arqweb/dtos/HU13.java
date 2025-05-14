package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU13 {
    private Long idProducto;
    private String nombreProducto;
    private String nombreTienda;
    private String enlace;
    private String fechaRecomendacion; // opcional
}

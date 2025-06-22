package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU1 {
    private Long idProducto;
    private String nombre;
    private Double precio;
    private String enlace;
    private String nombreTienda;
}

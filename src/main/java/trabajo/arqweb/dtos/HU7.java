package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU7 {
    private Long idProducto;
    private String nombreProducto;
    private String nombreTienda;
    private String enlace;
    private String nombreDiseñador;
}

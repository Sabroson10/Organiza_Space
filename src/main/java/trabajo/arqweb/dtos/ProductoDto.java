package trabajo.arqweb.dtos;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private Double precio;
    private String enlace;
    private TiendasDto tiendas;
}

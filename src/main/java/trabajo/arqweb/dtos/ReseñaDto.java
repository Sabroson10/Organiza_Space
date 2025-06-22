package trabajo.arqweb.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trabajo.arqweb.entities.Producto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReseñaDto {
    private Long idReseña;
    private ClienteDto cliente;
    private String descripcion;
    private ProductoDto producto;
}

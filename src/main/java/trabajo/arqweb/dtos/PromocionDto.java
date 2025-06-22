package trabajo.arqweb.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trabajo.arqweb.entities.Cliente;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDto {
    private Long idPromocion;
    private ClienteDto cliente;
    private String nombreCodigo;
    private String descripcion;
    private Boolean redimido;
}

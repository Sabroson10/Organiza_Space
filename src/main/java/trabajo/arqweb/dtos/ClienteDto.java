package trabajo.arqweb.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private SuscripcionDto suscripcion;
}

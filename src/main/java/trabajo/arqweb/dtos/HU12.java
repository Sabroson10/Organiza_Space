package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU12 {
    private Long idCliente;
    private String nombreCompleto;
    private String email;
}

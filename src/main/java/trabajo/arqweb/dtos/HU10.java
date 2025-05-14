package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU10 {
    private Long idPregunta;
    private String contenidoPregunta;
    private Long idCliente;
    private String nombreCliente;
}

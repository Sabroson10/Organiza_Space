package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU16 {
    private Long idDiseñador;
    private String nombreCompleto;
    private Long cantidadProyectos;
}

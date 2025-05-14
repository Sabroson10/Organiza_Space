package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU18 {
    private Long idDiseñador;
    private String nombreDiseñador;
    private Long cantidadPeticionesActivas;
}
package trabajo.arqweb.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trabajo.arqweb.entities.Peticion;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaDto {
    private Long idPregunta;
    private String pregunta;
    private PeticionDto peticion;
}

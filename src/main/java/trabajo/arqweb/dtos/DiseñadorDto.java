package trabajo.arqweb.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiseñadorDto {
    private Long idDiseñador;
    private String nombreDiseñador;
    private String apellidoDiseñador;
    private String telefono;
    private String correo;
    private boolean disponible;
}

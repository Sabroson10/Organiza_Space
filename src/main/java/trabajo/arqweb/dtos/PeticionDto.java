package trabajo.arqweb.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trabajo.arqweb.entities.Cliente;
import trabajo.arqweb.entities.Diseñador;
import trabajo.arqweb.entities.Espacios;
import trabajo.arqweb.entities.Servicios;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeticionDto {
    private Long idPeticion;
    private ClienteDto cliente;
    private EspaciosDto espacios;
    private ServiciosDto servicios;
    private DiseñadorDto diseñador;
    private String descripcion;
    private String recomendacion;
    private String estado;
}

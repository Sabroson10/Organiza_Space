package trabajo.arqweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Espacios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspacio;
    private String nombreEspacio;
    private String descripcion;
}

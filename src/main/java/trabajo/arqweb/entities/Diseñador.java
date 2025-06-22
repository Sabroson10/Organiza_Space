package trabajo.arqweb.entities;

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
@Entity
public class Diseñador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiseñador;
    private String nombreDiseñador;
    private String apellidoDiseñador;
    private String telefono;
    private String correo;
    private boolean disponible;
}

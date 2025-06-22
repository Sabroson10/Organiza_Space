package trabajo.arqweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPregunta;
    private String pregunta;
    @ManyToOne
    @JoinColumn(name="id_peticion")
    private Peticion peticion;
}

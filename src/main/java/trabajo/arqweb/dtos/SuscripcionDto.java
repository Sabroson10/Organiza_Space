package trabajo.arqweb.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionDto {
    private Long idSuscripcion;
    private String nombre;
    private Double pago;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
}

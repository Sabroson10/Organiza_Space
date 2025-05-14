package trabajo.arqweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HU11 {
    private String tipoSuscripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private String estado;
}
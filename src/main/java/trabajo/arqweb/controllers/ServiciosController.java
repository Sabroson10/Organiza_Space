package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.ReseñaDto;
import trabajo.arqweb.dtos.ServiciosDto;
import trabajo.arqweb.entities.Reseña;
import trabajo.arqweb.entities.Servicios;
import trabajo.arqweb.services.ServiciosService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {
    @Autowired
    private ServiciosService serviciosService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<ServiciosDto> insertarServicios(@RequestBody ServiciosDto servicioDto) {
        Servicios servicio = modelMapper.map(servicioDto, Servicios.class);
        servicio = serviciosService.insertarServicios(servicio);
        servicioDto = modelMapper.map(servicio, ServiciosDto.class);
        return ResponseEntity.ok(servicioDto);
    }

    @GetMapping("/mostrar")
    public List<ServiciosDto> mostrarServicios() {
        List<Servicios> servicio = serviciosService.mostrarServicios();
        List<ServiciosDto> servicioDto = Arrays.asList(modelMapper.map(servicio, ServiciosDto[].class));
        return servicioDto;
    }
    @DeleteMapping("/eliminar/{id}")
    public void elimnarServicios(@PathVariable Long id) {
        serviciosService.elimnarServicio(id);
    }
}

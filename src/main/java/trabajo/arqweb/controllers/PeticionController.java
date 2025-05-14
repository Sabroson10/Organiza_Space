package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.*;
import trabajo.arqweb.entities.Peticion;
import trabajo.arqweb.services.PeticionService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/peticion")
public class PeticionController {
    @Autowired
    private PeticionService peticionService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<PeticionDto> insertarPeticion(@RequestBody PeticionDto peticionDto) {
        Peticion peticion = modelMapper.map(peticionDto, Peticion.class);
        peticion = peticionService.insertarPeticion(peticion);
        peticionDto = modelMapper.map(peticion, PeticionDto.class);
        return ResponseEntity.ok(peticionDto);
    }

    @GetMapping("/mostrar")
    public List<PeticionDto> mostrarPeticiones() {
        List<Peticion> peticion = peticionService.mostrarPeticiones();
        List<PeticionDto> peticionDtos = Arrays.asList(modelMapper.map(peticion, PeticionDto[].class));
        return peticionDtos;
    }

    @DeleteMapping("/eliminar/{id}")
    public void elimnarPeticion(@PathVariable Long id) {
        peticionService.elimnarPeticion(id);
    }
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<HU2>> obtenerPeticionesPorCliente(@PathVariable Long idCliente) {
        List<HU2> peticiones = peticionService.obtenerPeticionesPorCliente(idCliente);
        return ResponseEntity.ok(peticiones);
    }
    @GetMapping("/diseñadores/carga-alta/{minProyectos}")
    public ResponseEntity<List<HU16>> obtenerDiseñadoresConMasDeXProyectos(@PathVariable Long minProyectos) {
        List<HU16> resultados = peticionService.obtenerDiseñadoresConMasDeXProyectos(minProyectos);
        return ResponseEntity.ok(resultados);
    }
    @GetMapping("/diseñadores/mas-activas")
    public ResponseEntity<List<HU18>> obtenerDisenadoresConMasPeticionesActivas() {
        return ResponseEntity.ok(peticionService.obtenerDisenadoresConMasPeticionesActivas());
    }


}

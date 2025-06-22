package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.EspaciosDto;
import trabajo.arqweb.dtos.FotosDto;
import trabajo.arqweb.entities.Espacios;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.services.EspaciosService;
import trabajo.arqweb.services.FotosService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotosController {
    @Autowired
    private FotosService fotosService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<FotosDto> insertarFotos(@RequestBody FotosDto fotosDto) {
        Fotos fotos = modelMapper.map(fotosDto, Fotos.class);
        fotos = fotosService.insertarFotos(fotos);
        fotosDto = modelMapper.map(fotos, FotosDto.class);
        return ResponseEntity.ok(fotosDto);
    }

    @GetMapping("/mostrar")
    public List<FotosDto> mostrarFotos() {
        List<Fotos> fotos = fotosService.mostrarFotos();
        List<FotosDto> fotosDtos = Arrays.asList(modelMapper.map(fotos, FotosDto[].class));
        return fotosDtos;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FotosDto> actualizarFoto(@PathVariable Long id, @RequestBody FotosDto fotosDto) {
        Fotos fotos = modelMapper.map(fotosDto, Fotos.class);
        fotos = fotosService.actualizarFoto(id, fotos);
        fotosDto= modelMapper.map(fotos, FotosDto.class);
        return ResponseEntity.ok(fotosDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarFoto(@PathVariable Long id) {
        fotosService.eliminarFoto(id);
    }

}

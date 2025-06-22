package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.ClienteDto;
import trabajo.arqweb.dtos.HU11;
import trabajo.arqweb.dtos.HU12;
import trabajo.arqweb.dtos.TiendasDto;
import trabajo.arqweb.entities.Cliente;
import trabajo.arqweb.entities.Tiendas;
import trabajo.arqweb.services.ClienteService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/insertar")
    public ResponseEntity<ClienteDto> insertarCliente(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        cliente = clienteService.insertarCliente(cliente);
        clienteDto = modelMapper.map(cliente, ClienteDto.class);
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping("/mostrar")
    public List<ClienteDto> mostrarClientes() {
        List<Cliente> cliente = clienteService.mostrarClientes();
        List<ClienteDto> clienteDto = Arrays.asList(modelMapper.map(cliente, ClienteDto[].class));
        return clienteDto;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClienteDto> actualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        cliente = clienteService.actualizarCliente(id, cliente);
        clienteDto= modelMapper.map(cliente, ClienteDto.class);
        return ResponseEntity.ok(clienteDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }

    @GetMapping("/{idCliente}/suscripcion")
    public ResponseEntity<HU11> verDetalleSuscripcion(@PathVariable Long idCliente) {
        HU11 dto = clienteService.verDetalleSuscripcion(idCliente);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/sin-promociones")
    public ResponseEntity<List<HU12>> listarClientesSinPromocionesUsadas() {
        return ResponseEntity.ok(clienteService.listarClientesSinPromocionesUsadas());
    }
}

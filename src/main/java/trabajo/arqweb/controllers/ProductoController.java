package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.HU1;
import trabajo.arqweb.dtos.HU5;
import trabajo.arqweb.dtos.ProductoDto;
import trabajo.arqweb.entities.Producto;
import trabajo.arqweb.services.ProductoService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<ProductoDto> insertarProducto(@RequestBody ProductoDto productoDto) {
        Producto producto = modelMapper.map(productoDto, Producto.class);
        producto = productoService.insertarProducto(producto);
        productoDto = modelMapper.map(producto, ProductoDto.class);
        return ResponseEntity.ok(productoDto);
    }

    @GetMapping("/mostrar")
    public List<ProductoDto> mostrarProducto() {
        List<Producto> productos = productoService.mostrarProducto();
        List<ProductoDto> productoDtos = Arrays.asList(modelMapper.map(productos, ProductoDto[].class));
        return productoDtos;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        Producto producto = modelMapper.map(productoDto, Producto.class);
        producto = productoService.actualizarProducto(id, producto);
        productoDto= modelMapper.map(producto, ProductoDto.class);
        return ResponseEntity.ok(productoDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void elimnarProducto(@PathVariable Long id) {
        productoService.elimnarProducto(id);
    }
    @GetMapping("/tienda/{idTienda}")
    public List<HU1> obtenerProductosPorTienda(@PathVariable Long idTienda) {
        return productoService.obtenerProductosPorTienda(idTienda);
    }
    @GetMapping("/mayor-a/{precio}")
    public ResponseEntity<List<HU5>> obtenerProductosPorPrecioMayorA(@PathVariable Double precio) {
        List<HU5> productos = productoService.obtenerProductosPorPrecioMayorA(precio);
        return ResponseEntity.ok(productos);
    }
}

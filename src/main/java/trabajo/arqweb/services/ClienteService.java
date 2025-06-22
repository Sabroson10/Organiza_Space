package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU11;
import trabajo.arqweb.dtos.HU12;
import trabajo.arqweb.entities.Cliente;

import java.util.List;

public interface ClienteService {
    public Cliente insertarCliente(Cliente cliente);
    public List<Cliente> mostrarClientes();
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado);
    public void eliminarCliente(Long id);
    public HU11 verDetalleSuscripcion(Long idCliente);

    List<HU12> listarClientesSinPromocionesUsadas();
}

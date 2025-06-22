package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU11;
import trabajo.arqweb.dtos.HU12;
import trabajo.arqweb.entities.Cliente;
import trabajo.arqweb.entities.Suscripcion;
import trabajo.arqweb.repositories.ClienteRepository;
import trabajo.arqweb.services.ClienteService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente insertarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> mostrarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(clienteActualizado.getNombre());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    @Override
    public HU11 verDetalleSuscripcion(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);

        if (cliente == null || cliente.getSuscripcion() == null) {
            return new HU11(null, null, null, "No tiene suscripción");
        }

        Suscripcion s = cliente.getSuscripcion();
        LocalDate hoy = LocalDate.now();

        String estado = s.getFechaVencimiento().isBefore(hoy) ? "Suscripción vencida" : "Suscripción activa";

        return new HU11(
                s.getNombre(),
                s.getFechaInicio(),
                s.getFechaVencimiento(),
                estado
        );
    }

    @Override
    public List<HU12> listarClientesSinPromocionesUsadas() {
        List<Object[]> resultados = clienteRepository.listarClientesSinPromocionesUsadas();

        return resultados.stream()
                .map(obj -> new HU12(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        (String) obj[2]
                ))
                .toList();
    }

}

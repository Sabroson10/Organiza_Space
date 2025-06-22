package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabajo.arqweb.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    public Authority findByName(String name);
}
//JPA es para traer el crud basico de eliminar, insertar y mostrar y actualizar
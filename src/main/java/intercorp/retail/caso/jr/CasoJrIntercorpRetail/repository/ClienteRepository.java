package intercorp.retail.caso.jr.CasoJrIntercorpRetail.repository;

import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}

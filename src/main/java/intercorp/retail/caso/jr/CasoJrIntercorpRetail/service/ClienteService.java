package intercorp.retail.caso.jr.CasoJrIntercorpRetail.service;

import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.request.ClienteRequest;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.ClienteResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.MensajeResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.OperadorClienteResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse> listaCliente();

    OperadorClienteResponse operadorCliente();

    ResponseEntity<MensajeResponse> crearCliente(ClienteRequest clienteRequest);

}

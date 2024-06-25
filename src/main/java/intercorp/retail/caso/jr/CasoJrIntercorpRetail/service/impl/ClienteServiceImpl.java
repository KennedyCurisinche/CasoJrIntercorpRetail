package intercorp.retail.caso.jr.CasoJrIntercorpRetail.service.impl;

import intercorp.retail.caso.jr.CasoJrIntercorpRetail.mapper.ClienteMapper;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.request.ClienteRequest;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.ClienteResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.MensajeResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.OperadorClienteResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.entity.ClienteEntity;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.repository.ClienteRepository;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.service.ClienteService;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.util.Operador;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.util.impl.OperadorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    private final Operador operador = new OperadorImpl();

    @Override
    public List<ClienteResponse> listaCliente() {
        return clienteRepository.findAll().stream()
                .map(c -> clienteMapper.entityToDto(c))
                .collect(Collectors.toList());
    }

    @Override
    public OperadorClienteResponse operadorCliente() {

        List<Integer> edades = clienteRepository.findAll().stream()
                .map(ClienteEntity::getEdadCliente)
                .toList();

        BigDecimal promedioEdad = operador.promedio(edades.toArray(new Integer[0]));
        BigDecimal divisionEstandar = operador.desviacionEstandar(edades.toArray(new Integer[0]));

        return new OperadorClienteResponse(promedioEdad, divisionEstandar);
    }

    @Override
    public ResponseEntity<MensajeResponse> crearCliente(ClienteRequest clienteRequest) {

        if (clienteRequest != null) {
            clienteRequest.setId(0L);
            clienteRepository.save(clienteMapper.dtoToEntity(clienteRequest));
            return new ResponseEntity<>(new MensajeResponse(true, "Se creo con exito cliente"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MensajeResponse(false, "No se pudo crear cliente"), HttpStatus.OK);
        }

    }

}

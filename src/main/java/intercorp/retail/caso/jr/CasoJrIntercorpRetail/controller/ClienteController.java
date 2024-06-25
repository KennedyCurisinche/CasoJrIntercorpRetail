package intercorp.retail.caso.jr.CasoJrIntercorpRetail.controller;

import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.request.ClienteRequest;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.ClienteResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.MensajeResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.OperadorClienteResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listclientes")
    public ResponseEntity<List<ClienteResponse>> listclientes() {

        try {
            log.info("Consumo en Endpoint 'cliente/listclientes'");
            return new ResponseEntity<>(clienteService.listaCliente(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error en Endpoint 'cliente/listclientes'");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/kpideclientes")
    public ResponseEntity<OperadorClienteResponse> kpideclientes() {

        try {
            log.info("Consumo en Endpoint 'cliente/kpideclientes'");
            return new ResponseEntity<>(clienteService.operadorCliente(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error en Endpoint 'cliente/kpideclientes'");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/creacliente")
    public ResponseEntity<MensajeResponse> creacliente(@RequestBody ClienteRequest clienteRequest) {
        return clienteService.crearCliente(clienteRequest);
    }

}

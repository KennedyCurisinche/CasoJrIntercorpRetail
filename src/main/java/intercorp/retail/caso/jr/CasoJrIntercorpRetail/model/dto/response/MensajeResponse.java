package intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensajeResponse {

    private Boolean estado;
    private String mensaje;

}

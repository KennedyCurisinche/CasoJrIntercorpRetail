package intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperadorClienteResponse {

    private BigDecimal promedioEdad;
    private BigDecimal desviacionEstandarEdad;

}

package intercorp.retail.caso.jr.CasoJrIntercorpRetail.util;

import java.math.BigDecimal;

public interface Operador {

    BigDecimal promedio(Integer... edades);

    BigDecimal desviacionEstandar(Integer... edades);

}

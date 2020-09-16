package cap.curso.mvc.configuracion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import cap.curso.mvc.beans.Movimiento;

// @Configuration
// @ComponentScan({"cap.curso.mvc.beans"})
// @EnableAspectJAutoProxy
public class Configuracion {

    @Bean
    public List<Movimiento> getMovimientos(){
	List<Movimiento> movimientos = new ArrayList<>();
	Movimiento m1 = new Movimiento("01/01/2020", "Ingreso", 100);
	Movimiento m2 = new Movimiento("05/01/2020", "Pago tarjeta", -50);
	Movimiento m3 = new Movimiento("09/01/2020", "recibo luz", -25);
	Movimiento m4 = new Movimiento("15/01/2020", "Ingreso nomina", 5000);
	Movimiento m5 = new Movimiento("21/01/2020", "Compra bici", -1500);

	movimientos.add(m1);
	movimientos.add(m2);
	movimientos.add(m3);
	movimientos.add(m4);
	movimientos.add(m5);
	
	return movimientos;
    }
    
}

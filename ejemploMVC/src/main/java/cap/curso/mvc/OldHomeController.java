package cap.curso.mvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.NodeList;

import cap.curso.mvc.beans.Movimiento;
import cap.curso.mvc.beans.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OldHomeController
{

	private static final Logger logger = LoggerFactory.getLogger(OldHomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/old", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView)
	{

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
		modelAndView.addObject("movimientos", movimientos);

		modelAndView.setViewName("old_home");

		Persona persona=new Persona();
		persona.setUsuario("alumno del curso");
		modelAndView.addObject("persona",persona);
		return modelAndView;
	}
	
	@RequestMapping(value="/old/login",method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(required =true, value="usuario") String usuario,@RequestParam("clave") String clave, ModelAndView modelAndView) {
		
		String resultado="Has escrito el usuario "+usuario+" y la clave "+clave;
		modelAndView.addObject("resultado", resultado);
		modelAndView.setViewName("old_home");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping("/old/prueba/{nombre}/{apellido}")
	public ModelAndView path(@PathVariable("nombre") String nombre, 
		@PathVariable("apellido") String apellido, 
			ModelAndView modelAndView){
		
		modelAndView.setViewName("old_home");
		
		String datos="Tu nombre es "+nombre+ " y tu apellido es "+apellido;
		modelAndView.addObject("datos",datos);
		return modelAndView;
	}
	
	
	@RequestMapping("/old/rellenado")
	public ModelAndView rellenado(ModelAndView   modelAndView, Persona persona) {
		
		System.out.println("usuario:"+ persona.getUsuario());
		System.out.println("clave:"+persona.getClave());
		
		return modelAndView;
	}

}



















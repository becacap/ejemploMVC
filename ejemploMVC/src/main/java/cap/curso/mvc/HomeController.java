package cap.curso.mvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
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
public class HomeController
{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private List<Movimiento> movimientos;
	
	public HomeController()
	{
		movimientos = new ArrayList<>();
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
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView)
	{
		
		modelAndView.addObject("movimientos", movimientos);

		modelAndView.setViewName("home");

		Persona persona=new Persona();
		persona.setUsuario("alumno del curso");
		modelAndView.addObject("persona",persona);
		return modelAndView;
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelAndView) {
		Persona persona=new Persona();
		modelAndView.addObject("persona",persona);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping("/prueba/{nombre}/{apellido}")
	public ModelAndView path(@PathVariable("nombre") String nombre, 
		@PathVariable("apellido") String apellido, 
			ModelAndView modelAndView){
		
		modelAndView.setViewName("home");
		
		String datos="Tu nombre es "+nombre+ " y tu apellido es "+apellido;
		modelAndView.addObject("datos",datos);
		return modelAndView;
	}
	
	
	@RequestMapping("/rellenado")
	public ModelAndView rellenado(ModelAndView   modelAndView, Persona persona) {
		if(persona.getUsuario().contentEquals("admin") 
				&& persona.getClave().contentEquals("12345"))
			modelAndView = home(modelAndView);
		else {
			String datos="Usuario o clave incorrectos. Acceso denegado";
			modelAndView.addObject("datos",datos);
			modelAndView = login(modelAndView);
		}
		
		return modelAndView;
	}

	@RequestMapping("/orderByDate")
	public ModelAndView orderByDate(ModelAndView modelAndView) {

		modelAndView.setViewName("redirect:/home");

		movimientos.sort(new Comparator<Movimiento>() {
		    @Override
		    public int compare(Movimiento o1, Movimiento o2) {
			return o1.getFecha().compareTo(o2.getFecha());
		    }
		});

		return modelAndView;
	    }
	@RequestMapping("/orderByConcept")
	public ModelAndView orderByConcept(ModelAndView modelAndView) {

		modelAndView.setViewName("redirect:/home");

		movimientos.sort(new Comparator<Movimiento>() {
		    @Override
		    public int compare(Movimiento o1, Movimiento o2) {
			return o1.getConcepto().compareTo(o2.getConcepto());
		    }
		});

		return modelAndView;
	    }
	@RequestMapping("/orderByImport")
	public ModelAndView orderByImport(ModelAndView modelAndView) {

		modelAndView.setViewName("redirect:/home");

		movimientos.sort(new Comparator<Movimiento>() {
		    @Override
		    public int compare(Movimiento o1, Movimiento o2) {
			int result = 0;
			int importeA = o1.getImporte();
			int importeB = o2.getImporte();
			if (importeB < importeA)
			    result = -1;
			else if (importeB > importeA)
			    result = 1;

			return result;
		    }
		});

		return modelAndView;
	    }
}



















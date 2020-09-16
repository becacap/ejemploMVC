package cap.curso.mvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
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

	private String usuario;
	private String password;
	private List<Movimiento> movimientos;

	Persona persona;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public HomeController()
	{
		usuario = "";
		password = "";
		movimientos = new ArrayList<>();

		Movimiento m1 = new Movimiento("03/05/2020", "Ingreso", 100);
		Movimiento m2 = new Movimiento("01/01/2020", "Pago tarjeta", -50);
		Movimiento m3 = new Movimiento("09/03/2020", "recibo luz", -25);
		Movimiento m4 = new Movimiento("15/11/2020", "Ingreso nomina", 5000);
		Movimiento m5 = new Movimiento("21/07/2020", "Compra bici", -1500);

		movimientos.add(m1);
		movimientos.add(m2);
		movimientos.add(m3);
		movimientos.add(m4);
		movimientos.add(m5);
		persona = new Persona();
		persona.setUsuario("");
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginGET(ModelAndView modelAndView)
	{

		modelAndView.addObject("persona", persona);
		modelAndView.setViewName("login");

		// Persona persona = new Persona();
		// persona.setUsuario("alumno del curso");
		// modelAndView.addObject("persona", persona);
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(required = true, value = "usuario") String usuario,
			@RequestParam("clave") String clave, ModelAndView modelAndView)
	{

		String logError = "";
		modelAndView.addObject("persona", persona);
		if (usuario.equals("carlos") && clave.equals("1234"))
		{
			modelAndView.addObject("usuario", usuario);
			modelAndView.setViewName("redirect:operations");
			this.usuario = usuario;
			this.password = clave;
		} else
		{
			modelAndView.setViewName("login");
			logError = "El usuario o la contraseña no son correctos";
		}

		modelAndView.addObject("logError", logError);

		return modelAndView;
	}

	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public ModelAndView operations(ModelAndView modelAndView)
	{

		modelAndView.setViewName("operations");

		modelAndView.addObject("movimientos", movimientos);

		Persona persona = new Persona();
		persona.setUsuario("");
		modelAndView.addObject("persona", persona);

		return modelAndView;
	}

	@RequestMapping("/sortDate")
	public ModelAndView sortDate(ModelAndView modelAndView)
	{
		modelAndView.setViewName("redirect:operations");
		movimientos.sort(new Comparator<Movimiento>()
		{
			@Override
			public int compare(Movimiento o1, Movimiento o2)
			{
				return o1.getFecha().compareTo(o2.getFecha());
			}
		});

		return modelAndView;
	}

	@RequestMapping("/sortConcept")
	public ModelAndView sortConcept(ModelAndView modelAndView)
	{
		modelAndView.setViewName("redirect:operations");
		movimientos.sort(new Comparator<Movimiento>()
		{
			@Override
			public int compare(Movimiento o1, Movimiento o2)
			{
				return o1.getConcepto().compareTo(o2.getConcepto());
			}
		});

		return modelAndView;
	}

	@RequestMapping("/sortImportValue")
	public ModelAndView sortImportValue(ModelAndView modelAndView)
	{
		modelAndView.setViewName("redirect:operations");
		movimientos.sort(new Comparator<Movimiento>()
		{
			@Override
			public int compare(Movimiento o1, Movimiento o2)
			{

				int result = 0;
				int iA = o1.getImporte();
				int iB = o2.getImporte();
				if (iA < iB)
					result = -1;
				else
					result = 1;

				return result;
			}
		});

		return modelAndView;
	}

	/*
	 * @RequestMapping("/rellenado") public ModelAndView rellenado(ModelAndView
	 * modelAndView, Persona persona) {
	 * 
	 * 
	 * String logError = "";
	 * 
	 * if (persona.getUsuario().equals("formacion") &&
	 * persona.getClave().equals("1234")) { modelAndView.addObject("usuario",
	 * persona.getUsuario()); modelAndView.setViewName("transacciones"); } else {
	 * modelAndView.setViewName("home"); logError =
	 * "El usuario o la contraseña no son correctos"; }
	 * 
	 * modelAndView.addObject("logError", logError);
	 * 
	 * return modelAndView;
	 * 
	 * }
	 */

	/*
	 * @RequestMapping("/prueba/{nombre}/{apellido}") public ModelAndView
	 * path(@PathVariable("nombre") String nombre,
	 * 
	 * @PathVariable("apellido") String apellido, ModelAndView modelAndView){
	 * 
	 * 
	 * 
	 * modelAndView.setViewName("home");
	 * 
	 * String datos="Tu nombre es "+nombre+ " y tu apellido es "+apellido;
	 * modelAndView.addObject("datos",datos); return modelAndView; }
	 */

}

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
public class HomeController
{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
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

		modelAndView.setViewName("home");

		Persona persona = new Persona();
//		Con esta linea aparece en el formulario del usuario lo que hemos seteado
//		persona.setUsuario("alumno del curso");
		modelAndView.addObject("persona", persona);
		return modelAndView;
	}

//	Con este metodo envias a la vista un objeto persona que se va a tener que rellenar en el login
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView loginGET(ModelAndView modelAndView) {
//		Persona persona = new Persona();
//		modelAndView.addObject(persona);
//		modelAndView.setViewName("login");
//		return modelAndView;
//	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(required = true, value = "usuario") String usuario,
			@RequestParam("clave") String clave, ModelAndView modelAndView)
	{

		boolean loginOK = true;
		List<Movimiento> movs = new ArrayList<>();
		Persona persona = new Persona();
		String mensaje = "";

		persona.setUsuario(usuario);
		persona.setClave(clave);

		Movimiento m1 = new Movimiento("01/02/2020", "Ingreso nomina", 5000);
		Movimiento m2 = new Movimiento("12/01/2020", "recibo agua", -40);
		Movimiento m3 = new Movimiento("09/03/2020", "pago", -100);
		Movimiento m4 = new Movimiento("13/01/2020", "Ingreso", 50);
		Movimiento m5 = new Movimiento("24/01/2020", "compra alimentos", -200);

		movs.add(m1);
		movs.add(m2);
		movs.add(m3);
		movs.add(m4);
		movs.add(m5);
		
		if (persona.getUsuario().equals("") || persona.getClave().equals(""))
		{
			loginOK = false;
		}

		if (loginOK == true)
		{
			mensaje = "Bienvenido " + usuario;
			
		} else
		{
			mensaje = "Usuario o contraseña incorrecta";
			System.out.println(mensaje);
		}
          
		modelAndView.addObject("movs", movs);
		modelAndView.addObject("persona", persona);
		String resultado = "Has escrito el usuario " + persona.getUsuario() + " y la clave " + persona.getClave();
		modelAndView.addObject("mensaje", mensaje);
		
		System.out.println(resultado);
//		Indica en qué página se muestran los objetos, en este caso en la home
		modelAndView.setViewName("login");
		return modelAndView;
	}
	

	@RequestMapping("/prueba/{nombre}/{apellido}")
	public ModelAndView path(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido,
			ModelAndView modelAndView)
	{

		modelAndView.setViewName("home");

		String datos = "Tu nombre es " + nombre + " y tu apellido es " + apellido;
		modelAndView.addObject("datos", datos);
		return modelAndView;
	}

	@RequestMapping("/rellenado")
	public ModelAndView rellenado(ModelAndView modelAndView, Persona persona)
	{

		System.out.println("usuario:" + persona.getUsuario());
		System.out.println("clave:" + persona.getClave());
		modelAndView.setViewName("home");
		return modelAndView;
	}

}

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
import org.springframework.web.servlet.view.RedirectView;
import org.w3c.dom.NodeList;

import cap.curso.mvc.beans.Movimiento;
import cap.curso.mvc.beans.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private String usuario = null;
    private String password = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginGET(ModelAndView modelAndView) {

	modelAndView.setViewName("login");

	return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginRedirectGET(Model model) {

	return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginPOST(@RequestParam(required = false, value = "usuario") String usuario,
	    @RequestParam(value = "password", required = false) String password, ModelAndView modelAndView) {

	if (usuario.equals("cristofer") && password.equals("12345")) {
	    logger.info("Usuario y contraseña correctos");
	    System.out.println("Usuario y contraseña correctos");

	    // String resultado = "Has escrito el usuario " + usuario + " y la clave " +
	    // password;

	    this.usuario = usuario;
	    this.password = password;
	    modelAndView.setViewName("redirect:home");
	    // modelAndView.addObject("resultado", resultado);

	} else {
	    logger.error("Usuario o contraseña incorrectos");
	    System.out.println("Usuario o contraseña incorrectos");

	    String resultado = "Usuario o contraseña incorrectos";

	    modelAndView.setViewName("login");
	    modelAndView.addObject("loginIncorrecto", resultado);
	}

	return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {

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

	modelAndView.setViewName("home");

	modelAndView.addObject("movimientos", movimientos);

	Persona persona = new Persona();
	persona.setUsuario("alumno del curso");
	modelAndView.addObject("persona", persona);

	String resultado = "Has escrito el usuario " + usuario + " y la clave " + password;
	modelAndView.addObject("resultado", resultado);

	return modelAndView;
    }

    /*
     * @RequestMapping("/prueba/{nombre}/{apellido}") public ModelAndView
     * path(@PathVariable("nombre") String nombre, @PathVariable("apellido") String
     * apellido, ModelAndView modelAndView) {
     * 
     * modelAndView.setViewName("home");
     * 
     * String datos = "Tu nombre es " + nombre + " y tu apellido es " + apellido;
     * modelAndView.addObject("datos", datos); return modelAndView; }
     * 
     * @RequestMapping("/rellenado") public ModelAndView rellenado(ModelAndView
     * modelAndView, Persona persona) {
     * 
     * System.out.println("usuario:" + persona.getUsuario());
     * System.out.println("clave:" + persona.getClave());
     * 
     * return modelAndView; }
     */

}

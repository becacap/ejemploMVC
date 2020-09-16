package cap.curso.mvc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cap.curso.mvc.beans.Movimiento;
import cap.curso.mvc.beans.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private String usuario;
    private String password;
    private List<Movimiento> movimientos;

    public HomeController() {
	usuario = null;
	password = null;
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

    public void setMovimientos(List<Movimiento> movimientos) {
	this.movimientos = movimientos;
    }

    /***********************************************************************************************************/
    // LOGIN

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginGET(ModelAndView modelAndView) {

	modelAndView.setViewName("login");

	// se añade este objeto para rellenarlo en el jsp con el formulario de spring
	modelAndView.addObject("persona", new Persona());

	return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginRedirectGET(Model model) {

	return "redirect:/";
    }

    // CON FORMULARIOS DE HTML5
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginPOST(@RequestParam(required = false, value = "usuario") String usuario,
	    @RequestParam(value = "password", required = false) String password, ModelAndView modelAndView) {

	if (usuario.equals("cristofer") && password.equals("12345")) {
	    logger.info("Usuario y contraseña correctos");
	    System.out.println("Usuario y contraseña correctos");

	    modelAndView.setViewName("redirect:home");

	    this.usuario = usuario;
	    this.password = password;

	} else {
	    logger.error("Usuario o contraseña incorrectos");
	    System.out.println("Usuario o contraseña incorrectos");

	    String resultado = "Usuario o contraseña incorrectos";

	    modelAndView.setViewName("login");
	    modelAndView.addObject("loginIncorrecto", resultado);
	}

	return modelAndView;
    }

    // CON FORMULARIOS DE SPRING
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public ModelAndView loginPOST2(Persona persona, ModelAndView modelAndView) {

	if (persona.getUsuario().equals("cristofer") && persona.getClave().equals("12345")) {
	    logger.info("Usuario y contraseña correctos");

	    modelAndView.setViewName("redirect:home");

	    this.usuario = persona.getUsuario();
	    this.password = persona.getClave();

	} else {
	    logger.error("Usuario o contraseña incorrectos");

	    String resultado = "Usuario o contraseña incorrectos";

	    modelAndView.setViewName("login");
	    modelAndView.addObject("loginIncorrecto", resultado);
	}

	return modelAndView;
    }

    /***********************************************************************************************************/
    // HOME

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {

	modelAndView.setViewName("home");

	modelAndView.addObject("movimientos", movimientos);

	Persona persona = new Persona();
	persona.setUsuario("alumno del curso");
	modelAndView.addObject("persona", persona);

	String resultado = "Has escrito el usuario " + usuario + " y la clave " + password;
	modelAndView.addObject("resultado", resultado);

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

    /***********************************************************************************************************/

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

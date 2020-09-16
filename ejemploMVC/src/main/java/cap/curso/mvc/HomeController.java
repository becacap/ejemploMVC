package cap.curso.mvc;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

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
	private int login = 0; // 0 si no ha iniciado sesion 1 si se ha iniciado.
	private List<Movimiento> movimientos = new ArrayList<>();
	private ModelAndView modelAndView = new ModelAndView();

	
	public HomeController()
	{
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
//	##########   HOME  #######################
	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException
	{
		if (login == 0)
		{
			modelAndView.setViewName("login");

		} else
		{
			modelAndView.setViewName("redirect:/home");
		}
		return modelAndView;
	}
//	##########   LOGIN CHECK #######################
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(required = true, value = "usuario") String usuario,
			@RequestParam(required = true, value = "clave") String clave, ModelAndView modelAndView)
	{

		String key = "1234";
		if (usuario.equals(key) && clave.equals(key))
		{
			login = 1;
			modelAndView.setViewName("redirect:home");
		} else
		{
			modelAndView.addObject("resultado", "Usuario Y/O contraseña incorrectos.");
			modelAndView.setViewName("login");
		}

		return modelAndView;
	}
//	##########   INICIADO  #######################
	@RequestMapping("/home")
	public ModelAndView home(ModelAndView modelAndView, Persona persona)
	{
		Persona pers = new Persona();
		pers.setUsuario("nombre prueba");
		modelAndView.addObject("persona", pers);
		modelAndView.addObject("movimientos", movimientos);
		modelAndView.setViewName("home");
		return modelAndView;
	}
//	##########   logout  #######################
	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView modelAndView)
	{
		login=0;
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	@RequestMapping("/rellenado")
	public ModelAndView relleno(ModelAndView modelAndView, Persona persona)
	{
		System.out.println(persona.getUsuario() + " " + persona.getClave());
		modelAndView.setViewName("home");
		return modelAndView;
	}
//	##########   sortFecha  #######################
	@RequestMapping("/sfecha")
	public ModelAndView sortFecha(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:home");
		
		movimientos.sort(new Comparator<Movimiento>() {
			  @Override
			  public int compare(Movimiento u1, Movimiento u2) {
			    return u1.getFecha().compareTo(u2.getFecha());
			  }
			});
		return modelAndView;
		
	}
	
//	##########   sortConcepto  #######################
	@RequestMapping("/sconcepto")
	public ModelAndView sortConcepto(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:home");
		movimientos.sort(new Comparator<Movimiento>() {
			  @Override
			  public int compare(Movimiento u1, Movimiento u2) {
			    return u1.getConcepto().compareTo(u2.getConcepto());
			  }
			});
		return modelAndView;
		
	}
	
//	##########   sortImporte  #######################
	@RequestMapping("/simporte")
	public ModelAndView sortImporte(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:home");
		movimientos.sort(new Comparator<Movimiento>() {
			  @Override
			  public int compare(Movimiento u1, Movimiento u2) {
			    return u1.getImporte()-(u2.getImporte());
			  }
			});
		return modelAndView;
		
	}
}
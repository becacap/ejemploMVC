package cap.curso.mvc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cap.curso.mvc.beans.Movimiento;

@Controller
public class HomeController
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// I should not be possible to get into home if the user writes the home path in the browser
	@RequestMapping (value = "/home", method = RequestMethod.GET)
	public ModelAndView homeGet (ModelAndView modelAndView) {
		return new ModelAndView("redirect home" + "/");
		
	}
	
	@RequestMapping (value = "/home", method = RequestMethod.POST)
	public ModelAndView homePost (
			ModelAndView modelAndView, 
			@RequestParam(required = true, defaultValue = "test", value = "user") String user, 
			@RequestParam(required = true, defaultValue = "test", value = "pass") String pass) {
		
		modelAndView.addObject ("user", user);
		modelAndView.addObject ("pass", pass);
		
		modelAndView = fakeMovimientosData (modelAndView);
		
		modelAndView.setViewName("home");
		
		return modelAndView;
	}
	
	private ModelAndView fakeMovimientosData (ModelAndView modelAndView) {
		
		Movimiento m1 = new Movimiento( "12/03/2020", "Compritas"		, - 200 );
		Movimiento m2 = new Movimiento( "12/03/2020", "Retirada cajero"	, -  50 );
		Movimiento m3 = new Movimiento( "12/03/2020", "Ingreso cajero"	, + 360 );
		Movimiento m4 = new Movimiento( "12/03/2020", "CapSueldo"		, +2300 );
		Movimiento m5 = new Movimiento( "12/03/2020", "Otros"			, -  25);
		
		List<Movimiento> movimientos = new ArrayList<>();
		movimientos.add(m1);
		movimientos.add(m2);
		movimientos.add(m3);
		movimientos.add(m4);
		movimientos.add(m5);
		
		modelAndView.addObject ("movimientos", movimientos);
		
		return modelAndView;
	}
}

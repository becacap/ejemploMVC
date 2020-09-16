package cap.curso.mvc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cap.curso.mvc.beans.Movimiento;
import cap.curso.mvc.beans.Persona;

@Controller
public class LoginController
{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping (value = "/", method = RequestMethod.GET)
	public ModelAndView login (ModelAndView modelAndView) {

		modelAndView.setViewName ("login");
		
		return modelAndView;
	}
}

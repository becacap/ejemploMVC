package cap.curso.mvc.configuracion;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class MvcAppWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
	
		return new Class<?>[] {AppServletConfiguration.class};
	}

	@Override
	protected String[] getServletMappings()
	{
		
		return new String[] {"/"};
	}

}

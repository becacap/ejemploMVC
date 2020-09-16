package cap.curso.mvc.beans;

import java.util.List;

public class Cuenta
{
	
	private String nombre;
	private String dni;
	private List<Movimiento> movimientos;
	
	
	public Cuenta(String nombre, String dni, List<Movimiento> movimientos)
	{
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.movimientos = movimientos;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getDni()
	{
		return dni;
	}
	public void setDni(String dni)
	{
		this.dni = dni;
	}
	public List<Movimiento> getMovimientos()
	{
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos)
	{
		this.movimientos = movimientos;
	}
	
	

}

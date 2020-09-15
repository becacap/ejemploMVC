package cap.curso.mvc.beans;

public class Movimiento
{
	private String fecha,concepto;
	private int importe;
	
	public Movimiento(String fecha, String concepto,int importe) {
		this.fecha=fecha;
		this.concepto=concepto;
		this.importe=importe;
	}
	public String getFecha()
	{
		return fecha;
	}
	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}
	public String getConcepto()
	{
		return concepto;
	}
	public void setConcepto(String concepto)
	{
		this.concepto = concepto;
	}
	public int getImporte()
	{
		return importe;
	}
	public void setImporte(int importe)
	{
		this.importe = importe;
	}

}

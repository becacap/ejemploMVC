package cap.curso.mvc.beans;

public class Movimiento
{
	private String fecha,concepto;
	private int importe;
	private char debe, haber;
	
	public char getDebe()
	{
		return debe;
	}
	public void setDebe(char debe)
	{
		this.debe = debe;
	}
	public char getHaber()
	{
		return haber;
	}
	public void setHaber(char haber)
	{
		this.haber = haber;
	}
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

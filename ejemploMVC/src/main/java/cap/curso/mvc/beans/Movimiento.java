package cap.curso.mvc.beans;



public class Movimiento
{
private String fecha,concepto;
private int importe;

public Movimiento(String fecha, String concepto, int importe)
{
	this.setFecha(fecha);
	this.setConcepto(concepto);
	this.setImporte(importe);
}

public String getConcepto()
{
	return concepto;
}

public void setConcepto(String concepto)
{
	this.concepto = concepto;
}

public String getFecha()
{
	return fecha;
}

public void setFecha(String fecha)
{
	this.fecha = fecha;
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

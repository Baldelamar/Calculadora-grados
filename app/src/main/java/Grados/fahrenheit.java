package Grados;

public class fahrenheit extends grado
{
    public fahrenheit parse(celcius c)
    {
        Double valor = (c.getValor()*9/5)+32;
        fahrenheit fa= new fahrenheit();
        fa.setValor(valor);
        fa.setUnidad("F");
        return fa;
    }

    public fahrenheit parse(kelvin k)
    {
        Double valor = ((k.getValor()-273.15)*9/5)+32;
        fahrenheit fa = new fahrenheit();
        fa.setValor(valor);
        fa.setUnidad("K");
        return fa;
    }
}


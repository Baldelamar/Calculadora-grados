package Grados;

public class celcius extends grado{

    // ESTO DEBE DEVOLVER UN CELCIUS METODO PARSE, Y DE PARAMETRO LLEVO UN FARHENHEIT

    public celcius parse(fahrenheit f)
    {
        Double valor = (f.getValor()-32)*5/9;
        celcius ce = new celcius();
        ce.setValor(valor);
        ce.setUnidad("C");
        return ce;
    }

    public celcius parse(kelvin k)
    {
        Double valor = (k.getValor()-273.15);
        celcius ce = new celcius();
        ce.setValor(valor);
        ce.setUnidad("C");
        return ce;
    }
}

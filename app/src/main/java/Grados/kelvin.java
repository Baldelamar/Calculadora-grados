package Grados;

public class kelvin extends grado{

    public kelvin parse(celcius c){

        Double valor = (c.getValor()+273.15);
        kelvin ke = new kelvin();
        ke.setValor(valor);
        ke.setUnidad("K");
        return ke;
    }

    public kelvin parse(fahrenheit f){

        Double valor = (((f.getValor()-32)*5/9)+273.15);
        kelvin ke = new kelvin();
        ke.setValor(valor);
        ke.setUnidad("K");
        return ke;
    }
}

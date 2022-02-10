package Clases;

import java.util.Scanner;

public class UtilidadesPersona {

    public static double convertirGramosKilos(int gramos) {
        double kilogramos =(double) gramos/1000;
        return kilogramos;
    }

    public static double convertirCentimetrosMetros(int centimetros) {
        double metros =(double) centimetros/100;
        return metros;
    }

    public static double calcularImc(Persona persona){

        double kilos = UtilidadesPersona.convertirGramosKilos(persona.getPesoGramos());
        double metros = UtilidadesPersona.convertirCentimetrosMetros(persona.getAlturaCm());

        double imc = kilos /(Math.pow(metros, 2));
        return (Math.round(imc*100)/100d);
    }


}

package Clases;

import Enums.Genero;

import java.util.ArrayList;

public class GestionPersonas {

    private ArrayList<Persona> listaPersonas;

    public GestionPersonas() {
        this.listaPersonas = new ArrayList<>();
    }


    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    /**
     * Método que sirve par aintroducir una persona en la lista de personas
     *
     * @param persona
     * @return
     */
    public boolean introducirPersona(Object persona) {
        boolean resultado = false;
        if (persona instanceof Persona) {
            this.listaPersonas.add((Persona) persona);
            resultado = true;
        }
        return resultado;
    }


    /**
     * Mñétodo que sirve para eliminar una persona
     *
     * @param id
     * @return
     */
    public boolean borrarPersona(int id) {
        boolean resultado = false;

        for (int i = 0; i < listaPersonas.size() && !resultado; i++) {
            if (id == listaPersonas.get(i).getId()) {
                listaPersonas.remove(i);
            }
        }
        return resultado;
    }


    public double mediaPeso() {
        int sumaPesosGr = 0;
        double mediaPesoKg;

        for (Persona persona : listaPersonas){
            sumaPesosGr += persona.getPesoGramos();
        }
        mediaPesoKg = UtilidadesPersona.convertirGramosKilos((sumaPesosGr/ listaPersonas.size()));

        return mediaPesoKg;
    }

    public double mediaAltura() {
        int sumaAlturaCm = 0;
        double mediaAlturaMetros;

        for (Persona persona : listaPersonas){
            sumaAlturaCm += persona.getAlturaCm();
        }
        mediaAlturaMetros = UtilidadesPersona.convertirCentimetrosMetros((sumaAlturaCm/ listaPersonas.size()));

        return mediaAlturaMetros;
    }


    /**
     *
     * @return
     */
    public int mediaEdad() {
        int sumaEdad = 0;
        int mediaEdad;


        for (Persona persona : listaPersonas){
            sumaEdad += persona.getEdad();
        }
        mediaEdad = sumaEdad/ listaPersonas.size();

        return mediaEdad;
    }

    /**
     *
     * @return
     */
    public String mediaSexo() {
    String mediaSexo = Genero.O.valor;
    int sumaHombres = sumaPersonas(1);
    int sumaMujeres = sumaPersonas(0);
    if(sumaHombres > sumaMujeres){
        mediaSexo = Genero.H.valor;
    }else if(sumaMujeres > sumaHombres){
        mediaSexo = Genero.M.valor;
    }
    return mediaSexo;
    }

    public int sumaPersonas(int eleccion) {
        int sumaMujeres = 0;
        int sumaHombres = 0;
            for (Persona persona : listaPersonas) {
                if(persona.getGenero() == Genero.H){
                    sumaHombres++;
                }
                else if(persona.getGenero() == Genero.M){
                    sumaMujeres++;
                }
            }
        if(eleccion == 1){
            return sumaHombres;
        }else{
            return sumaMujeres;
        }
    }



}

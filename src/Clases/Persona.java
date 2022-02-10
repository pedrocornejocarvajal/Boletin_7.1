package Clases;

import Enums.*;

import java.util.Objects;


public class Persona implements Comparable, Cloneable {

    //atributos

    private int id;
    private String nombre;
    private int edad;
    private String dni;
    private int pesoGramos;
    private int alturaCm;
    private Genero genero;


    //Constructores

    public Persona(int id, String nombre, int edad, String dni, int pesoGramos, int alturaCm, Genero genero) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.pesoGramos = pesoGramos;
        this.alturaCm = alturaCm;
        this.genero = genero;
    }

    public Persona() {
    }

    public Persona(Persona persona) {
        this.id = persona.id;
        this.nombre = persona.nombre;
        this.edad = persona.edad;
        this.dni = persona.dni;
        this.pesoGramos = persona.pesoGramos;
        this.alturaCm = persona.alturaCm;
        this.genero = persona.genero;
    }


    //Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(int pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public boolean mayorEdad() {

        boolean esMayor = false;

        if (edad > 18) {
            esMayor = true;
        }
        return esMayor;
    }

    public int pesoIdeal() {
        int resultado = -1;
        double imc = UtilidadesPersona.calcularImc(this);
        if (imc >= 18.5 && imc <= 24.9) {
            resultado = 0;

        } else if (imc > 24.9) {
            resultado = 1;
        }
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && pesoGramos == persona.pesoGramos && alturaCm == persona.alturaCm && Objects.equals(nombre, persona.nombre) && Objects.equals(dni, persona.dni) && genero == persona.genero;
    }

    @Override
    public int compareTo(Object o) {
        int resultado = 0;
        boolean salir = false;
        if (this.getClass() == o.getClass()) {
            for (int i = 0; i < ((Persona) o).getNombre().length() && !salir; i++) {
                resultado = -1;
                if (this.getNombre().charAt(i) > ((Persona) o).getNombre().charAt(i)) {
                    resultado = 1;
                }
                else if(this.getNombre().charAt(i) == ((Persona) o).getNombre().charAt(i)){
                    resultado = 0;
                }
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Persona{" + "\n" +
                "Nombre = " + nombre + "\n" +
                "Edad = " + edad + "\n" +
                "DNI = " + dni + "\n" +
                "Peso = " + UtilidadesPersona.convertirGramosKilos(pesoGramos) + "\n" +
                "Altura = " + UtilidadesPersona.convertirCentimetrosMetros(alturaCm) + "\n" +
                "Genero = " + genero + "\n" +
                '}';
    }
}

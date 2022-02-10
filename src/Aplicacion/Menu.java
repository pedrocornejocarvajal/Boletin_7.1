package Aplicacion;

import Clases.GestionPersonas;
import Clases.Persona;
import Clases.UtilidadesPersona;
import Enums.Genero;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    
    public static final String ERROR_GENERO = "Tu eleccion no es un género reconocido";
    public static final String MENSAJE_BIENVENIDO = "Bienvenido! \n \n \n \n";

    public static final String ERROR_404 = "No se encontro el comando entre las opciones posibles.\n" +
            "Inténtelo de nuevo";
    public static final String MENU_PRINCIPAL = "Elige entre una de las opciones  \n" +
            "1 -> Crear una persona  \n" +
            "2 -> Mostrar indice de masa corporal  \n" +
            "3 -> Mostrar opciones de medias \n" +
            "0 -> Salir";
    public static final String SUB_MENU_MEDIAS = "Elige entre una de las opciones de medias \n" +
            "1 -> Peso medio de todas las personas registradas \n" +
            "2 -> Altura media de tosas las personas registradas \n" +
            "3 -> Edad media de todas las personas registradas  \n" +
            "4 -> Sexo más abundante \n" +
            "5 -> Cuantas de las personas fueron Mujeres  \n" +
            "6 -> Cuantas de las personas fueron Hombres \n" +
            "0 -> Salir";
    public static final String MENSAJE_ERROR_NUM = "Eso no es un número";
    public static final String ESTAS_SEGURO = "¿Estás seguro de tu elección? \n" +
            "1 -> Sí \n" +
            "2 -> No";
    public static final String PEDIR_GENERO = "Introduce tu genero.\n" +
            "1-> Hombre \n" +
            "2 -> Mujer \n" +
            "0 -> Otros";
    public static final String PEDIR_DNI = "Introduce tu DNI si quieres ganar 0,15€ en Bitcoin";
    public static final String PEDIR_NOMBRE = "Introduce tu nombre";
    public static final String PEDIR_EDAD = "Introduce tu edad";
    public static final String PEDIR_ALTURA = "Introduce tu altura en cm";
    public static final String PEDIR_PESO = "Introduce tu peso en gramos";
    public static final String IMC_PERFECTO = "Su índice de masa corporal esta en las medidas recomendadas";
    public static final String IMC_BAJO = "Su índice de masa corporal esta por debajo de las medidas recomendadas";
    public static final String IMC_ALTO = "Su índice de masa corporal esta por encima de las medidas recomendades";
    public static final String PREGUNTA_IMC = "Escribe el nombre de la persona a calcular su IMC";

    private GestionPersonas personas;

    public Menu() {
        personas = new GestionPersonas();

    }


    public void menuPrincipal(Scanner sc) {

        boolean salir = false;
        String eleccion;
        do {
            eleccion = pedir(sc, MENU_PRINCIPAL);
            switch (eleccion) {
                case "1" -> {
                    construirPersona(sc);
                }
                case "2" -> {
                    System.out.println("Su índice de masa Corporal es: "+calcularIMC(sc));
                }
                case "3" -> {
                    subMenuMedias(sc);
                }
                case "0" -> {
                    salir = true;
                }
                default -> {
                    System.out.println(ERROR_404);
                }
            }
        } while (!salir);
    }


    public void subMenuMedias(Scanner sc) {
        boolean salir = false;
        String eleccion;
        do {
            eleccion = pedir(sc, SUB_MENU_MEDIAS);
            switch (eleccion) {
                case "1" -> {
                    pesoMedio();
                }
                case "2" -> {
                    alturaMedia();
                }
                case "3" -> {
                    edadMedia();
                }
                case "4" -> {
                    sexoAbunda();
                }
                case "5" -> {
                    mostrarMujeres();
                }
                case "6" -> {
                    mostrarHombres();
                }
                case "0" -> {
                    salir = true;
                }
                default -> {
                    System.out.println(ERROR_404);
                }
            }
        } while (!salir);
    }


    public void pesoMedio() {
        System.out.println("El peso medio es : " + personas.mediaPeso());
    }

    public void alturaMedia() {
        System.out.println("La altura media es : " + personas.mediaAltura());
    }

    public void edadMedia() {
        System.out.println("La edad media es : " + personas.mediaEdad());
    }

    public void sexoAbunda() {
        System.out.println("El sexo más abunante es : " + personas.mediaSexo());
    }

    public void mostrarHombres() {
        System.out.println("El número de hombres registrados es : " + personas.sumaPersonas(1));
    }

    public void mostrarMujeres() {
        System.out.println("El número de mujeres registradas es : " + personas.sumaPersonas(2));
    }


    /**
     * @param sc
     * @return
     */
    public double calcularIMC(Scanner sc) {
        double imc = 0;
        String eleccion = "";
        boolean salir = false;
        for(Persona persona : personas.getListaPersonas()){
            System.out.println(persona);
        }
        do {
            eleccion = pedir(sc, PREGUNTA_IMC);
            for (int i = 0; i < personas.getListaPersonas().size() && !salir; i++) {
                if (eleccion.toLowerCase().equals(personas.getListaPersonas().get(i).getNombre().toLowerCase())) {
                    imc = UtilidadesPersona.calcularImc(personas.getListaPersonas().get(i));
                    switch (personas.getListaPersonas().get(i).pesoIdeal()) {
                        case 1:
                            System.out.println(IMC_ALTO);
                            break;
                        case -1:
                            System.out.println(IMC_BAJO);
                            break;
                        case 0:
                            System.out.println(IMC_PERFECTO);
                    }
                    salir = true;
                }
            }
        } while (!salir);
        return imc;
    }


    /**
     * @param sc
     * @return
     */
    public Persona construirPersona(Scanner sc) {
        Persona p = new Persona();

        boolean seguro = true;
        do {
            p.setNombre(pedir(sc, PEDIR_NOMBRE));


            while (p.getEdad() == 0) {
                try {
                    p.setEdad(Integer.parseInt(pedir(sc, PEDIR_EDAD)));
                } catch (Exception e) {
                    System.out.println(MENSAJE_ERROR_NUM);
                }
            }
            p.setDni(pedir(sc, PEDIR_DNI));
            while (p.getPesoGramos() == 0) {
                try {
                    p.setPesoGramos(Integer.parseInt(pedir(sc, PEDIR_PESO)));
                } catch (Exception e) {
                    System.out.println(MENSAJE_ERROR_NUM);
                }
            }
            while (p.getAlturaCm() == 0) {
                try {
                    p.setAlturaCm(Integer.parseInt(pedir(sc, PEDIR_ALTURA)));
                } catch (Exception e) {
                    System.out.println(MENSAJE_ERROR_NUM);
                }
            }
            p.setGenero(introducirGenero(sc));
            System.out.println("Se ha generado la " + p);
            String petision;
            do {
                petision = pedir(sc, ESTAS_SEGURO);
                if (Objects.equals(petision, "1")) {
                    seguro = true;
                } else {
                    seguro = false;
                }
            } while (!petision.equals("1"));

        }
        while (!seguro);
        personas.introducirPersona(p);
        return p;
    }


    public static Genero introducirGenero(Scanner sc) {
        boolean salir = false;
        String eleccion;
        Genero genero = null;
        do {
            eleccion = pedir(sc, PEDIR_GENERO);
            

                switch (eleccion) {
                    case "1" -> {
                        genero = Genero.H;
                        salir = true;
                    }
                    case "2" -> {
                        genero = Genero.M;
                        salir = true;
                    }
                    case "0" -> {
                        genero = Genero.O;
                        salir = true;
                    }
                    default -> {
                        System.out.println(ERROR_GENERO);
                    }
                }
            
        } while (!salir);
        return genero;
    }

    public static String pedir(Scanner sc, String petision) {
        System.out.println(petision);
        return sc.nextLine();
    }


}

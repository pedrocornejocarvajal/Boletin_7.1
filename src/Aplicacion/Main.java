package Aplicacion;

import Clases.GestionPersonas;
import Clases.Persona;
import Clases.UtilidadesPersona;
import Enums.Genero;

import java.util.Scanner;

import static Enums.Genero.H;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.menuPrincipal(sc);
    }
}

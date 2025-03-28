package ui;

import java.util.Scanner;

public class Guacamaya {

    // Scanner global para todo el programa
    public static Scanner escaner;
    // Arreglos de precios y unidades para todo el programa
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        escaner = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\n# Digite la opcion a ejecutar");
            System.out.print("> ");
            int opcion = escaner.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\n# La cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\n# El precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\n# Las ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\n# Digite el limite minimo de ventas a analizar");
                    double limite = escaner.nextDouble();
                    System.out.print("> ");
                    System.out.println("\n# De las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    System.out.print("\n");
                    salir = true;
                    escaner.close();
                    break;

                default:
                    System.out.println("\n# Opcion invalida, intenta nuevamente. #");
                    break;
            }

        } while (!salir);

    }

    /*
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\n# Digite el numero de referencias de producto diferentes vendidas en el dia ");
        System.out.print("> ");
        int referencias = escaner.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }

    /*
     * Descripcion: Este metodo va a solicitar los datos de las referencias vendidas, los datos son las unidades y el precio de cada una de las referencias
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void solicitarDatos(){
          
        System.out.println("\n# Digite el numero de referencias de producto diferentes vendidas en el dia:");
        System.out.print("> ");
        int referencias = escaner.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

        for (int i = 0; i < referencias; i++) {
            System.out.println("\n# Ingrese el precio de la referencia " + (i + 1) + ":");
            System.out.print("> ");
            double precio = escaner.nextDouble();

            precios [i] = precio;

            System.out.println("\n# Ingrese la cantidad de unidades vendidas de la referencia " + (i + 1) + ":");
            System.out.print("> ");
            int unidad = escaner.nextInt();

            unidades [i] = unidad;
        }
    }


    /*
     * Descripcion: Este metodo calcula el total de las unidades vendidas en el dia
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     * @return int univendidas
     */
    public static int calcularTotalUnidadesVendidas(){

    int univendidas = 0;
        for (int i = 0; i < unidades.length; i++) {
            univendidas += unidades[i];
        }
        return univendidas;

    }

    /*
     * Descripcion: Este metodo calcula el promedio de los precios en el dia
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     * @return double prom
     */
    public static double calcularPrecioPromedio(){
    
    double prom = 0;
        for (int i = 0; i < precios.length; i++) {
            prom += precios[i];
        }
        return prom / precios.length ;


    }

    /*
     * Descripcion: Este metodo calcula las ventas totales en el dia 
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     * @return double ventastot
     */
    public static double calcularVentasTotales(){

    double ventastot = 0;
        for (int i = 0; i < precios.length; i++) {
            ventastot += precios[i] * unidades[i];
        }
        return ventastot;

    }

    /*
     * Descripcion: Este metodo averigua cuales de los productos vendidos supera el limite puesto en el dia 
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     * @return int limref
     */
    public static int consultarReferenciasSobreLimite(double limite){
    
    int limref = 0;
        for (int i = 0; i < precios.length; i++) {

            if ((precios[i] * unidades[i]) >= limite) {
                limref++;
            }

        }
        return limref;
    }

}

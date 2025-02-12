package com.egg.estancias.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    CasaService casaService = new CasaService();
    FamiliaService familiaService = new FamiliaService();

    public void iniciarMenu() {
        do {
            try {
                System.out.println("""
                        ----- MENÚ DE OPCIONES -----
                        1. LIstar familias con hijos
                        2. Listas familias con Hotmail
                        3. Buscar casas disponibles en UK
                        4. Buscar casas disponibles por fecha y duracion
                        0. Salir
                        Seleccione una opción:
                        """);

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        familiaService.listarFamiliasConHijosMenoresA10().forEach(System.out::println);
                        break;
                    case 2:
                        familiaService.listarFamiliasConHotmail().forEach(System.out::println);
                        break;
                    case 3:
                    casaService.listarCasasDisponiblesReinoUnido().forEach(System.out::println);
                    break;
                    case 4:
                    System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
                    String fechaInicio = scanner.nextLine();
                    System.out.println("Ingrese la duración en días:");
                    int duracion = scanner.nextInt();
                    scanner.nextLine();
                    casaService.listarCasasDisponiblesPorFecha(fechaInicio, duracion).forEach(System.out::println);
                    break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida, intenta de nuevo.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                opcion = -1;
                scanner.nextLine();
            }
        } while (opcion != 0);
        scanner.close();
    }
}

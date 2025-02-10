/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.echoofshadows;

import com.mycompany.echoofshadows.exceptions.ExceptionMenu;
import java.util.Scanner;
import objetos.Juego;

/**
 *
 * @author Yamila Cazalla Recio
 */
public class EchoOfShadows {

    public static void main(String[] args) {
        
        Juego juego = new Juego();
    }
        /*
        int respuesta;
        boolean salir = false;
        final int NUEVA_PARTIDA = 1, CONTINUAR_PARTIDA = 2, CONFIG_JUEGO = 3,
                SALIR_JUEGO = 4;
        do {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("---- Menú inicial ----"
                    + "\n\t\tNueva partida"
                    + "\n\t\tContinuar"
                    + "\n\t\tConfiguración"
                    + "\n\t\tSalir"
                    + "\nRespuesta: ");

            try {
                if (sc.hasNextInt()) {
                    respuesta = sc.nextInt();
                } else {
                    throw new Exception("ERROR. Respuesta inválida."
                            + "\nResponde de nuevo: ");
                }

                switch (respuesta) {
                    case NUEVA_PARTIDA:
                        Juego juego = new Juego();
                        break;
                    case CONTINUAR_PARTIDA:
                        break;
                    case CONFIG_JUEGO:
                        break;
                    case SALIR_JUEGO:
                        salir = true;
                        break;
                    default:
                        throw new ExceptionMenu("ERROR. Opción del menú inexistente.");
                }
            } catch (ExceptionMenu e) {
                System.err.println(e);
            } catch (Exception e) {
                System.err.print(e);
            }

        } while (!salir);

    }

    public static void Partida() {

        System.out.println("Zzzzzzzzzz..."
                + "\nZzzzzzz..."
                + "\nZzz..."
                + "\n!!!!!"
                + "\n*Susto por pesadilla*"
                + "\nKian se despierta encima de una montaña de zapatos,"
                + " situada al fondo de un callejón sombrío.");

    }
    */
}

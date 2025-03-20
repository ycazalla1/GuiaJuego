/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Yamila Cazalla Recio
 */
public class Constantes {

    public static class Direcciones {
        public static final int IZQUIERDA = 0, ARRIBA = 1, DERECHA = 2, ABAJO = 3;
    }
    
    public static class ConstantJugador {
        public static final int QUIETO = 0, CORRER = 1, SALTAR = 2, CAER = 3,
                                SUELO = 4, GOLPE = 5, ATAQUE = 6,
                                ATAQUE_SALTO_1 = 7, ATAQUE_SALTO_2 = 8;
        
        public static int getAnimacion(int accion) {
            
            switch (accion) {
                case CORRER:
                    return 6;
                case QUIETO:
                    return 5;
                case SALTAR:
                case CAER:
                case SUELO:
                    return 2;
                case GOLPE:
                    return 4;
                case ATAQUE:
                case ATAQUE_SALTO_1:
                case ATAQUE_SALTO_2:
                    return 3;
                default:
                    return 1;
            }
        }
        
    }

}

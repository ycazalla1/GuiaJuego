/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author ycaza
 */
public class Mapa {
    
    //Array para determinar el tamaño del mapa según la fase del juego
    private int[] habitaciones;
    int posicion;
    
    public void PrimeraParte() {
        this.habitaciones = new int[9];
    }
    
    public void SegundaParte() {
        this.habitaciones = new int[6];
    }
    
    public void TerceraParte() {
        this.habitaciones = new int[6];
    }
    
    final String izq = "izquierda", der = "derecha";
    
    public void cambiarHabitacion(String lado) {
        
        if (lado.equalsIgnoreCase(izq)) {
            for (int i = posicion; i > (posicion-1); i--) {
                posicion --;
            }
        }
        
        if (lado.equalsIgnoreCase(der)) {
            for (int i = posicion; i > (posicion+1); i++) {
                posicion ++;
            }
        }
        
    }
    
}

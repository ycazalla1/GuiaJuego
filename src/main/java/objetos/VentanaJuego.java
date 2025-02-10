/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import javax.swing.JFrame;

/**
 *
 * @author Yamila Cazalla Recio
 */
public class VentanaJuego {
    
    private JFrame jframe;
    
    public VentanaJuego() {
        
        jframe = new JFrame();
        
        jframe.setSize(400, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**
         * Se pone debajo para que no de error, porque si se pone encima
         * puede pasar que cuando se redimensione la ventana no se vea el juego.
         */
        jframe.setVisible(true);
        
    }
    
}

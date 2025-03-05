/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import javax.swing.JFrame; //Importar el JFrame

/**
 *
 * @author Yamila Cazalla Recio
 */
public class VentanaJuego {
    
    private JFrame jframe; //Crear variable JFrame
    
    public VentanaJuego(PanelJuego panelJuego) {
        
        jframe = new JFrame(); //Crear objeto JFrame
        
        
        
        //Finalizar el programa cuando se cierre la ventana
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jframe.add(panelJuego); //Esto es para ensamblar la ventana del juego con el panel (imágen)
        jframe.setLocationRelativeTo(null); //Hace que aparezca en el centro de la pantalla
        
        //Para que no pueda el usuario redimensionar la ventana de juego
        jframe.setResizable(false);
        //Para que la medida de la venta sea la misma que la del panel
        jframe.pack();
        
        /**
         * Se pone debajo para que no de error, porque si se pone encima
         * puede pasar que cuando se redimensione la ventana no se vea el juego.
         */
        jframe.setVisible(true);
        
    }
    
}

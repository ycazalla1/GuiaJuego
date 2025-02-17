/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import objetos.PanelJuego;

/**
 *
 * @author Yamila Cazalla Recio
 */

//Implementar es que implentas una interfaz, puedes implementar más de una interfaz
public class TecladoInputs implements KeyListener {
    
    private PanelJuego panelJuego;
    
    public TecladoInputs(PanelJuego panelJuego) {
    //Al hacer este método haremos que canvien los valores, con los inputs, el panel
        this.panelJuego = panelJuego;
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

     @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    //Cuando es presionada una tecla
        
        //Switch para según que tecla pulses haga algo
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                panelJuego.cambiarY(-5);
                break;
            case KeyEvent.VK_A:
                panelJuego.cambiarX(-5);
                break;
            case KeyEvent.VK_S:
                panelJuego.cambiarY(5);
                break;
            case KeyEvent.VK_D:
                panelJuego.cambiarX(5);
                break;
        }
        
    }
    
}

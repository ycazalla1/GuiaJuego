/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import inputs.MouseInputs;
import inputs.TecladoInputs;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Yamila Cazalla Recio
 */

//Extender es que extiendes la clase, solo puedes extender un clase
public class PanelJuego extends JPanel{
    
    private MouseInputs mouseInputs; //Declara variable de nuestro método
    
    private int frames = 0;
    
    //Se declaran estas variables como floats para controlar la velocidad del movimiento de la imágen
    private float xDelta = 100, yDelta = 100, xDir = 1f, yDir = 1f;
    
    
    private long UltComprobacion;
    private Color color = new Color(150,20,90); //Crear variable de la clase el Color
    private Random random; //Crear variable de la clase Random importaba de java
    
    public PanelJuego() {
        
        random = new Random(); //Asignar valor de la clase Random importaba de java
        
        //Si hacemos una variable de una clase hemos de declaralar en el método
        mouseInputs = new MouseInputs(this);
        
        //Métodos que guardan los valores al puslsar una teclas o mover el ratón
        addKeyListener(new TecladoInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
    }
    
    //Para incrementar las posiciones X e Y
    public void cambiarX(int valor) {
        this.xDelta += valor;
    }
    
    public void cambiarY(int valor) {
        this.yDelta += valor;
    }
    
    //Lo mismo que lo de arriba pero con el ratón
    public void setRectPos(int x, int y) {
    
        this.xDelta = x;
        this.yDelta = y;
    }
    
    //Cuando se crea este método se escribe así tal cual, si no aparece la imágen
    public void paintComponent(Graphics g) {
    /**
     * Llama a la super clase "PanelJuego", que se extiende de JPanel
     * Y que la propia JPanel se extiende en JComponent, para que haga su método
     * Esto nos sirve para evitar errores en cuanto a la generación de la imágen
     */
        super.paintComponent(g);
        
        upgradearRect(); //Llama a que haga el método
        
        g.setColor(color); //Le asigna el color
        
        //Medidas del JPanel: (ALLBITS (Posición X), ABORT (Posición Y), WIDTH, HEIGTH)
        g.fillRect((int)xDelta, (int)yDelta, 200, 50);
    }
    
    //Método posible para simular un viento fuerte y que tire para atrás al personaje
    //Objetos que se muevan solos, como npcs, lluvia, flechas
    private void upgradearRect() {
    
        xDelta += xDir;
        /**
         * El 400 viene del tamaño del JFrame, lo que hace que no se pase del JFrame
         * y hace que parezca que choca contra él
         * Cuando cambia la resolución este campo, 400, varia a la nueva resolución
         */
        if (xDelta > 400 || xDelta < 0){
            xDir *= -1; //-> 1 * -1 = -1 || -1 * -1 = 1
            color = getRandomColor(); //Guarda el resulatado del método
        }
        
        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0){
            yDir *= -1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() { //Método para obtener un color aleatorio
        
        //RGB: 0 - 255
        int r = random.nextInt(255), //Min = 0 || Max = 255
            g = random.nextInt(255),
            b = random.nextInt(255);
        
        return new Color(r, g, b); //Clase color importada de java
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import inputs.MouseInputs;
import inputs.TecladoInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    
    public PanelJuego() {
        
        
        
        //Si hacemos una variable de una clase hemos de declaralar en el método
        mouseInputs = new MouseInputs(this);
        
        importImg();
        
        setPanelSize();
        
        //Métodos que guardan los valores al puslsar una teclas o mover el ratón
        addKeyListener(new TecladoInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
    }
    
    private void importImg() {
        try {
            InputStream is = getClass().getResourceAsStream("prueba.jpg");
            if (is == null){
                throw new IOException("Imagen no encontrada.");
            }
            img = ImageIO.read(is);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
    
    private void setPanelSize() {
        Dimension dimension = new Dimension(1280, 800);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
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
        
        //g.drawImage(null, x, y, null);
    }

    
}

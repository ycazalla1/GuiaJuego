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
    //Variable para guardar imagenes
    private BufferedImage img, subImg;
    
    public PanelJuego() {
        
        //Si hacemos una variable de una clase hemos de declaralar en el método
        mouseInputs = new MouseInputs(this);
        
        //Llama al método para guardar la imagen en una variable
        importImg();
        
        //Llama al método para redimensionar el panel
        setPanelSize();
        
        //Métodos que guardan los valores al puslsar una teclas o mover el ratón
        addKeyListener(new TecladoInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
    }
    
    
    /**
     * @param is es la variable de tipo InputStream donde se carga la imagen
     * @param img donde se guarda la imagen
     */
    private void importImg() {
        //Un try-catch por si no encuentra la imagen que no se pete el juego
        try {
            /**
             * Si esta se encuentra en otro resource package se pone "/" seguido
             * de la ubicación
             */
            InputStream is = getClass().getResourceAsStream("/img/prueba.jpg");
            if (is == null){
                //Excepción que salta si no encuentra la imagen
                throw new IOException("Imagen no encontrada.");
            }
            //Si todo ha funcionado bien, guarda la imagen en la variable img
            img = ImageIO.read(is);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
    
    /**
     * Método para definir la dimension del panel.
     * @param dimension instancia de clase dimension, con medidas width i heigth
     */
    private void setPanelSize() {
        Dimension dimension = new Dimension(1280, 800);
        //Método para asignar la dimensión creada antes como preferida
        setPreferredSize(dimension);
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
        
        /**
         * Este método es para que se muestre la imagen en una posiciones
         * El último parámetro es para monitorear el estado de la imagen
         * antes de que se imprima
         * g.drawImage(img, 0, 0, null);
         */
        
        /**
         * getSubimage es para que coja una parte de la imagen
         * Los dos primeros parámetros son para la posición x, y
         * Los dos últimos parámetros son para la cantidad de pixeles
         * que se recojen
         */
        subImg = img.getSubimage(14, 17, 46, 75);
        
        /**
         * drawImage, los últimos dos parámetros antes del null, son para
         * definir el tamaño de la porción de la imagen
         */
        g.drawImage(subImg, (int) xDelta, (int) yDelta, 80, 128, null);
    }

    
}

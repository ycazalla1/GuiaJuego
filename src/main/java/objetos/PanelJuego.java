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
import static util.Constantes.ConstantJugador.*;
import static util.Constantes.Direcciones.*;
/**
 *
 * @author Yamila Cazalla Recio
 */
//Extender es que extiendes la clase, solo puedes extender un clase
public class PanelJuego extends JPanel {

    private MouseInputs mouseInputs; //Declara variable de nuestro método

    private int frames = 0;

    //Se declaran estas variables como floats para controlar la velocidad del movimiento de la imágen
    private float xDelta = 100, yDelta = 100;
    //Variable para guardar imagenes
    private BufferedImage img, subImg;
    //Matriz de sprites
    private BufferedImage[][] animaciones;
    private int aniTick, aniIndex, aniSpeed = 25;
    
    private int accionJudador = QUIETO, direccionJugador = -1;
    
    private boolean movimiento = false;

    public PanelJuego() {

        //Si hacemos una variable de una clase hemos de declaralar en el método
        mouseInputs = new MouseInputs(this);

        //Llama al método para guardar la imagen en una variable
        importImg();

        //Llama al método para ejecutar la animación
        cargarAnimacion();

        //Llama al método para redimensionar el panel
        setPanelSize();

        //Métodos que guardan los valores al puslsar una teclas o mover el ratón
        addKeyListener(new TecladoInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    /**
     * Método para ejecutar las animaciones
     */
    private void cargarAnimacion() {

        //Array estática con el número de imagenes para la animación
        animaciones = new BufferedImage[9][6];

        // Dos for para recorrer la matriz
        for (int j = 0; j < animaciones.length; j++) {
            for (int i = 0; i < animaciones[j].length; i++) {
                /* 
                    Se guarda el trozo de imagen que contiene cada frame del
                    sprite
                    getSubimage(posiciónHorizontal, posiciónVertical, width, heigth);
                */
                animaciones[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
        }

    }

    /**
     * @param is es la variable de tipo InputStream donde se carga la imagen
     * @param img donde se guarda la imagen
     */
    private void importImg() {
        /**
         * Si esta se encuentra en otro resource package se pone "/" seguido de
         * la ubicación
         */
        InputStream is = getClass().getResourceAsStream("/img/pruebaFail.png");
        //Un try-catch por si no encuentra la imagen que no se pete el juego
        try {
            //Si todo ha funcionado bien, guarda la imagen en la variable img
            img = ImageIO.read(is);
        } catch (IOException ex) {
            ex.getStackTrace();
        } finally {
            //Para controlar otros posibles errores, el cerrarlo
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método para definir la dimension del panel.
     *
     * @param dimension instancia de clase dimension, con medidas width i heigth
     */
    private void setPanelSize() {
        Dimension dimension = new Dimension(1280, 800);
        //Método para asignar la dimensión creada antes como preferida
        setPreferredSize(dimension);
    }
    
    public void setDireccion(int direccion) {
        this.direccionJugador = direccion;
        movimiento = true;
    }
    
    public void setMovimiento(boolean mov) {
        this.movimiento = mov;
    }

    /**
     * Método para actualizar las animaciones.
     * Interactua como un bucle
     */
    //TODO: entender este método
    private void actualizarAnimacion() {
        aniTick++; // Incrementa el valor de esta variable
        /*
            Si llega a ser más grande que la velocidad vuelve a 0
            e incrementa el valor de las posiciones del sprite
        */
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            /*
                Si las posisciones del sprite es mayor que la animación
                la cual empieza siendo 0
            */
            if (aniIndex >= getAnimacion(accionJudador)) {
                aniIndex = 0;
            }
        }
    }

    //TODO: entender como funciona este método, el cómo cambia el valor de movimiento
    private void setAnimacion() {
        if (movimiento) {
            accionJudador = CORRER;
        } else {
            accionJudador = QUIETO;
        }
    }
    
    //TODO: entender como funciona este método, el cómo cambia el valor de direccionJugador
    private void actualizarPosicion() {
        
        final int VELOCIDAD_MOVIMIENTO = 2;
        
        if (movimiento) {
            switch (direccionJugador) {
                case IZQUIERDA:
                    xDelta -= VELOCIDAD_MOVIMIENTO;
                    break;
                case ARRIBA:
                    yDelta -= VELOCIDAD_MOVIMIENTO;
                    break;
                case DERECHA:
                    xDelta += VELOCIDAD_MOVIMIENTO;
                    break;
                case ABAJO:
                    yDelta += VELOCIDAD_MOVIMIENTO;
                    break;
            }
        }
    }
    
    //Cuando se crea este método se escribe así tal cual, para que aparezca la imagen
    //TODO: entender qué es lo que llama a ejecutar este método
    public void paintComponent(Graphics g) {
        /**
         * Llama a la super clase "PanelJuego", que se extiende de JPanel Y que
         * la propia JPanel se extiende en JComponent, para que haga su método
         * Esto nos sirve para evitar errores en cuanto a la generación de la
         * imágen
         */
        super.paintComponent(g);

        /**
         * Este método es para que se muestre la imagen en una posicion
         * El último parámetro es para monitorear el estado de la imagen antes
         * de que se imprima g.drawImage(img, 0, 0, null);
         */
        actualizarAnimacion();
        
        setAnimacion();
        
        actualizarPosicion();

        /**
         * getSubimage es para que coja una parte de la imagen Los dos primeros
         * parámetros son para la posición x, y Los dos últimos parámetros son
         * para la cantidad de pixeles que se recojen subImg =
         * img.getSubimage(1*50, 17, 42, 72);
         */
        /**
         * drawImage, los últimos dos parámetros antes del null, son para
         * definir el tamaño de la porción de la imagen g.drawImage(subImg,
         * (int) xDelta, (int) yDelta, 80, 128, null);
         * Ahora en vez del trozo de imagen son las posiciones de la matriz
         */
        g.drawImage(animaciones[accionJudador][aniIndex], (int) xDelta, (int) yDelta, 120, 128, null);

    }

}

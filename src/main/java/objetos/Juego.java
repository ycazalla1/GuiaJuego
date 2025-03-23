/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Yamila Cazalla Recio
 */
//Implementación de un método que programamos nosostros
public class Juego implements Runnable {

    private VentanaJuego ventanaJuego; //Crear variable de una clase
    private PanelJuego panelJuego;
    //Un Thread es una específica tarea de un programa
    private Thread juegoT;
    private final int FPS_JUEGO = 120;
    //
    private final int UPS_JUEGO = 200;

    public Juego() {

        //Hacer que la varialbe obtenga el resultado de la clase
        /**
         * Se pone este encima de la Ventana porque si no inicializamos primero
         * el Panel da error, ya que no tendría Ventana ningún parámetro
         * asignado
         */
        panelJuego = new PanelJuego();
        // Le ponemos este parámetro ya que el objeto tiene como parámetro al PanelJuego
        ventanaJuego = new VentanaJuego(panelJuego);

        //Esto es para que interactue con los inputs
        panelJuego.setFocusable(true); //Para que interactue con ek teclado
        panelJuego.requestFocusInWindow(); //Para no tener que hacer clic y que te haga caso

        empezarJuego();
    }

    private void empezarJuego() {
        juegoT = new Thread(this);
        juegoT.start();
    }

    //Método creado por Runnable
    @Override
    public void run() {
        //Lo que se aquí es para poner un límite de FPS, en este caso 120 FPS

        double tiempoPorFrame = 1000000000.0 / FPS_JUEGO; //Se usa double, porque es más preciso que float
        long ultimoFrame = System.nanoTime();
        long ahora = System.nanoTime();
        int frames = 0;
        long UltComprobacion = System.currentTimeMillis();

        while (true) {
            ahora = System.nanoTime();
            if (ahora - ultimoFrame >= tiempoPorFrame) {

                //Esto es para que vuelva a generarse nuevo la imágen con los nuevos valores
                panelJuego.repaint();
                ultimoFrame = ahora;
                
                frames++; //Contador de frames
                
            }
            

            //Tener este IF hace que cuente siempre los FPS, sin hacer inputs
            /**
             * IF para contar por segundos los frames.
             * System.currentTimeMillis() es un cronómetro de milisegundos.
             *
             * @UltComprobacion hace que vuelva a 0 el cronómetro cuando llega a
             * 1000 m = 1 seg. Para que vuelva a 0 el cronómetro se le asigna a
             * esta variable los milisegundos contados. Eso hace que tenga 1000
             * para restarlselo al cronómetro que está a 1000 también.
             */
            if (System.currentTimeMillis() - UltComprobacion >= 1000) {
                UltComprobacion = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0; //Se reincia el contador de frames a 0 después de cada segundo pasado
            }

        }

    }
}

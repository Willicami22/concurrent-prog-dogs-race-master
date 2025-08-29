package arsw.threads;

/**
 * Controlador centralizado para manejar el estado de la carrera
 * Permite pausar y continuar todos los galgos de manera sincronizada
 */
public class ControladorCarrera {
    private boolean pausado = false;
    private final Object monitor = new Object();

    /**
     * Pausa la carrera - todos los galgos se dormirán
     */
    public void pausar() {
        synchronized (monitor) {
            pausado = true;
        }
    }

    /**
     * Continúa la carrera - despierta a todos los galgos
     */
    public void continuar() {
        synchronized (monitor) {
            pausado = false;
            monitor.notifyAll(); // Despierta a todos los hilos en espera
        }
    }

    /**
     * Método que deben llamar los galgos para verificar si deben pausar
     * Si la carrera está pausada, el hilo se duerme hasta ser despertado
     */
    public void verificarPausa() throws InterruptedException {
        synchronized (monitor) {
            while (pausado) {
                monitor.wait(); // El hilo se duerme hasta que se llame notifyAll()
            }
        }
    }
}

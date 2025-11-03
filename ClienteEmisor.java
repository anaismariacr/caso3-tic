import java.util.Queue;

public class ClienteEmisor extends Thread {
    
    private String name;
    private static BuzonEntrada buzonEntrada;
    private int numMsjs;
    
    public ClienteEmisor(String name, BuzonEntrada buzonEntrada, int numMsjs) {
        this.name = name;
        this.buzonEntrada = buzonEntrada;
        this.numMsjs = numMsjs;
    }

}

import java.util.Queue;

public class ClienteEmisor extends Thread {
    
    private String name;
    private static BuzonEntrada buzonEntrada;
    private int numMsjs;
    
    public ClienteEmisor(String name, BuzonEntrada buzonEntrada, int numMsjs) {
        super(name);
        this.buzonEntrada = buzonEntrada;
        this.numMsjs = numMsjs;
    }

    @Override
    public void run(){

    }

    public Mensaje generarMsj(){
        Mensaje msj = new Mensaje();
        return msj;
    }

}

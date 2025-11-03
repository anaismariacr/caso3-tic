import java.util.Queue;

public class ServidorEntrega extends Thread {

    private String name;
    private static BuzonEntrega buzonEntrega;
    
    public ServidorEntrega(String name, BuzonEntrega buzonEntrega) {
        super(name);
        this.buzonEntrega = buzonEntrega;
    }
}

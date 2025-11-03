import java.util.Queue;

public class FiltroSpam extends Thread {
    
    private String name;
    private static BuzonEntrada buzonEntrada;
    private static BuzonEntrega buzonEntrega;
    private static BuzonCuarentena buzonCuarentena;
    private static int numClientes;


    public FiltroSpam(String name, BuzonEntrada buzonEntrada, BuzonEntrega buzonEntrega, BuzonCuarentena buzonCuarentena, int numClientes) {
        super(name);
        this.buzonEntrada = buzonEntrada;
        this.buzonEntrega = buzonEntrega;
        this.buzonCuarentena = buzonCuarentena;
        this.numClientes = numClientes;
    }
}

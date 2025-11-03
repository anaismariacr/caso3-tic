import java.util.Queue;

public class ManejadorCuarentena extends Thread {
    private static BuzonCuarentena buzonCuarentena;
    private static BuzonEntrega buzonEntrega;

    public ManejadorCuarentena(BuzonCuarentena buzonCuarentena, BuzonEntrega buzonEntrega) {
        this.buzonCuarentena = buzonCuarentena;
        this.buzonEntrega = buzonEntrega;
    }
}

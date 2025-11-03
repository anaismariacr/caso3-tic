import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main <ruta_config>");
            return;
        }

        String rutaConfig = args[0];

        try {
            Config config = Config.cargarDeArchivo(rutaConfig);
            System.out.println("Informacion cargada correctamente: ");
            System.out.println(config);

            BuzonEntrada buzonEntrada = new BuzonEntrada(config.getCapacidadEntrada());
            BuzonEntrega buzonEntrega = new BuzonEntrega(config.getCapacidadEntrega());
            BuzonCuarentena buzonCuarentena = new BuzonCuarentena();

            List<Thread> clientes = new ArrayList<>();
            List<Thread> filtros = new ArrayList<>();
            List<Thread> servidores = new ArrayList<>();

            ManejadorCuarentena manejador = new ManejadorCuarentena(buzonCuarentena, buzonEntrega);
            Thread hiloManejador = new Thread(manejador, "ManejadorCuarentena");
            
            for(int i = 1; i <= config.getNumClientes(); i++) {
                ClienteEmisor cliente = new ClienteEmisor("Cliente-" + i, buzonEntrada, config.getMsjsPorCliente());
                Thread hiloCliente = new Thread(cliente);
                clientes.add(hiloCliente);
                hiloCliente.start();
            }

            for (int i = 1; i <= config.getNumFiltros(); i++) {
                FiltroSpam filtro = new FiltroSpam("Filtro-" + i, buzonEntrada, buzonEntrega, buzonCuarentena, config.getNumClientes());
                Thread hiloFiltro = new Thread(filtro);
                filtros.add(hiloFiltro);
                hiloFiltro.start();
            }

            for (int i = 1; i <= config.getNumServidores(); i++) {
                ServidorEntrega servidor = new ServidorEntrega("Servidor-" + i, buzonEntrega);
                Thread hiloServidor = new Thread(servidor);
                servidores.add(servidor);
                hiloServidor.start();
            }

            hiloManejador.start();

            for (Thread c : clientes) c.join();
            for (Thread f : filtros) f.join();
            hiloManejador.join();
            for (Thread s : servidores) s.join();

            System.out.println("\nSistema de mensajería finalizado correctamente.");
            System.out.println("Todos los buzones están vacíos y los hilos han terminado.");

        } catch (IOException e) {
            System.err.println("Error para leer archivo de configuracion " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Ejecucion interrumpida " + e.getMessage());
        }



    }
}

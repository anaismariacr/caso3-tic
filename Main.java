import java.io.IOException;

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
        } catch (IOException e) {
            System.err.println("Error para leer archivo de configuracion " + e.getMessage());
        }
    }
}

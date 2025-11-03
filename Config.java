import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {
    
    private int numClientes;
    private int msjsPorCliente;
    private int numFiltros;
    private int numServidores;
    private int capacidadEntrada;
    private int capacidadEntrega;

    // Getters públicos
    public int getNumClientes() { return numClientes; }
    public int getMsjsPorCliente() { return msjsPorCliente; }
    public int getNumFiltros() { return numFiltros; }
    public int getNumServidores() { return numServidores; }
    public int getCapacidadEntrada() { return capacidadEntrada; }
    public int getCapacidadEntrega() { return capacidadEntrega; }

    public Config() {}

    public static Config cargarDeArchivo(String ruta) throws IOException {

        Config config = new Config();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("#")) continue;
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    String key = partes[0].trim();
                    String value = partes[1].trim();

                    switch (key) {
                        case "numClientes":
                            config.numClientes = Integer.parseInt(value);
                            break;
                        case "msjsPorCliente":
                            config.msjsPorCliente = Integer.parseInt(value);
                            break;
                        case "numFiltros":
                            config.numFiltros = Integer.parseInt(value);
                            break;
                        case "numServidores":
                            config.numServidores = Integer.parseInt(value);
                            break;
                        case "capacidadEntrada":
                            config.capacidadEntrada = Integer.parseInt(value);
                            break;
                        case "capacidadEntrega":
                            config.capacidadEntrega = Integer.parseInt(value);
                            break;
                        default:
                            System.out.println("Parámetro desconocido: " + key);
                    }
                }
            }
        }
        return config;
    }

    @Override
    public String toString() {
        return "ConfiguracionSistema{" +
                "numClientes=" + numClientes +
                ", msjsPorCliente=" + msjsPorCliente +
                ", numFiltros=" + numFiltros +
                ", numServidores=" + numServidores +
                ", capacidadEntrada=" + capacidadEntrada +
                ", capacidadEntrega=" + capacidadEntrega +
                '}';
    }
}

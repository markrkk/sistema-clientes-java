import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la lógica de negocio del sistema.
 * Gestiona las operaciones CRUD sobre los clientes.
 */
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    private int contadorId = 1;

    /**
     * Devuelve la lista completa de clientes.
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Agrega un nuevo cliente al sistema.
     */
    public void agregarCliente(String nombre, String apellidos, String sexo,
                               String ciudad, String fecha,
                               String telefono, String correo) {

        Cliente nuevo = new Cliente(contadorId++, nombre, apellidos, sexo,
                ciudad, fecha, telefono, correo);

        clientes.add(nuevo);
    }

    /**
     * Busca un cliente por su ID.
     */
    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * Elimina un cliente por ID.
     */
    public boolean eliminarCliente(int id) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            clientes.remove(c);
            return true;
        }
        return false;
    }
}
import java.util.ArrayList;
import java.util.List;

//Clase que gestiona la logica del sistema (CRUD DE CLIENTES)
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    private int contadorId = 1;

    // Devuelve la lista completa de clientes.
    public List<Cliente> getClientes() {
        return clientes;
    }

    //Crea un nuevo cliente y lo añade a la lista
    
    public void agregarCliente(String nombre, String apellidos, String sexo,
                               String ciudad, String fecha,
                               String telefono, String correo) {

        Cliente nuevo = new Cliente(contadorId++, nombre, apellidos, sexo,
                ciudad, fecha, telefono, correo);

        clientes.add(nuevo);
    }

    // Busca un cliente por su ID.
     
    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    //Elimina un cliente por ID si existe.
     
    public boolean eliminarCliente(int id) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            clientes.remove(c);
            return true;
        }
        return false;
    }
}

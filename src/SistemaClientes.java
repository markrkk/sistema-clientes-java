import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que gestiona la interacción con el usuario por consola.
 * Permite realizar operaciones CRUD básicas.
 */
public class SistemaClientes {

    private static Scanner sc = new Scanner(System.in);
    private static ClienteService service = new ClienteService();

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerNumero();

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    buscarPorCiudad();
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);
    }

    /**
     * Muestra el menú principal del sistema.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ CLIENTES ---");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Actualizar cliente");
        System.out.println("4. Eliminar cliente");
        System.out.println("5. Buscar por ciudad");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
    }

    private static int leerNumero() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Solicita un campo obligatorio.
     */
    private static String pedirCampo(String mensaje) {
        String valor;
        do {
            System.out.print(mensaje + ": ");
            valor = sc.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("Este campo es obligatorio.");
            }
        } while (valor.isEmpty());
        return valor;
    }

    private static void agregarCliente() {

        String nombre = pedirCampo("Nombre");
        String apellidos = pedirCampo("Apellidos");
        String sexo = pedirCampo("Sexo");
        String ciudad = pedirCampo("Ciudad");
        String fecha = pedirCampo("Fecha nacimiento");
        String telefono = pedirCampo("Teléfono");
        String correo = pedirCampo("Correo");

        service.agregarCliente(nombre, apellidos, sexo,
                ciudad, fecha, telefono, correo);

        System.out.println("Cliente agregado correctamente.");
    }

    private static void listarClientes() {

        List<Cliente> lista = service.getClientes();

        if (lista.isEmpty()) {
            System.out.println("No hay clientes.");
            return;
        }

        for (Cliente c : lista) {
            System.out.println(c);
        }
    }

    private static void actualizarCliente() {

        System.out.print("ID del cliente a actualizar: ");
        int id = leerNumero();

        Cliente c = service.buscarPorId(id);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        String nombre = pedirCampo("Nombre");
        String apellidos = pedirCampo("Apellidos");
        String sexo = pedirCampo("Sexo");
        String ciudad = pedirCampo("Ciudad");
        String fecha = pedirCampo("Fecha nacimiento");
        String telefono = pedirCampo("Teléfono");
        String correo = pedirCampo("Correo");

        c.actualizarDatos(nombre, apellidos, sexo,
                ciudad, fecha, telefono, correo);

        System.out.println("Cliente actualizado.");
    }

    private static void eliminarCliente() {

        System.out.print("ID del cliente a eliminar: ");
        int id = leerNumero();

        if (service.eliminarCliente(id)) {
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void buscarPorCiudad() {

        System.out.print("Ciudad a buscar: ");
        String ciudad = sc.nextLine().trim();

        boolean encontrado = false;

        for (Cliente c : service.getClientes()) {
            if (c.getCiudad().equalsIgnoreCase(ciudad)) {
                System.out.println(c);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron clientes en esa ciudad.");
        }
    }
}
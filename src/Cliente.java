/**
 * Clase que representa un Cliente del sistema.
 */
public class Cliente {

    private int id;
    private String nombre;
    private String apellidos;
    private String sexo;
    private String ciudad;
    private String fechaNacimiento;
    private String telefono;
    private String correo;

    /**
     * Constructor para crear un cliente con sus datos.
     */
    public Cliente(int id, String nombre, String apellidos, String sexo,
                   String ciudad, String fechaNacimiento,
                   String telefono, String correo) {

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    /**
     * Actualizamos todos los datos del cliente.
     */
    public void actualizarDatos(String nombre, String apellidos, String sexo,
                                String ciudad, String fechaNacimiento,
                                String telefono, String correo) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Devuelve una representación en texto del cliente.
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre + " " + apellidos +
                " | " + sexo +
                " | " + ciudad +
                " | " + fechaNacimiento +
                " | " + telefono +
                " | " + correo;
    }
}

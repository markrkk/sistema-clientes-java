//Clase que representa un cliente del sistema
//Aqui se guardan todos sus datos personales

public class Cliente {

    private int id;
    private String nombre;
    private String apellidos;
    private String sexo;
    private String ciudad;
    private String fechaNacimiento;
    private String telefono;
    private String correo;

    //Constructor que inicializa los datos del cliente
    
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

    //Metodo para actualizar todos los datos del cliente
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

   //Devuelve los datos del cliente para mostrarlos 
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

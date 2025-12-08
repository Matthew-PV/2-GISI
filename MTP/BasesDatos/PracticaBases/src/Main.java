import java.sql.*;
import java.util.Scanner;

public class Main {
    private static String RESET = "\033[0;0m";
    private static String ROJO = "\u001B[31m";
    private static String VERDE = "\u001B[32m";
    private static String AMARILLO = "\u001B[33m";
    private static String LOG = "\033[0;1m" + "\u001B[34m" + "LOG" + RESET + "\t\t";

    public static void main(String args[]) {
        String driver = "org.sqlite.JDBC";
        String url = "jdbc:sqlite:practica.db";

        PreparedStatement statement = null;
        Connection baseDeDatos = null;
        ResultSet resultados = null;

        try {
            // 1. Crea o conecta a una BD:
            System.out.println("\t\t1) Nos conectamos a la base de datos "+AMARILLO+url+RESET+
                    " mediante el driver "+AMARILLO+driver+RESET+".");
            Class.forName(driver);
            baseDeDatos = DriverManager.getConnection(url);

            // 2. Crea la tabla empleados:
            System.out.println("\n\t\t2) Creamos la tabla "+AMARILLO+"empleado"+RESET+".");
            ejecutarActualizacion(baseDeDatos, "DROP TABLE IF EXISTS empleado");
            ejecutarActualizacion(baseDeDatos, "CREATE TABLE IF NOT EXISTS empleado (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre VARCHAR(50), " +
                    "telefono VARCHAR(20), " +
                    "salario DOUBLE, " +
                    "fechaContrato DATE)");

            // 3. Inserta registros de forma segura:
            System.out.println("\n\t\t3) Insertamos registros mediante "
                    +AMARILLO+"\"prepared statements\""+RESET+".");
            insertarEmpleado(baseDeDatos, "Pepe", 600100100, 1200, "2025-06-12");
            insertarEmpleado(baseDeDatos, "Juan", 610010010, 1350, "2025-08-22");
            insertarEmpleado(baseDeDatos, "Marcos", 642511271, 1100, "2024-02-11");
            System.out.println(AMARILLO+"\t\tTambién los podríamos introducimos por consola..."+RESET);
            //insertarEmpleadoConsola(baseDeDatos);

            // 4. Lista los empleados:
            System.out.println("\n\t\t4) Listamos los "+AMARILLO+"empleados"+RESET+".");
            resultados = ejecutarConsulta(baseDeDatos, "SELECT * FROM empleado");
            System.out.println("ID, NOMBRE, TELÉFONO, SALARIO, FECHACONTRATO\n" +
                    "----------------------------------------------");
            while (resultados.next()) {
                System.out.println(resultados.getInt("ID")+", "
                        +resultados.getString("NOMBRE")+", "
                        +resultados.getInt("TELEFONO")+", "
                        +resultados.getDouble("SALARIO")+", "
                        +resultados.getDate("FECHACONTRATO"));
            }

            // 5. Actualiza uno:
            System.out.println("\n\t\t5) Actualizaremos un registro. Para ello aumentaremos el "
                    +AMARILLO+"salario"+RESET+" de "+AMARILLO+"Marcos"+RESET+" porque lleva mucho tiempo" +
                    " en la empresa, y porque nos cae bien.");
            ejecutarActualizacion(baseDeDatos, "UPDATE empleado SET salario = salario*1.2 " +
                    "WHERE nombre = \'Marcos\'");
            resultados = ejecutarConsulta(baseDeDatos, "SELECT NOMBRE, SALARIO FROM empleado " +
                    "WHERE nombre = \'Marcos\'");
            System.out.println(resultados.getString("NOMBRE")+", "+resultados.getDouble("SALARIO"));

            // 6. Cierra la conexión correctamente:
            System.out.println("\n\t\t6) Finalmente "+AMARILLO+"cerraremos la conexión"+RESET+".");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultados != null) {
                    resultados.close();
                }
                System.out.println(LOG+VERDE+"Cierre de resultados exitoso."+RESET);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(LOG+ROJO+"Cierre de resultados fallido."+RESET);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
                System.out.println(LOG+VERDE+"Cierre de \"statements\" exitoso."+RESET);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.printf(LOG+ROJO+"Cierre de \"statements\" fallido."+RESET);
            }
            try {
                if (baseDeDatos != null) {
                    baseDeDatos.close();
                }
                System.out.println(LOG+VERDE+"Cierre de conexión exitoso."+RESET);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.printf(LOG+ROJO+"Cierre de conexión fallido."+RESET);
            }
        }
    }


    /**
     * Envuelve un prepared statement de actualización.
     * @param connection Base de datos sobre la que ejecutar la actualización.
     * @param statement Código SQL que se intentará ejecutar.
     */
    private static void ejecutarActualizacion(Connection connection, String statement) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.executeUpdate();
            System.out.println(LOG+ VERDE +"Actualización exitosa:"+RESET+" "+statement);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(LOG+ ROJO +"Actualización fallida:"+RESET+" "+statement);
        }
    }

    /**
     * Envuelve un prepared statement de consulta.
     * @param connection Base de datos sobre la que ejecutar la consulta.
     * @param statement Código SQL que se intentará ejecutar.
     */
    private static ResultSet ejecutarConsulta(Connection connection, String statement) {
        ResultSet resultado = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            resultado = preparedStatement.executeQuery();
            System.out.println(LOG+ VERDE +"Consulta exitosa:"+RESET+" "+statement);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(LOG+ VERDE +"Consulta fallida:"+RESET+" "+statement);
        }
        return resultado;
    }


    /**
     * Mét_odo que facilita la inserción de nuevos empleados en la tabla.
     * @param connection Base de datos sobre la que ejecutar la inserción.
     * @param nombre Nombre del empleado.
     * @param telefono Número de teléfono del empleado.
     * @param salario Salario del empleado.
     * @param fechaContrato Fecha de contrato del empleado.
     */
    private static void insertarEmpleado(Connection connection, String nombre, int telefono,
                                  double salario, String fechaContrato) {
        String statement = "INSERT INTO empleado (nombre, telefono, salario, fechaContrato) " +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, telefono);
            preparedStatement.setDouble(3, salario);
            preparedStatement.setDate(4, Date.valueOf(fechaContrato));
            preparedStatement.executeUpdate();
            System.out.println(LOG+ VERDE +"Inserción exitosa:"+RESET+" "+nombre+" insertado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(LOG+ ROJO +"Inserción fallida.\n"+RESET+
                    "Nombre: "+nombre+"\n" +
                    "Teléfono: "+telefono+"\n" +
                    "Salario: "+salario+"\n" +
                    "Fecha de Contrato: "+fechaContrato);
        }
    }


    /**
     * Mét_odo que facilita la inserción de nuevos empleados en la tabla
     * mediante inserción de datos a través de consola.
     * @param connection Base de datos sobre la que ejecutar la inserción.
     */
    private static void insertarEmpleadoConsola(Connection connection) {
        Scanner teclado = new Scanner(System.in);
        String statement = "INSERT OR ABORT INTO empleado (nombre, telefono, salario, fechaContrato) " +
                "VALUES(?,?,?,?)";
        String nombre = "";
        int telefono = -1;
        double salario = -1;
        String fechaContrato = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            System.out.print(AMARILLO+"Introduce el nombre del empleado: "+RESET);
            nombre = teclado.nextLine();
            preparedStatement.setString(1, nombre);

            System.out.print(AMARILLO+"Introduce el teléfono del empleado: "+RESET);
            telefono = teclado.nextInt();
            preparedStatement.setInt(2, telefono);

            System.out.print(AMARILLO+"Introduce el salario del empleado: "+RESET);
            salario = teclado.nextDouble();
            preparedStatement.setDouble(3, salario);

            System.out.print(AMARILLO+"Introduce la fecha de contratación del empleado (yyyy-mm-dd): "+RESET);
            fechaContrato = teclado.next();
            preparedStatement.setDate(4, Date.valueOf(fechaContrato));
            preparedStatement.executeUpdate();
            System.out.println(LOG+ VERDE +"Inserción exitosa:"+RESET+" "+nombre+" insertado con éxito.");
            teclado.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(LOG+ ROJO +"Inserción fallida.\n"+RESET+
                    "Nombre: "+nombre+"\n" +
                    "Teléfono: "+telefono+"\n" +
                    "Salario: "+salario+"\n" +
                    "Fecha de Contrato: "+fechaContrato);
        }
    }
}

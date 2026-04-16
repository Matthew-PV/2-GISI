import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void ejecutar(PreparedStatement myStatement) throws SQLException {
        for (int i = 1; i <= 2; i++) {
            long inicio = System.nanoTime();
            myStatement.executeQuery();
            long fin = System.nanoTime();

            double ms = (fin - inicio) / 1000000.0;
            System.out.println("Tiempo " + i + ":\n" + ms + " ms\n" + (fin-inicio) + " ns\n\n");
        }
    }

    public static void World(Scanner sc) {
        int opcion1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String mysqlURL = "jdbc:mysql://localhost:3306/world";
            Connection conexion = DriverManager.getConnection(mysqlURL, "root", "1234");
            PreparedStatement myStatement;
            myStatement = conexion.prepareStatement("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
            myStatement.execute();

            do {
                System.out.println("\nSelecciona apartado: \n1. Funciones predefinidas \n2. Selección simple\n3. Selección compleja\n4. Salir\nOpción: ");
                opcion1 = sc.nextInt();
                sc.nextLine();

                int opcion2;
                switch (opcion1) {
                    case 1:
                        do {
                            System.out.println("Selecciona consulta: \n1. SELECT count(*) FROM city \n2. SELECT avg(population) FROM city\n3. Salir\nOpción: ");
                            opcion2 = sc.nextInt();
                            sc.nextLine();

                            switch (opcion2) {
                                case 1:
                                    myStatement = conexion.prepareStatement("SELECT count(*) FROM city");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 2:
                                    myStatement = conexion.prepareStatement("SELECT avg(population) FROM city");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                        } while (opcion2 != 3);
                        break;
                    case 2:
                        do {
                            System.out.println("Selecciona consulta: \n1. SELECT * FROM city \n2. SELECT id, name, countrycode, district, population FROM city WHERE countrycode LIKE '%S%'\n3. Salir\nOpción: ");
                            opcion2 = sc.nextInt();
                            sc.nextLine();

                            switch (opcion2) {
                                case 1:
                                    myStatement = conexion.prepareStatement("SELECT * FROM city");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 2:
                                    myStatement = conexion.prepareStatement("SELECT id, name, countrycode, district, population FROM city WHERE countrycode LIKE ?;");
                                    myStatement.setString(1, "%S%");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                        } while (opcion2 != 3);
                        break;
                    case 3:
                        do {
                            System.out.println("Selecciona consulta: \n1. SELECT name, district, population FROM city WHERE population > 2*(SELECT avg(population)\n" +
                                    "FROM city) AND countrycode <> 'USA' ORDER BY population DESC \n\n" +
                                    "2. SELECT countrylanguage.countrycode, country.name, countrylanguage.language, countrylanguage.isofficial, \n" +
                                    "countrylanguage.percentage FROM countrylanguage INNER JOIN city ON countrylanguage.countrycode = city.countrycode \n" +
                                    "INNER JOIN country ON countrylanguage.countrycode = country.code WHERE countrylanguage.isofficial = 'F' GROUP BY \n" +
                                    "countrylanguage.language ORDER BY country.name, countrylanguage.percentage\n\n3. Salir\nOpción: ");
                            opcion2 = sc.nextInt();
                            sc.nextLine();

                            switch (opcion2) {
                                case 1:
                                    myStatement = conexion.prepareStatement("SELECT name, district, population FROM city WHERE population >" +
                                            "2*(SELECT avg(population) FROM city) AND countrycode <> ? ORDER BY population DESC");
                                    myStatement.setString(1, "USA");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 2:
                                    myStatement = conexion.prepareStatement("SELECT countrylanguage.countrycode, country.name, countrylanguage.language, countrylanguage.isofficial, countrylanguage.percentage FROM countrylanguage INNER JOIN city ON countrylanguage.countrycode = city.countrycode INNER JOIN country ON countrylanguage.countrycode = country.code WHERE countrylanguage.isofficial = ? GROUP BY countrylanguage.language ORDER BY country.name, countrylanguage.percentage");
                                    myStatement.setString(1, "F");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                        } while (opcion2 != 3);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } while (opcion1!=4);
            if (conexion != null) conexion.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando driver: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex);
        }
    }



    public static void Sakila(Scanner sc) {
        int opcion1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String mysqlURL = "jdbc:mysql://localhost:3306/sakila";
            Connection conexion = DriverManager.getConnection(mysqlURL, "root", "1234");
            PreparedStatement myStatement;
            myStatement = conexion.prepareStatement("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
            myStatement.execute();

            do {
                System.out.println("\nSelecciona apartado: \n1. Funciones predefinidas \n2. Selección simple\n3. Selección compleja\n4. Salir\nOpción: ");
                opcion1 = sc.nextInt();
                sc.nextLine();

                int opcion2;
                switch (opcion1) {
                    case 1:
                        do {
                            System.out.println("Selecciona consulta: \n1. SELECT count(*) FROM film \n2. SELECT avg(release_year) FROM film\n3. Salir\nOpción: ");
                            opcion2 = sc.nextInt();
                            sc.nextLine();

                            switch (opcion2) {
                                case 1:
                                    myStatement = conexion.prepareStatement("SELECT count(*) FROM film");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 2:
                                    myStatement = conexion.prepareStatement("SELECT avg(release_year) FROM film");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                        } while (opcion2 != 3);
                        break;
                    case 2:
                        do {
                            System.out.println("Selecciona consulta: \n1. SELECT * FROM inventory \n2. SELECT * FROM inventory WHERE (inventory_id%2) = 0 AND \n(inventory_id%3) = 0 OR (inventory_id%7) = 0;\n3. Salir\nOpción: ");
                            opcion2 = sc.nextInt();
                            sc.nextLine();

                            switch (opcion2) {
                                case 1:
                                    myStatement = conexion.prepareStatement("SELECT * FROM inventory");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 2:
                                    myStatement = conexion.prepareStatement("SELECT * FROM inventory WHERE (inventory_id%2) = ? AND" +
                                            "((inventory_id%3) = ? OR (inventory_id%7) = ?)");
                                    myStatement.setInt(1, 0);
                                    myStatement.setInt(2, 0);
                                    myStatement.setInt(3, 0);
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                        } while (opcion2 != 3);
                        break;
                    case 3:
                        do {
                            System.out.println("Selecciona consulta: \n1. SELECT title, release_year, l.name, rating, length, c.name, " +
                                    "GROUP_CONCAT(CONCAT(a.first_name, ' ', a.last_name) SEPARATOR ', ') AS 'reparto' FROM film f INNER " +
                                    "JOIN film_actor fa ON f.film_id = fa.film_id INNER JOIN actor a ON fa.actor_id = a.actor_id INNER " +
                                    "JOIN language l ON f.language_id = l.language_id INNER JOIN film_category fc ON f.film_id = fc.film_id " +
                                    "INNER JOIN category c ON fc.category_id = c.category_id GROUP BY f.film_id, f.title, f.release_year, f.rating, " +
                                    "f.length, l.name, c.name ORDER BY f.title;" +
                                    "\n\n2. SELECT cus.first_name, cus.last_name, cus.email, a.phone, CONCAT(a.address, ', ', cit.city, ', ', cou.country) " +
                                    "AS 'direccion cliente', CONCAT(a2.address, ', ', cit2.city, ', ', cou2.country) AS 'direccion tienda' FROM customer cus " +
                                    "INNER JOIN address a ON cus.address_id = a.address_id INNER JOIN city cit ON a.city_id = cit.city_id INNER JOIN country " +
                                    "cou ON cit.country_id = cou.country_id INNER JOIN store s ON cus.store_id = s.store_id INNER JOIN address a2 ON s.address_id " +
                                    "= a2.address_id INNER JOIN city cit2 ON a2.city_id = cit2.city_id INNER country cou2 ON cit2.country_id = cou2.country_id " +
                                    "ORDER BY s.store_id, cus.last_name;\n\n3. Salir\nOpción: ");
                            opcion2 = sc.nextInt();
                            sc.nextLine();

                            switch (opcion2) {
                                case 1:
                                    myStatement = conexion.prepareStatement("select title, release_year, l.name, rating, length, c.name, group_concat(concat(a.first_name, ' ', a.last_name) separator ', ') as 'reparto' from film f inner join film_actor fa on f.film_id = fa.film_id inner join actor a on fa.actor_id = a.actor_id inner join language l on f.language_id = l.language_id inner join film_category fc on f.film_id = fc.film_id inner join category c on fc.category_id = c.category_id group by f.film_id, f.title, f.release_year, f.rating, f.length, l.name, c.name order by f.title;");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 2:
                                    myStatement = conexion.prepareStatement("select cus.first_name, cus.last_name, cus.email, a.phone, concat(a.address, ', ', cit.city, ', ', cou.country) as 'direccion cliente', concat(a2.address, ', ', cit2.city, ', ', cou2.country) as 'direccion tienda' from customer cus inner join address a on cus.address_id = a.address_id inner join city cit on a.city_id = cit.city_id inner join country cou on cit.country_id = cou.country_id inner join store s on cus.store_id = s.store_id inner join address a2 on s.address_id = a2.address_id inner join city cit2 on a2.city_id = cit2.city_id inner join country cou2 on cit2.country_id = cou2.country_id order by cus.last_name;");
                                    ejecutar(myStatement);
                                    myStatement.close();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                        } while (opcion2 != 3);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opción no válida");

                }
            } while (opcion1 != 4);
            if (conexion != null) conexion.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando driver: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nSelecciona BBDD: \n1. Sakila \n2. World\n3. Salir\nOpción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Sakila(sc);
                    break;
                case 2:
                    World(sc);
                    break;
                case 3:
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}
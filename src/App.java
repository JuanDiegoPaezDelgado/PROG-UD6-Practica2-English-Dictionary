import java.util.Scanner;
import java.util.Set;

import net.salesianos.diccionario.Diccionario;
import net.salesianos.menu.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();
        System.out.println("¡Bienvenido al diccionario de Duolingo!");
        boolean seguir = true;
        while (seguir) {
            Menu.mostrarMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Ingrese la palabra que desea agregar:");
                    String agregarPalabra = scanner.nextLine();
                    if (agregarPalabra.isEmpty() || agregarPalabra.matches(".*\\d.*")) {
                        System.out.println("ingrese un valor valido.");
                        break;
                    }

                    diccionario.agregarPalabra(agregarPalabra);
                    System.out.println("\nPalabra agregada correctamente.");
                    break;
                case "2":
                    System.out.println("Ingrese la palabra a eliminar:");
                    String palabraEliminar = scanner.nextLine();
                    if (palabraEliminar.isEmpty() || palabraEliminar.matches(".*\\d.*")) {
                        System.out.println("Debe ingresar un texto.");
                        break;
                    }

                    if (diccionario.contienePalabra(palabraEliminar)) {
                        diccionario.eliminarPalabra(palabraEliminar);
                        System.out.println("\nPalabra eliminada correctamente.");
                    } else {
                        System.out.println("\nPalabra no encontrada");
                    }

                    break;
                case "3":
                    System.out.println("Ingrese la palabra que desea verificar:");
                    String palabraAVerificar = scanner.nextLine();
                    if (palabraAVerificar.isEmpty() || palabraAVerificar.matches(".*\\d.*")) {
                        System.out.println("Debe ingresar al menos un valor.");
                        break;
                    } else if (seguir) {
                        if (diccionario.contienePalabra(palabraAVerificar)) {
                            System.out.println("\nLa palabra está en el diccionario.");
                        } else {
                            System.out.println("\nLa palabra no está en el diccionario.");
                        }
                    }

                    break;
                case "4":
                    System.out.println("Iniciales disponibles:");
                    Set<Character> iniciales = diccionario.conseguirInicialesDisponibles();
                    if (iniciales.isEmpty()) {
                        System.out.println("\nNo hay iniciales disponibles en el diccionario.");
                    } else {
                        boolean primero = true;
                        for (char inicial : iniciales) {
                            if (!primero) {
                                System.out.print(", ");
                            }
                            primero = false;
                            System.out.print("\"" + Character.toString(inicial).toUpperCase() + "\"");
                        }
                    }
                    break;
                case "5":
                    System.out.println("Ingrese la inicial para ver palabras:");
                    String letra = scanner.nextLine();
                    if (letra.isEmpty() || letra.matches(".*\\d.*")) {
                        System.out.println("Debe ingresar al menos una letra como inicial.");
                        break;
                    }
                    char inicial = letra.charAt(0);
                    Set<String> palabras = diccionario.conseguirPalabrasPorInicial(inicial);
                    System.out.println("\nPalabras que comienzan con '" + Character.toUpperCase(inicial) + "':\n");
                    if (palabras == null) {
                        System.out.println(
                                "No se encontraron palabras para la inicial " + Character.toUpperCase(inicial));
                    } else {
                        for (String palabra : palabras) {
                            String palabraMayuscula = Character.toUpperCase(palabra.charAt(0)) + palabra.substring(1);
                            System.out.println("- " + palabraMayuscula);
                        }
                    }
                    break;

                case "6":
                    System.out.println("¡Hasta luego!");
                    seguir = false;
                    break;
                default:
                    System.out.println("opcion invalida, ingrese una opcion valida para poder continuar");
            }
        }
        scanner.close();
    }
}

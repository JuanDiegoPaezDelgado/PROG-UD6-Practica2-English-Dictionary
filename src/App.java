import java.util.Scanner;

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
                default:
                    break;
            }
        }
    }
}

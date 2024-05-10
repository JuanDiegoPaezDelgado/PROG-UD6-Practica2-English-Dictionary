package net.salesianos.diccionario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Diccionario {
     private Map<Character, Set<String>> diccionario;

    public Diccionario() {
        diccionario = new HashMap<>();
    }

    public void agregarPalabra(String palabra) {
        char inicial = Character.toLowerCase(palabra.charAt(0));
        palabra = palabra.trim().toLowerCase();
        diccionario.putIfAbsent(inicial, new HashSet<>());
        diccionario.get(inicial).add(palabra);
    }
    public void eliminarPalabra(String palabra) {
        char inicial = Character.toLowerCase(palabra.charAt(0));
        palabra = palabra.trim().toLowerCase();
        diccionario.get(inicial).remove(palabra);

    }
}

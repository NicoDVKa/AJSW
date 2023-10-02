package org.sockets;

import java.io.*;
import java.net.*;

public class ClienteSocket {
    public static void main(String[] args) {
        final String servidorIP = "127.0.0.1"; // Dirección IP del servidor
        final int puerto = 12345; // Puerto en el que el servidor escucha

        try (Socket socket = new Socket(servidorIP, puerto)) {
            // Establecer flujos de entrada y salida para la comunicación
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Enviar un mensaje al servidor
            String mensaje = "¡Hola, servidor!";
            salida.println(mensaje);

            // Leer la respuesta del servidor
            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

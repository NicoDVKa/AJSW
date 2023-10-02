package org.sockets;

import java.io.*;
import java.net.*;

public class ServidorSocket {
    public static void main(String[] args) {
        final int puerto = 12345; // Puerto en el que el servidor escuchará

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                try (Socket clienteSocket = serverSocket.accept()) {
                    System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress());

                    // Establecer flujos de entrada y salida para la comunicación
                    BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                    PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

                    // Leer mensaje del cliente
                    String mensajeCliente = entrada.readLine();
                    System.out.println("Mensaje del cliente: " + mensajeCliente);

                    // Responder al cliente
                    salida.println("¡Mensaje recibido!");

                    // Cerrar la conexión con el cliente
                    clienteSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

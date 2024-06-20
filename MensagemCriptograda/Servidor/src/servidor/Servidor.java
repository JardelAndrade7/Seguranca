package servidor;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.Scanner;

import java.io.IOException;

public class Servidor {

    public static void main(String[] args) {

        try {

            // Instancia um servidor e define uma porta na qual ele estará escutando.
            ServerSocket serverSocket = new ServerSocket(12345);

            // Log para avaliar o percurso do processo no terminal.
            System.out.println("Servidor aguardando conexões...");

            // Quando o Cliente tentar estabelecer a conexão pela porta correta, ela será aceita.
            Socket socket = serverSocket.accept();

            // Log para avaliar o percurso do processo no terminal.
            System.out.println("Conexão estabelecida com o cliente.");

            // O Scanner vai pegar a mensagem que o Servidor recebe no fluxo de entrada.
            Scanner scanner = new Scanner(socket.getInputStream());

            // O "scanner.nextLine ()" retorna para a "String mensagemRecebida" a mensagem que o servidor recebeu pelo fluxo de entrada.
            String mensagemRecebida = scanner.nextLine();

            // A mensagem que o Servidor recebeu é, por fim, impressa.
            System.out.println("Mensagem Recebida: " + mensagemRecebida);

            scanner.close();

            socket.close();

            serverSocket.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
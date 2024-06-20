package cliente;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;

public class Cliente {
    public static void main(String[] args) {
        try {

            // O Cliente é instanciado com o IP da máquina na qual o servidor está rodando (no caso, esse é o IP da máquina na qual o teste foi feito) e também com a porta pela qual ele irá se conectar com o Servidor.
            InetAddress enderecoIP = InetAddress.getByName("10.7.0.155");
            Socket socket = new Socket(enderecoIP, 12345);


            // O importante aqui é o fato de que o PrintWriter vai servir para escrever dados no fluxo de saída do Cliente, ou seja, enviar a mensagem pelo fluxo de saída do Cliente.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // O Scanner vai servir para ler do teclado a mensagem que será enviada pelo PrintWriter pelo fluxo de saída do servidor.
            Scanner scanner = new Scanner(System.in);


            // A mensagem é lida do teclado.
            String digite = "Digite a mensagem: ";
            System.out.print (digite);
            String mensagem = scanner.nextLine();

            // O PrintWriter (out) envia a mensagem lida do teclado para o fluxo de saída do Cliente.
            out.println(mensagem);

            out.close();
            scanner.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
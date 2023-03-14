import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPSocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		try{
			//Creation d'une Socket Serveur sur le port indiqu�
			serverSocket = new ServerSocket(8888);
			System.err.println("Server ready, waiting for connexion...");
			//Appel bloquant � accept jusqu'� connexion d'un client
			socket = serverSocket.accept();
			System.out.println("A client is connected!");
			//Utilisation de InputStream et OutputStream pour lire/ecrire des donn�es
			out = new PrintWriter(socket.getOutputStream());
			out.println("You're connected on the server !");
			//Appel � flush pour vider le tampon et forcer l'envoi du message au client
			out.flush();
			//Cloture de la connexion
			serverSocket.close();
			socket.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}

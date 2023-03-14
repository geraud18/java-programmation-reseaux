import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;


public class TCPSocketClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		String data = null;
		BufferedReader in = null;
		InetAddress adr = null;
		try{
			//Creation d'une adresse correspondant � celle du serveur � partir du nom
			adr = InetAddress.getByName("localhost");
			//Creation d'une socket � l'adresse et au port indiqu�
			System.out.println("Client requesting a connection...");
			socket = new Socket(adr,8888);
			//Utilisation de InputStream et OutputStream pour lire/ecrire sur la Socket
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Lecture de la socket distante
			//Lecture bloquante tant que le serveur n'a pas invoqu� accept()
			data = in.readLine();
			//Affichage du message re�u du serveur
			System.out.println("Received from Server : "+data);
			//Fermeture de la session
			socket.close();;
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}

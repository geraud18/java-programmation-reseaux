import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPSocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket socket = null;
		byte[] data = null;
		DatagramPacket packet = null;
		try{
			//Creation d'une socket qui �coute sur le port 8888
			socket = new DatagramSocket(8888);
			//Creation d'un buffer de donn�es de taille 15
			data = new byte[15];
			//Creation du packet UDP
			packet = new DatagramPacket(data, data.length);
			System.err.println("Server ready, waiting for connexion...");
			//Appel bloquant en attente de connexion
			socket.receive(packet);
			System.out.println("A client is connected !");
			//Recup�ration du message envoy� par le client
			String chaine = new String(packet.getData(),0, packet.getLength());
			System.out.println("Received from client : "+chaine);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}

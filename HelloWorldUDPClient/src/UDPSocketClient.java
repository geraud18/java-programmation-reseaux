import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSocketClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket socket = null;
		byte[] data = null;
		DatagramPacket packet = null;
		InetAddress adr = null;
		try{
			//Creation d'une adresse correspondant au serveur
			//Noter que localhost est utilis� car le serveur est local
			adr = InetAddress.getByName("localhost");
			//Creation des donn�es � envoyer
			data = (new String("Youpi!")).getBytes();
			//Creation du paquet udp contenant les donn�es � envoyer
			packet = new DatagramPacket(data, data.length,adr,8888);
			socket = new DatagramSocket();
			//Connexion et envoie du message au serveur
			socket.send(packet);
			System.out.println("Message sent!");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}

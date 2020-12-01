package Client;

import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import Serveur.ServeurIntf;

public class ThreadClient extends Thread {
	ServeurIntf in;
	ArrayList<String> msg;
	
	public ThreadClient(ServeurIntf serveur) throws IOException{
		this.in = serveur;
		msg = serveur.getMsg(0);
	}
	
	public void run() {
		try {
			ArrayList<String> bufferMsg = new ArrayList<String>(0);
			while(true) {
				bufferMsg = in.getMsg(msg.size());
				for(int i = 0;i<bufferMsg.size();i++) {
					msg.add(bufferMsg.get(i));
					System.out.println(bufferMsg.get(i));
					System.out.print(">");
				}
			}
		} catch (IOException e) {
			System.out.println("Erreur du traitement du message : "+ e);;
		}
	}
}
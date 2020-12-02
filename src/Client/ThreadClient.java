package Client;

import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import Serveur.ServeurIntf;

public class ThreadClient extends Thread {
	ServeurIntf serveur;
	ArrayList<String> msg;
	
	public ThreadClient(ServeurIntf serveur) throws IOException{
		this.serveur = serveur;
		// recuperation de l'historique des messages dans "msg"
		msg = serveur.getMsg(0);
	}
	
	public void run() {
		try {
			ArrayList<String> bufferMsg = new ArrayList<String>(0);
			while(true) {
				// recuperation des messages dans bufferMsg
				bufferMsg = serveur.getMsg(msg.size());
				for(int i = 0;i<bufferMsg.size();i++) {
					msg.add(bufferMsg.get(i));
					// affichage du dernier message 
					System.out.println(bufferMsg.get(i));
					System.out.print(">");
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur du traitement du message : "+ e);
		}
	}
}
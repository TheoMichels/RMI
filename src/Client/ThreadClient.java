package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.util.Vector;

import Serveur.ServeurIntf;

public class ThreadClient extends Thread {
	ServeurIntf in;
	Vector<String> msg;
	
	public ThreadClient(ServeurIntf serveur) throws IOException{
		this.in = serveur;
		msg = serveur.getMessages(0);
	}
	
	public void run() {
		try {
			Vector<String> bufferMsg = new Vector<String>(0);
			while(true) {
				bufferMsg = in.getMessages(msg.size());
				for(int i = 0;i<bufferMsg.size();i++) {
					msg.add(bufferMsg.get(i));
					System.out.println(bufferMsg.get(i));
				}
				//TimeUnit.MINUTES.sleep(1);
			}
		} catch (IOException /*| InterruptedException*/ e) {
			e.printStackTrace();
		}
	}
}

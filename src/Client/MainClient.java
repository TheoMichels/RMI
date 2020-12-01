package Client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import Serveur.ServeurIntf;

public class MainClient {
	ServeurIntf Serveur;
	Scanner sc;
	
	public MainClient() throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (ServeurIntf)Naming.lookup("//localhost/RmiServer");
		sc = new Scanner(System.in);
		try {
			new ThreadClient(Serveur).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws Exception {
		

        MainClient chatClient=new MainClient();  
        String user;
        
        System.out.println(chatClient.Serveur.messageBienvenue());
        System.out.println("Entrez un nom d'utilisateur : ");
        user = chatClient.sc.nextLine();
        
        while(true) {
        	System.out.println(">");
        	chatClient.Serveur.ecrireMessage(chatClient.sc.nextLine(),user);
        }
        
        
    }
}
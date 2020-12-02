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
			System.out.println("Echec du lancement du thread : "+ e);;
		}
	}
	
	public static void main(String args[]) throws Exception {
		
        MainClient chatClient=new MainClient();  
        String utilisateur;
        
        System.out.println(chatClient.Serveur.messageBienvenue());
        System.out.println("Donnez votre nom : ");
        utilisateur = chatClient.sc.nextLine();
		System.out.print(">");

        while(true) {
        	chatClient.Serveur.ecrireMsg(chatClient.sc.nextLine(), utilisateur);
        }
    }
}
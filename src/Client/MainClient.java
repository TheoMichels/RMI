package Client;

import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Serveur.ServeurIntf;

	public class MainClient {
		ServeurIntf Serveur;
		
		public MainClient() throws MalformedURLException, RemoteException, NotBoundException {
			Serveur = (ServeurIntf)Naming.lookup("//localhost/RmiServer");
		}
		
		public static void main(String args[]) throws Exception {
			MainClient chatClient = new MainClient();       
	    	System.out.println(chatClient.Serveur.messageBienvenue());	  
	    	//System.out.println(chatClient.Serveur.envoyer());
	       }
	}
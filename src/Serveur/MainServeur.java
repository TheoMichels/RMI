package Serveur;

import java.rmi.Naming;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class MainServeur extends UnicastRemoteObject implements ServeurIntf{
	private static final long serialVersionUID = 1L;
	
	
	public MainServeur() throws RemoteException{
	super(0);
	}
	
	@Override
	public String messageBienvenue() throws RemoteException{
		return "Bienvenue!";
	}
	
	/*public String envoyer() throws RemoteException {
		Scanner sc = new Scanner(System.in);
	    String msg = sc.nextLine();
	    return msg;
	}*/
	
	 public static void main(String args[]) throws Exception {
	        try { 
	            LocateRegistry.createRegistry(1099); 
	        } catch (RemoteException e) {
	        }
	        ServeurIntf MainClient = null;
	        MainServeur chatServeur = new MainServeur();
	        Naming.rebind("//localhost/RmiServer", chatServeur);
	        System.out.println("Serveur prêt!");
	    }
}
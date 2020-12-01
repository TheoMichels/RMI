package Serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MainServeur extends UnicastRemoteObject implements ServeurIntf{
	private static final long serialVersionUID = 1L;
	static String msg;
	
	public MainServeur() throws RemoteException{
	super(0);
	}
	
	@Override
	public String messageBienvenue() throws RemoteException{
		return "Bienvenue!";
	}
	
	 public static void main(String args[]) throws Exception {
	        try { 
	            LocateRegistry.createRegistry(1099); 
	        } catch (RemoteException e) {
	        }
	        MainServeur chatServeur = new MainServeur();
	        Naming.rebind("//localhost/RmiServer", chatServeur);
	        System.out.println("Serveur pret!");
	    }
	 
	 public ArrayList<String> getMessages(int lastMessagePos) throws RemoteException {
	
		 ArrayList<String> msg = new ArrayList<String>(0);
			for(int i = lastMessagePos;i<messages.size();i++) {
				msg.add(messages.get(i));
			}
	
			return msg;
		}

		public void ecrireMessage(String msg,String user) throws RemoteException {
			messages.add(user + " : " + msg);
		}
}
package Serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MainServeur extends UnicastRemoteObject implements ServeurIntf{
	private static final long serialVersionUID = 1L;
	
	public MainServeur() throws RemoteException{
	super(0);
	}
	
	// message de bienvenue sur le chat
	public String messageBienvenue() throws RemoteException{
		return "Bienvenue dans le chat !";
	}
	
	 public static void main(String args[]) throws Exception {
		 // creation du registre local pour la connexion au RMI
	        try { 
	            LocateRegistry.createRegistry(1099); 
	        } catch (RemoteException e) {
	        	System.out.println("Erreur de la connexion à distance : "+ e);
	        }
	        MainServeur chatServeur = new MainServeur();
	        Naming.rebind("//localhost/RmiServer", chatServeur);
	        System.out.println("Serveur pret!");
	    }
	 
	 // methode permettant de retourner une ArrayList contenant le dernier message du chat (avec le user qui l'a envoyé), en prenant en entree la position du dernier message envoye
	 public ArrayList<String> getMsg(int dernierePosition) throws RemoteException {
	
		 ArrayList<String> msg = new ArrayList<String>(0);
		 // recuparation du dernier messager en prenant a partir de la position du dernier message 
			for(int i = dernierePosition; i<chaineMsg.size(); i++) {
				// on donne a "msg" le dernier message de l'ArrayList 
				msg.add(chaineMsg.get(i));
			}
			return msg;
		}
	 
	 	// methode permettant d'ajouter le message d'un utilisateur à l'ArrayList
		public void ecrireMsg(String msg,String utilisateur) throws RemoteException {
			chaineMsg.add(utilisateur + " : " + msg);
		}
}
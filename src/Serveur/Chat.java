package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote {
	
	public void envoiMessage() throws RemoteException;
	public void recupMessage() throws RemoteException;
	public void nbMsgEnvoyes() throws RemoteException;
	public void arriveeUtilisateur() throws RemoteException;
	public void departutilisateur() throws RemoteException;
}	

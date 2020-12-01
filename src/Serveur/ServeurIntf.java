package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServeurIntf extends Remote {
	
	static  ArrayList<String> messages = new ArrayList<String>(0);

	public String messageBienvenue() throws RemoteException;
	
	public ArrayList<String> getMsg(int lastMessageKey) throws RemoteException;
	
	public void ecrireMsg(String msg,String user) throws RemoteException;
	
}

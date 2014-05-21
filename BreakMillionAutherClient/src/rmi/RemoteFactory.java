package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import DataServer.GameTasker;
import blservice.PlayerBLService;

public class RemoteFactory {
	static String host = "127.0.0.1";
    static String port = "8888";
	
	public static  	GameTasker getRmiGameTaskerService(){
		GameTasker rmiService=null;
		PlayerBLService playerService=null;
		 try {
			  rmiService =(GameTasker)Naming.lookup("rmi://" + host + ":" + port
	                 + "/MyGameTasker");
			  playerService=(PlayerBLService)Naming.lookup("rmi://" + host + ":" + port
		                 + "/MyPlayer");
	     } catch (NotBoundException e) {
	    	 JOptionPane.showMessageDialog(null, "网络连接超时...");
	     } catch (MalformedURLException e) {
	    	 JOptionPane.showMessageDialog(null, "网络连接超时...");
	     } catch (RemoteException e) {
	    	 JOptionPane.showMessageDialog(null, "网络连接超时...");
	     }
		return rmiService;
		 
	}
	public static  	PlayerBLService getPlayerBLService(){
		
		PlayerBLService playerService=null;
		 try {
			 
			  playerService=(PlayerBLService)Naming.lookup("rmi://" + host + ":" + port
		                 + "/MyPlayer");
	     } catch (NotBoundException e) {
	    	 JOptionPane.showMessageDialog(null, "网络连接超时...");
	     } catch (MalformedURLException e) {
	    	 JOptionPane.showMessageDialog(null, "网络连接超时...");
	     } catch (RemoteException e) {
	    	 JOptionPane.showMessageDialog(null, "网络连接超时...");
	     }
		return playerService;
		 
	}
	
}

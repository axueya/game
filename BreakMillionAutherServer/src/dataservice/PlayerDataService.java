package dataservice;

import java.rmi.RemoteException;

import po.PlayerPO;


public interface PlayerDataService {

	public PlayerPO find(String name) throws RemoteException;
	public void finish()throws RemoteException;
	public void insertPlayer(PlayerPO po) throws RemoteException;
	public void delete(PlayerPO po) throws RemoteException;
	public void update(PlayerPO po) throws RemoteException;
	public void init() throws RemoteException;
}

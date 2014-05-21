package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PlayerPO;

public interface PlayerBLService extends Remote {

	//]��½,������Ϣ
	public abstract String login(String name, String password)
			throws RemoteException;

	//ǰ���������û�һ������
	public abstract boolean checkPassword(String NAME, String password)
			throws RemoteException;

	public abstract void update(PlayerPO po, int hitCount, int score,
			float godtime)throws RemoteException;

}
package blservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PlayerPO;

public interface PlayerBLService extends Remote {

	//]登陆,更新信息
	public abstract String login(String name, String password)
			throws RemoteException;

	//前置条件是用户一定存在
	public abstract boolean checkPassword(String NAME, String password)
			throws RemoteException;

	public abstract void update(PlayerPO po, int hitCount, int score,
			float godtime)throws RemoteException;

}
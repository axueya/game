package rmi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import util.JdbcHelper;
import DataServer.GameTasker;
import bl.Player;
import blservice.PlayerBLService;




public class StartService extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Registry registry = null;
	JPanel panel = new JPanel();
	JButton buttonStart = new JButton("start");
	JButton buttonOver = new JButton("finish");
	JLabel label = new JLabel("消除游戏");
	JLabel labelSuccess = new JLabel(">>>>>INFO:success");

	public static void startService() {
		String host = "127.0.0.1";
		String port = "8888";
		try {
			GameTasker gameTasker=new GameTasker();
			PlayerBLService player=new Player();
			JdbcHelper.openDB();
			registry = LocateRegistry.createRegistry(Integer.valueOf(port));
			Naming.bind("rmi://" + host + ":" + port + "/MyGameTasker", (Remote) gameTasker);
			Naming.bind("rmi://" + host + ":" + port + "/MyPlayer", player);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("网络不通....");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("网络不通....");
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			System.out.println("网络不通....");
			e.printStackTrace();
		}
	}

	public static void finishRmi() {
		// try{
		// UnicastRemoteObject.unexportObject(registry, true);
		// Naming.unbind("MyUser");
		// Naming.unbind("MyCourse");
		// Naming.unbind("MyPermit");
		// Naming.unbind("MyPlan");
		// Naming.unbind("MyScore");
		// Naming.unbind("MySelection");
		// Naming.unbind("MyStudent");
		// Naming.unbind("MyTeacher");
		System.exit(0); //
		// } catch (RemoteException e) {
		// System.out.println("����Զ�̶������쳣��");
		// e.printStackTrace();
		// } catch (MalformedURLException e) {
		// System.out.println("����URL�����쳣��");
		// e.printStackTrace();
		// } catch (NotBoundException e) {
		// e.printStackTrace();
		// }
	}

	public StartService() {
		super("BreakMillionAutherServer");
		setSize(416, 300);
		this.add(panel);
		getContentPane().setLayout(null);
		this.add(buttonStart);
		ColorSet.setButton(buttonStart);
		ColorSet.setButton(buttonOver);
		JLabel myLabel=new JLabel("Copyright @ 2013 ���ذ���. All rights reserved. ");
		myLabel.setBounds(95, 245, 260, 20);
		Font f=new Font("΢���ź�",Font.PLAIN,11);
		myLabel.setFont(f);
		setResizable(false);
		getContentPane().setBackground(new Color(230, 230, 250));
		buttonStart.setBounds(100, 152, 89, 31);
		buttonOver.setBounds(240, 152, 89, 31);
		label.setBounds(70, 66, 300, 50);
		labelSuccess.setBounds(120, 180, 300, 50);
		label.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		this.add(buttonOver);
		this.add(label);
		this.add(labelSuccess);
		this.add(myLabel);
		labelSuccess.setVisible(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				startService();
				buttonStart.setEnabled(false);
				labelSuccess.setVisible(true);
				
			}
		});
		buttonOver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				finishRmi();
			}
		});

	}

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		new StartService();

	}
}

class ColorSet {

	public static void setButton(JButton button) {
		button.setBackground(new Color(148, 0, 211));
		button.setForeground(Color.white);
		Font f = new Font("��Բ", Font.BOLD, 12);
		button.setFont(f);
	}

	public static void setColor(JComponent com) {
		com.setBackground(new Color(253, 238, 199));
	}

	public static void setPanel(JPanel panel) {
		panel.setBackground(new Color(230, 230, 250));
		// panel.setBackground(new Color(50,57,65));
	}

	public static void setLabel(JLabel label) {
		label.setBackground(new Color(230, 230, 250));
	}

	public static void setLeft(JButton button) {
		button.setBackground(new Color(93, 162, 247));
		button.setForeground(Color.white);
		Font f = new Font("��Բ", Font.BOLD, 12);
		button.setFont(f);
	}

}



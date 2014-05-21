package Objcts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;

public class tst {
    static Box box;
    static ZButton zb;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//GameFrame zf=new GameFrame();
		BufferedImage[] button=new BufferedImage[5];
		button[1] = ImageIO.read(new FileInputStream("ui\\buttons\\queding1.png"));
		button[2] = ImageIO.read(new FileInputStream("ui\\buttons\\queding2.png"));
		button[3] = ImageIO.read(new FileInputStream("ui\\buttons\\queding3.png"));
		box=new Box("公告","网络连接中断");
		final ZButton zb=new ZButton(button[1],button[2],button[3],110,220,293,42);
		zb.addListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				int x=event.getX();
				int y=event.getY();
				if ((x>=zb.locatex)&&(x<=zb.locatex+zb.width)&&(y>=zb.locatey)&&(y<=zb.locatey+zb.height)){
			       System.exit(0);
				}
			}
		});
		
		box.add(zb);
		Timer tim=new Timer();
		tim.schedule(new MyTask1(),0,30);
        //ZTextArea zt=new ZTextArea(ImageIO.read(new FileInputStream("ui\\buttons\\kuang1.png")),311,38);
	}
	static class MyTask1 extends java.util.TimerTask{ 
        public void run() {
            box.zpanel.repaint();
        }
    } 
}

package Objcts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import UI.ZFrame;

public class Box extends ZFrame{
    public Box(String s1,String s2) throws FileNotFoundException, IOException{
    	super(500,300);
    	this.setLocation(1366, 768);
    	MoveOutTitle();
    	BufferedImage img=ImageIO.read(new FileInputStream("ui\\logobg2.png"));
    	zpanel.component.getGraphics().drawImage(img,0,0,null);
    	
    	Font font=new Font("华文中宋",Font.PLAIN,50);
    	DrawString(s1,200,60,font);
    	font=new Font("华文中宋",Font.PLAIN,20);
    	DrawString(s2,180,140,font);
    	
    	this.MoveToMid();
    }
    public void DrawString(String s,int x,int y,Font font){
    	Graphics g=zpanel.component.getGraphics();
    	g.setColor(Color.white);
    	g.setFont(font);
    	g.drawString(s, x, y);
    }
}

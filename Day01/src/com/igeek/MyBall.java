package com.igeek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * @author Administrator
 * 需求：小球移动
 * alt + /
 */
public class MyBall extends JFrame{
	
	int x = 40;
	int y = 40;
	int speed = 50;
	
	
	public MyBall() {
		setVisible(true);
		setSize(500, 500);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//注册监听
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_UP){
					y -= speed;
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					y += speed;
				}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					x -= speed;
				}else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					x += speed;
				}
				//重新绘制
				repaint();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.drawOval(x, y, 100, 100);
	}
	
	public static void main(String[] args) {
		MyBall myBall = new MyBall();
	}
	
	

}

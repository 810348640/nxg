package com.igeek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int width = 100;
		int height = 50;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics g = image.getGraphics();
		g.setColor(Color.PINK);
		g.fillRect(0, 0, width, height);
		g.drawRect(0, 0, width-1, height-1);
		g.setColor(Color.BLUE);
		//动态生成随机码
		String str= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random ran = new Random();
		int length = str.length();
		for (int i = 0; i < 5; i++) {
			//随机生成一个字符
			int index = ran.nextInt(length);
			char ch = str.charAt(index);
			g.drawString(ch+"", width/4*i, height/2);
		}
		//画干扰线
		for (int i = 0; i < 5; i++) {
			int x1 = ran.nextInt(width);
			int x2 = ran.nextInt(width);
			int y1 = ran.nextInt(height);
			int y2 = ran.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		//图片输出
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

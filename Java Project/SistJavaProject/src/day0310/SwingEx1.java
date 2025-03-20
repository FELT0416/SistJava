package day0310;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class SwingEx1 extends JFrame{
	
	Container cp;

	//생성자
	public SwingEx1(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 300, 500);
		//색상
		//this.setBackground(Color.BLUE);
		//this.getContentPane().setBackground(Color.PINK);  //Color클래스의 상수변수
		//this.getContentPane().setBackground(new Color(127,255,212));
		
		cp=this.getContentPane();
		
		//메인프레임종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cp.setBackground(new Color(127,255,212));
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new SwingEx1("스윙기본 #1");
	}

}

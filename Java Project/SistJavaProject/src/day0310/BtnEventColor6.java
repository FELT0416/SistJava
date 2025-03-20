package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BtnEventColor6 extends JFrame{
	Container cp;
	JButton btn1,btn2;

	//생성자
	public BtnEventColor6(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 800, 400);
		
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(127,255,212));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(new FlowLayout());
		
		btn1=new JButton("배경색을 핫핑크로 변경");
		this.add(btn1);
		
		//익명내부클래스로 이벤트
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cp.setBackground(Color.magenta);
				
			}
		});
		
		
		btn2=new JButton("배경색을 노랑색으로 변경");
		this.add(btn2);
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cp.setBackground(Color.yellow);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new BtnEventColor6("버튼이벤트#6");
	}


}

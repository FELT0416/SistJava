package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArrayRndEvent9 extends JFrame implements ActionListener{

	Container cp;
	JButton btnRandom;
	JLabel [] lblFood=new JLabel[9]; 
	String [] str= {"짜장면","짬뽕","탕수육","라조기","울면","잡채","유린기","칠리새우","마요새우"};

	//생성자
	public ArrayRndEvent9(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(2000, 100, 800, 900);
		
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(127,255,212));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		//패널을 프레임의 센터에 추가
		JPanel pCenter=new JPanel(new GridLayout(3, 3));
		this.add(pCenter);
		
		//라벨을 패널에 추가
		for(int i=0;i<lblFood.length;i++)
		{
			lblFood[i]=new JLabel(str[i],JLabel.CENTER);
			//r,g,b 랜덤색상 얻기
			int r=(int)(Math.random()*256);  //0~255
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			
			lblFood[i].setBackground(new Color(r, g, b));
			
			lblFood[i].setOpaque(true);
			
			//패널에 라벨추가
			pCenter.add(lblFood[i]);
		}
		
		
		//프레임의 하단에 버튼생성후 추가
		btnRandom=new JButton("라벨색상변경");
		//this.add(btnRandom,BorderLayout.SOUTH);
		this.add("South", btnRandom);
		
		//버튼에 이벤트추가ㅣ
		btnRandom.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new ArrayRndEvent9("배열랜덤 테스트#9");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<lblFood.length;i++)
		{
			
			//r,g,b 랜덤색상 얻기
			int r=(int)(Math.random()*256);  //0~255
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			
			lblFood[i].setBackground(new Color(r, g, b));
			
			
		}
	}

}

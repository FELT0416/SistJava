package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingIcon5 extends JFrame{

	Container cp;
	
	//각각의 이미지아이콘
	ImageIcon icon1=new ImageIcon("C:\\sist0217\\image\\swingimage\\LEFT.GIF");
	ImageIcon icon2=new ImageIcon("C:\\sist0217\\image\\swingimage\\leftDown.gif");
	ImageIcon icon3=new ImageIcon("C:\\sist0217\\image\\swingimage\\leftRollover.gif");
	ImageIcon icon4=new ImageIcon("C:\\sist0217\\image\\swingimage\\an08.gif");
	ImageIcon icon5=new ImageIcon("C:\\sist0217\\image\\swingimage\\img1.gif");
	
	JButton btn1,btn2,btn3,btn4;

	//생성자
	public SwingIcon5(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 800, 500);
		
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(221,160,221));
		initDesign();
		this.setVisible(true);
	}
	
	//디자인
	public void initDesign()
	{
		//레이아웃 그리드로 변경
		this.setLayout(new GridLayout(2, 2)); //2행2열
		
		//버튼4개생성
		btn1=new JButton("hello", icon1);
		this.add(btn1); //프레임에추가
		btn1.setHorizontalTextPosition(JButton.CENTER); //텍스트 가로위치
		btn1.setVerticalTextPosition(JButton.BOTTOM); //텍스트 세로위치
		
		//마우스이벤트
		btn1.setPressedIcon(icon2); //클릭해야 이미지수정
		btn1.setRolloverIcon(icon3); //올려만놔도 수정
		
		btn2=new JButton(icon5);
		this.add(btn2);
		
		btn3=new JButton(icon4);
		this.add(btn3);
		
		btn4=new JButton("안녕 자바");
		this.add(btn4);
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new SwingIcon5("스윙아이콘#5");
	}


}

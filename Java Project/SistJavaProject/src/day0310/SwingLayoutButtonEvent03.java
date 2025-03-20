package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingLayoutButtonEvent03 extends JFrame implements ActionListener{

	Container cp;
	JButton btn1,btn2,btn3;

	//생성자
	public SwingLayoutButtonEvent03(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 300, 500);
		
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(127,255,212));
		
		setDegign();
		
		this.setVisible(true);
	}
	
	//디자인
	public void setDegign()
	{
		//레이아웃 변경
		this.setLayout(new FlowLayout());
		//버튼생성
		btn1=new JButton("버튼#1");
		btn2=new JButton("버튼#2");
		btn3=new JButton("버튼#3");
		
		//프레임에 추가
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		
		//색상
		btn1.setBackground(Color.CYAN);
		btn2.setBackground(Color.MAGENTA);
		btn3.setBackground(Color.BLUE);
		
		//글자색
		btn3.setForeground(Color.WHITE);
		
		//버튼에 이벤트를 발생..버튼에 이벤트 핸들러 역할 부여
		btn1.addActionListener(this); //상속받았으니까 this
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	}
	
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//메세지를 클릭시 다이얼로그 형태로 보여준다
		//JOptionPane.showMessageDialog(this, "버튼클릭");
		
		Object ob=e.getSource(); //버튼을 어떤메소드를 호출하는 지 정확하게 지정해 주기위해서
		
		if(ob==btn1)
			JOptionPane.showMessageDialog(this, "1번째 버튼입니다");
		else if(ob==btn2)
			JOptionPane.showMessageDialog(this, "2번째 버튼입니다");
		else if(ob==btn3)
			JOptionPane.showMessageDialog(this, "3번째 버튼입니다");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new SwingLayoutButtonEvent03("스윙레이아웃#3");
	}

	

}

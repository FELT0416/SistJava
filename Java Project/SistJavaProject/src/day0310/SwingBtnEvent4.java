package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingBtnEvent4 extends JFrame implements ActionListener{

	Container cp;
	JButton btn1,btn2;

	//생성자
	public SwingBtnEvent4(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 500, 300);
		
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(127,255,212));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(new FlowLayout());
		
		btn1=new JButton("◀");
		btn2=new JButton("▶");
		
		btn1.setBackground(Color.LIGHT_GRAY);
		btn2.setBackground(Color.yellow);
		
		this.add(btn1);
		this.add(btn2);
		
		//이벤트핸들러 부여
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		if(ob==btn1)
			JOptionPane.showMessageDialog(this, "왼쪽버튼클릭!!");
		else if(ob==btn2)
			JOptionPane.showMessageDialog(this, "오른쪽 버튼클릭!!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new SwingBtnEvent4("스윙 버튼이벤트#4");
	}

	


}

package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//두개의 라벨과 텍스트필트  그리고 버튼을 만든후 
//각각 숫자를 넣고 버튼을 클릭하면 라벨에 22+44=66 출력할 예정
public class LayoutNull8 extends JFrame{

	Container cp;
	JLabel lblResult,lblnum1,lblnum2;
	JTextField tfSu1,tfSu2;
	JButton btnAdd;
	

	//생성자
	public LayoutNull8(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(200, 100, 500, 300);
		
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(127,255,212));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		//기본레이아웃 없애고 직접 지정
		this.setLayout(null);
		lblnum1=new JLabel("숫자1: ");
		lblnum2=new JLabel("숫자2: ");
		
		lblnum1.setBounds(50, 30, 80, 50);
		this.add(lblnum1);
		
		lblnum2.setBounds(50, 80, 80, 50);
		this.add(lblnum2);
		
		tfSu1=new JTextField();
		tfSu1.setBounds(150, 30, 100, 40);
		this.add(tfSu1);
		
		tfSu2=new JTextField();
		tfSu2.setBounds(150, 80, 100, 40);
		this.add(tfSu2);
		
		btnAdd=new JButton("숫자더하기");
		btnAdd.setBounds(300, 50, 100, 50);
		this.add(btnAdd);
		
		//결과나오는곳
		lblResult=new JLabel("결과 나오는곳");
		lblResult.setBounds(100, 160, 200, 50);
		lblResult.setBorder(new TitledBorder("결과확인"));
		lblResult.setFont(new Font("", Font.BOLD, 20));
		this.add(lblResult);
		
		//버튼이벤트 _ 익명내부클래스
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int su1=Integer.parseInt(tfSu1.getText().trim()); //앞뒤공백제거후 숫자로변환
				int su2=Integer.parseInt(tfSu2.getText().trim());
				
				int sum=su1+su2;
				
				String s=su1+"+"+su2+"="+sum;
				
				lblResult.setText(s); //라벨에 s출력
				
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new LayoutNull8("스윙레이아웃 Null#8");
	}


}

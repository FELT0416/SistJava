package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import day0310.SwingLayoutButtonEvent03;

public class RadioCheck01 extends JFrame implements ActionListener{

	Container cp;
	JRadioButton [] rb=new JRadioButton[4]; //하나만 선택하고 싶을때
	JCheckBox [] cb=new JCheckBox[5]; //다중선택가능
	JLabel lblMessage; //결과출력할곳
	Color [] colors= {Color.red,Color.green,Color.magenta,Color.blue};

	//생성자
	public RadioCheck01(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(2500, 100, 800, 500);
		
		cp=this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(255,255,200));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		//상단패널에 보더로 감싼 4개의 라디오버튼만들기
		String [] str1= {"빨강","초록","핫핑크","파랑"};
		JPanel pTop=new JPanel();
		pTop.setBorder(new TitledBorder("글자색선택"));
		this.add("North",pTop);
		
		
		
		//라디오 버튼을 하나만 선택되도록 하려면 그룹을 지어줘야함
		ButtonGroup bg=new ButtonGroup();
		
		for(int i=0;i<rb.length;i++)
		{
			rb[i]=new JRadioButton(str1[i], i==1?true:false); //라디오버튼생성
			pTop.add(rb[i]);//탑패널에 4개의 라디오버튼추가
			bg.add(rb[i]);  //버튼그룹에 4개의 라디오버튼을 추가
			
			rb[i].addActionListener(this); //버튼에 액션추가
		}
		
		//결과출력
		ImageIcon icon=new ImageIcon("C:\\sist0217\\image\\swingimage\\45-pandadog.gif");
		
		lblMessage=new JLabel("오늘은 즐거운 수요일!!!",icon, JLabel.CENTER);
		lblMessage.setHorizontalTextPosition(JLabel.LEFT);
		lblMessage.setBorder(new LineBorder(Color.red,2)); //라인굵기
		this.add("Center",lblMessage);
		
		//하단패널에 보더로 감싼 5개의 checkbox버튼 만들기
		JPanel pBottom=new JPanel();
		pBottom.setBorder(new TitledBorder("가능 컴퓨터 언어는?"));
		this.add("South",pBottom);
		String[] str2= {"Java","Html","Jsp","Ajex","Spring"};
		
		for(int i=0;i<cb.length;i++)
		{
			cb[i]=new JCheckBox(str2[i]);
			pBottom.add(cb[i]);
			cb[i].addActionListener(this);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new RadioCheck01("스윙 Radio&Check #01");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob=e.getSource();
		
		//라디오버튼처리,메세지 컬러별로 출력
		for(int i=0;i<rb.length;i++)
		{
			if(ob==rb[i])
			{
				//글자색변경
				lblMessage.setForeground(colors[i]);
				//폰트
				lblMessage.setFont(new Font("", Font.BOLD, 20));
			}
		}
		
		//체크박스 호출처리,선택한 체크박스의 메세지별출력
		String msg="나의 가능한 컴퓨터 언어는  ";
		
		for(int i=0;i<cb.length;i++)
		{
			if(cb[i].isSelected()==true)
			{
				msg+=cb[i].getText()+"  ";
			}
		}
		
		lblMessage.setText(msg);
		
		
		
	}


}

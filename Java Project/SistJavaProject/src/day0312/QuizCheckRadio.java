package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class QuizCheckRadio extends JFrame{

	Container cp;
	JRadioButton rbWoman,rbMen;
	JRadioButton []rbColor=new JRadioButton[5];
	JCheckBox [] cbNara=new JCheckBox[6];
	JLabel lblResult;
	String []strcolor= {"노랑","분홍","초록","하늘","오렌지"};
	Color [] co= {Color.yellow,Color.pink,Color.green,Color.cyan,Color.orange};
	String [] strnara= {"미국","영국","일본","호주","체코","오스트리아"};
	JButton btnNara;


	//생성자
	public QuizCheckRadio(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자

		//위치 너비
		this.setBounds(2500, 100, 700, 500);

		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		initDesign();
		this.setVisible(true);
	}

	public void initDesign()
	{
		this.setLayout(null);
		rbMen=new JRadioButton("남자",true);
		rbMen.setBounds(50, 30, 60, 30);
		rbMen.setOpaque(false);
		this.add(rbMen);

		rbWoman=new JRadioButton("여자");
		rbWoman.setBounds(130, 30, 60, 30);
		rbWoman.setOpaque(false);
		this.add(rbWoman);

		//남자 여자 라디오버튼 그룹
		ButtonGroup bgGender=new ButtonGroup();
		bgGender.add(rbMen);
		bgGender.add(rbWoman);
		
		rbWoman.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				lblResult.setText("여자입니다");
			}
		});
		
		rbMen.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				lblResult.setText("남자입니다");
			}
		});
		
		

		//라벨 생성
		lblResult=new JLabel("Result.....");
		lblResult.setFont(new Font("고딕체", Font.BOLD, 17));
		lblResult.setBorder(new LineBorder(Color.pink,5));
		lblResult.setBounds(80, 290, 400, 60);
		lblResult.setOpaque(true);
		this.add(lblResult);	
		
		ButtonGroup bg=new ButtonGroup();
		int xpos=50;

		
		for(int i=0;i<rbColor.length;i++)
		{
			int idx=i;
			rbColor[i]=new JRadioButton(strcolor[i]);
			bg.add(rbColor[i]);
			rbColor[i].setBounds(xpos, 80, 70, 30);
			rbColor[i].setOpaque(false);
			this.add(rbColor[i]);
			xpos+=70;
			
			
			//이벤트
			rbColor[i].addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					lblResult.setForeground(co[idx]);
				}
			});
			
		}



		//체크박스
		int xpo=50;
		for(int i=0;i<cbNara.length;i++)
		{
			cbNara[i]=new JCheckBox(strnara[i]);
			cbNara[i].setBounds(xpo, 120, 70, 30);
			cbNara[i].setOpaque(false);
			this.add(cbNara[i]);
			xpo+=70;
		}
		
		//나라선택버튼
		btnNara=new JButton("선택");
		btnNara.setBounds(500,120,80,30);
		this.add(btnNara);
		
		btnNara.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String mynara="가본나라는 ";
				int select=0;
				for(int i=0;i<cbNara.length;i++)
				{
					if(cbNara[i].isSelected())
					{
						select++;
						mynara+="["+cbNara[i].getText()+"]";
					}
				}
				
				if(select==0)
					mynara="나는 가본나라가 없어요ㅜㅜ";
				else
					mynara+=" 입니다";
				
				//라벨에 출력
				lblResult.setText(mynara);
			}
		});
				
				
				
				
				
				
		

	}

	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new QuizCheckRadio("스윙 체크&라디오 과제");
	}




}

package day0312;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboGraphic extends JFrame{

	Container cp;
	JComboBox<String> combo;
	String [] items= {"선","원","사각형","이미지","문자열"};
	int idx=3; //이미지를 기본값으로 설정하기 위해서
	ComboDraw draw;
	
	static final String iamgeName="C:\\sist0217\\logoImg\\a.png";
	

	//생성자
	public ComboGraphic(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(2500, 100, 500, 500);
		
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(null);
		
		combo=new JComboBox<String>(items);
		combo.setBounds(40, 50, 100, 30);
		combo.setSelectedIndex(idx); //초기값 지정
		this.add(combo);
		
		//콤보박스 선택시 이벤트
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				idx=combo.getSelectedIndex();
				draw.repaint(); //내부클래스의 paint호출
			}
		});
		
		draw=new ComboDraw();
		draw.setBounds(30, 60, 450, 400);
		this.add(draw);
		
	}
	
	//랜덤하게 구해서 Color타입으로 반환하는 메서드
	public Color getRandomColor()
	{
		int r=(int)(Math.random()*256); //0~255
		int g=(int)(Math.random()*256);
		int b=(int)(Math.random()*256);
		
		return new Color(r,g,b);
	}
	
	class ComboDraw extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			Image image=null;
			Color color=null;
			
			int x1=0,x2=0,y1=0,y2=0;
			
			switch(idx)
			{
			case 0: //선
				for(int i=1;i<=20;i++)
				{
					color=getRandomColor();
					g.setColor(color);
					
					x1=(int)(Math.random()*300)+20; //20~319
					x2=(int)(Math.random()*300)+20;
					y1=(int)(Math.random()*500)+100; //100~599
					y2=(int)(Math.random()*500)+100; //100~599
					
					g.drawLine(x1, x1, y1, y2);
				}
				
				break;
				
			case 1:  //원
				for(int i=1;i<=20;i++)
				{
					color=getRandomColor();
					g.setColor(color);
					
					x1=(int)(Math.random()*400)+20; //20~419
					y1=(int)(Math.random()*500)+20; //20~519
					
					g.fillOval(x1,y1,50,50);
				}
				break;
				
			case 2:  //사각형
				for(int i=1;i<=20;i++)
				{
					color=getRandomColor();
					g.setColor(color);
					
					x1=(int)(Math.random()*400)+20; //20~419
					y1=(int)(Math.random()*500)+20; //20~519
					
					g.fillRect(x1,y1,60,60);
				}
				break;
			case 3: //이미지
				image=new ImageIcon(iamgeName).getImage();
				g.drawImage(image, 100, 100, this);
				break;
			case 4: //문자열 10개
				g.setFont(new Font("Arial", Font.ITALIC, 23));
				
				for(int i=1;i<=10;i++)
				{
					color=getRandomColor();
					g.setColor(color);
					
					x1=(int)(Math.random()*400)+20; //20~419
					y1=(int)(Math.random()*500)+20; //20~519
					
					g.drawString("Hello Java", x1, y1);
				}
				
				
				break;
				
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new ComboGraphic("콤보박스로 그래픽 나타내기 #6");
	}


}

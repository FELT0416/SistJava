package day0310;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Quiz0310 extends JFrame{

    Container cp;

    JButton add,sub,mul,div;
    JTextField tf1, tf2;
    JLabel result;
    Quiz0310(String title){
        super(title);
        this.setBounds(500, 100, 800, 500);
        initDesign();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp = this.getContentPane();
        cp.setBackground(Color.white);

        this.setVisible(true);
    }

    public void initDesign(){
        this.setLayout(new GridLayout(7,1));
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        this.add(tf1);
        this.add(tf2);
        add = new JButton("Add");
        sub = new JButton("Sub");
        mul = new JButton("Mul");
        div = new JButton("Div");
        this.add(add);
        this.add(sub);
        this.add(mul);
        this.add(div);
        result = new JLabel("Result");

    }





    public static void main(String[] args) {
        Quiz0310 obj = new Quiz0310("Quiz 0310");

    }


}

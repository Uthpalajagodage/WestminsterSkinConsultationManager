package coursework.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiFrontPage extends JFrame {
    JFrame frame =new JFrame();
    JLabel mainTitle=new JLabel("WESTMINSTER");
    JLabel mainTitle2=new JLabel("Skin Consultation Center");
    ImageIcon mainImage=new ImageIcon("images/mainImage.png");
    JLabel Image=new JLabel(mainImage);
    JButton rButton=new JButton("Book an Appoinment");
    public GuiFrontPage(){
        frame.setTitle("Westminster Skin Consultation");
        frame.setSize(900,800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);//cant resize
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//close the code when it close

        Image.setSize(900,800);
        Image.setLocation(0,0);
        frame.add(Image);   //add image to the frame

        mainTitle.setSize(800,120);
        mainTitle.setLocation(200,60);
        mainTitle.setFont(new Font("Bell MT",Font.BOLD,60));
        Image.add(mainTitle);

        mainTitle2.setSize(800,120);
        mainTitle2.setLocation(120,150);
        mainTitle2.setFont(new Font("Bahnschrift SemiLight",Font.BOLD,50));
        Image.add(mainTitle2);


        rButton.setSize(300,70);
        rButton.setLocation(450,400);
        rButton.setFont(new Font("Times New Roman",Font.BOLD,25));
        Image.add(rButton);

        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);//close the frame
                new GuiPage();
            }
        });

    }
}

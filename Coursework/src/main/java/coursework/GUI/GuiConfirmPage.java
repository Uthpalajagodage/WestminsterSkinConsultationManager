package coursework.GUI;

import coursework.Consultation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiConfirmPage extends JFrame {
    JFrame frame =new JFrame();
    JLabel mainTitle=new JLabel("Great, You're Booked!");
    ImageIcon confirmImage=new ImageIcon("images/confirmImage.png");
    JLabel coImage=new JLabel(confirmImage);
    JLabel cTitle = new JLabel("  Booking Details");
    JLabel bDName = new JLabel();
    JLabel bDate = new JLabel();
    JLabel bTime = new JLabel();
    JLabel bCost = new JLabel();
    JLabel thankyou = new JLabel("Your booking is confirmed.Thank You!");
    JButton doneButton=new JButton("Done");

    public GuiConfirmPage(Consultation consultation){
        frame.setTitle("Westminster Skin Consultation Manager");
        frame.setSize(900,800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setResizable(false);//cant resize
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//close the code when it close

        mainTitle.setSize(800,120);
        mainTitle.setLocation(250,40);
        mainTitle.setFont(new Font("Times New Roman",Font.BOLD,45));
        frame.add(mainTitle);

        coImage.setSize(900,800);
        coImage.setLocation(0,0);
        frame.add(coImage);

        cTitle.setSize(800, 120);
        cTitle.setLocation(150, 150);
        cTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
        coImage.add(cTitle);

        bDName.setSize(800, 120);
        bDName.setLocation(250, 250);
        bDName.setFont(new Font("Times New Roman", Font.BOLD, 25));
        bDName.setText("Doctor's Name : Dr."+consultation.getDoctor().getName()+" "+consultation.getDoctor().getSurname());
        coImage.add(bDName);

        bDate.setSize(800, 120);
        bDate.setLocation(250, 320);
        bDate.setFont(new Font("Times New Roman", Font.BOLD, 25));
        bDate.setText("Appointment Date : "+consultation.getDate());
        coImage.add(bDate);

        bTime.setSize(800, 120);
        bTime.setLocation(250, 390);
        bTime.setFont(new Font("Times New Roman", Font.BOLD, 25));
        bTime.setText("Appointment Time : "+consultation.getTime());
        coImage.add(bTime);

        bCost.setSize(800, 120);
        bCost.setLocation(250, 460);
        bCost.setFont(new Font("Times New Roman", Font.BOLD, 25));
        bCost.setText("Total Cost : £"+consultation.getCost());
        coImage.add(bCost);

        thankyou.setSize(800, 120);
        thankyou.setLocation(200, 550);
        thankyou.setFont(new Font("Times New Roman", Font.BOLD, 28));
        coImage.add(thankyou);

        doneButton.setSize(200,60);
        doneButton.setLocation(350,650);
        doneButton.setFont(new Font("Times New Roman",Font.BOLD,25));
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GuiPage();
            }
        });
        coImage.add(doneButton);
    }

}

package coursework.GUI;

import coursework.Consultation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static coursework.ConsoleApplication.manager;

public class GuiViewPage extends JFrame {
    JFrame frame=new JFrame();
    JPanel panel0=new JPanel();
    JPanel panel=new JPanel();
    JLabel title=new JLabel("View Consultations");
    JLabel enterId=new JLabel("Enter patient ID : ");
    JTextField pId = new JTextField();
    JLabel reqLable = new JLabel("*Required");
    JButton bButton = new JButton("Back");
    JButton vButton = new JButton("View");
    JLabel pName = new JLabel("Uthpala Jagodage");
    ImageIcon viewImage=new ImageIcon("images/viewImage.png");
    JLabel Image = new JLabel(viewImage);
    ImageIcon availableImage=new ImageIcon("images/availableImage.png");
    JLabel vImage = new JLabel(viewImage);
    JLabel iDNum = new JLabel();
    JLabel drName = new JLabel();
    JLabel appoinmentDate = new JLabel("Appoinment Date");
    JTextField appoinmentDateText = new JTextField();
    JLabel appointmentTime = new JLabel("Appoinment Time");
    JTextField appoinmentTimeText = new JTextField();
    JLabel appoinmentHours = new JLabel("Appoinment Hours");
    JTextField appoinmentHoursText = new JTextField();
    JLabel noteType = new JLabel("Special Note");
    JTextField noteTypeText = new JTextField();
    JLabel payment = new JLabel("Total Cost is £");
    JButton goBackButton = new JButton("Back");
    JButton nextButton = new JButton("Next");
    JButton prevButton = new JButton("Previous");

    ArrayList<Consultation> temp_array;
    int count_index=0;

    public GuiViewPage(){
        frame.setTitle("Westminster Skin Consultation Manager");
        frame.setSize(900, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //1 st page for view

        panel0.setSize(900, 800);
        panel0.setVisible(true);
        panel0.setLayout(null);
        frame.add(panel0);

        vImage.setSize(900,800);
        vImage.setLocation(0,0);
        panel0.add(vImage);

        title.setSize(800, 120);
        title.setLocation(300, 10);
        title.setFont(new Font("Times New Roman", Font.BOLD, 45));
        vImage.add(title);

        enterId.setSize(800, 120);
        enterId.setLocation(400, 250);
        enterId.setFont(new Font("Times New Roman", Font.BOLD, 30));
        vImage.add(enterId);

        pId.setSize(400, 60);
        pId.setLocation(400, 350);
        pId.setFont(new Font("Times New Roman", Font.BOLD, 30));
        pId.setHorizontalAlignment(JTextField.CENTER);
        vImage.add(pId);

        reqLable.setSize(300, 70);
        reqLable.setLocation(700, 280);
        reqLable.setFont(new Font("Times New Roman", Font.BOLD, 10));
        reqLable.setForeground(Color.red);
        reqLable.setVisible(false);
        vImage.add(reqLable);

        bButton.setSize(80, 50);
        bButton.setLocation(100, 650);
        bButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        vImage.add(bButton);
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GuiPage();
            }
        });

        vButton.setSize(80, 50);
        vButton.setLocation(600, 650);
        vButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        vImage.add(vButton);
        vButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id_patientValidate()){
                    nextButton.setVisible(true);
                    prevButton.setVisible(false);
                    count_index=0;
                    panel0.setVisible(false);
                    panel.setVisible(true);

                    appoinmentDateText.setText(temp_array.get(count_index).getDate());
                    appoinmentTimeText.setText(temp_array.get(count_index).getTime());
                    appoinmentHoursText.setText(""+temp_array.get(count_index).getPatient_appointment_time());
                    noteTypeText.setText(temp_array.get(count_index).decrypt());
                    drName.setText("Dr."+temp_array.get(count_index).getDoctor().getName()+" "+temp_array.get(count_index).getDoctor().getSurname());
                    pName.setText(temp_array.get(count_index).getPatient().getName()+" "+temp_array.get(count_index).getPatient().getSurname());
                    iDNum.setText(temp_array.get(count_index).getPatient().getId());
                    payment.setText("Total Cost is £"+temp_array.get(count_index).getCost());

                    if (count_index==(temp_array.size()-1)){
                        nextButton.setVisible(false);
                    }
                }
            }
        });


        //2nd page for view

        panel.setSize(900, 800);
        panel.setVisible(false);
        panel.setLayout(null);
        frame.add(panel);

        Image.setSize(900,800);
        Image.setLocation(0,0);
        panel.add(Image);

        pName.setSize(800, 120);
        pName.setLocation(200, 10);
        pName.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Image.add(pName);

        iDNum.setSize(800, 120);
        iDNum.setLocation(200, 60);
        iDNum.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Image.add(iDNum);

        drName.setSize(800, 120);
        drName.setLocation(200, 100);
        drName.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Image.add(drName);

        payment.setSize(800, 120);
        payment.setLocation(550, 30);
        payment.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(payment);

        appoinmentDate.setSize(800, 120);
        appoinmentDate.setLocation(100, 200);
        appoinmentDate.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(appoinmentDate);

        appoinmentDateText.setSize(450, 50);
        appoinmentDateText.setLocation(400, 250);
        appoinmentDateText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        appoinmentDateText.setHorizontalAlignment(JTextField.CENTER);
        appoinmentDateText.setBackground(new Color(218,221,227));
        appoinmentDateText.setEditable(false); //remove edit access in the text field
        Image.add(appoinmentDateText);

        appointmentTime.setSize(800, 120);
        appointmentTime.setLocation(100, 300);
        appointmentTime.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(appointmentTime);

        appoinmentTimeText.setSize(450, 50);
        appoinmentTimeText.setLocation(400, 350);
        appoinmentTimeText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        appoinmentTimeText.setHorizontalAlignment(JTextField.CENTER);
        appoinmentTimeText.setBackground(new Color(218,221,227));
        appoinmentTimeText.setEditable(false);
        Image.add(appoinmentTimeText);

        appoinmentHours.setSize(800, 120);
        appoinmentHours.setLocation(100, 400);
        appoinmentHours.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(appoinmentHours);

        appoinmentHoursText.setSize(450, 50);
        appoinmentHoursText.setLocation(400, 450);
        appoinmentHoursText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        appoinmentHoursText.setHorizontalAlignment(JTextField.CENTER);
        appoinmentHoursText.setBackground(new Color(218,221,227));
        appoinmentHoursText.setEditable(false);
        Image.add(appoinmentHoursText);

        noteType.setSize(800, 120);
        noteType.setLocation(100, 500);
        noteType.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(noteType);

        noteTypeText.setSize(450, 50);
        noteTypeText.setLocation(400, 550);
        noteTypeText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        noteTypeText.setHorizontalAlignment(JTextField.CENTER);
        noteTypeText.setBackground(new Color(218,221,227));
        noteTypeText.setEditable(false);
        Image.add(noteTypeText);

        goBackButton.setSize(80, 50);
        goBackButton.setLocation(100, 650);
        goBackButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Image.add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel0.setVisible(true);
            }
        });

        nextButton.setSize(80, 50);
        nextButton.setLocation(600, 650);
        nextButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count_index++;

                appoinmentDateText.setText(temp_array.get(count_index).getDate());
                appoinmentTimeText.setText(temp_array.get(count_index).getTime());
                appoinmentHoursText.setText(""+temp_array.get(count_index).getPatient_appointment_time());
                noteTypeText.setText(temp_array.get(count_index).decrypt());
                drName.setText("Dr."+temp_array.get(count_index).getDoctor().getName()+" "+temp_array.get(count_index).getDoctor().getSurname());
                pName.setText(temp_array.get(count_index).getPatient().getName()+" "+temp_array.get(count_index).getPatient().getSurname());
                iDNum.setText(temp_array.get(count_index).getPatient().getId());
                payment.setText("Total Cost is £"+temp_array.get(count_index).getCost());

                if (count_index==(temp_array.size()-1)){
                    nextButton.setVisible(false);
                }

                if (!(count_index==0)){
                    prevButton.setVisible(true);
                }
            }
        });
        Image.add(nextButton);

        prevButton.setSize(100, 50);
        prevButton.setLocation(700, 650);
        prevButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count_index--;

                appoinmentDateText.setText(temp_array.get(count_index).getDate());
                appoinmentTimeText.setText(temp_array.get(count_index).getTime());
                appoinmentHoursText.setText(""+temp_array.get(count_index).getPatient_appointment_time());
                noteTypeText.setText(temp_array.get(count_index).decrypt());
                drName.setText("Dr."+temp_array.get(count_index).getDoctor().getName()+" "+temp_array.get(count_index).getDoctor().getSurname());
                pName.setText(temp_array.get(count_index).getPatient().getName()+" "+temp_array.get(count_index).getPatient().getSurname());
                iDNum.setText(temp_array.get(count_index).getPatient().getId());
                payment.setText("Total Cost is £"+temp_array.get(count_index).getCost());


                if ((count_index==0)){
                    prevButton.setVisible(false);
                }
                nextButton.setVisible(true);
            }
        });
        Image.add(prevButton);


    }

    private boolean id_patientValidate() {
        temp_array=new ArrayList<>();
        if (pId.getText().length()==0){
            reqLable.setVisible(true);
            reqLable.setText("Required");
            return false;
        }else {
            boolean check=false;
            for (Consultation consultation:manager.returnConsultationArrayList()){
                if (pId.getText().equals(consultation.getPatient().getId())){
                    temp_array.add(consultation);
                    check=true;
                }
            }
            if (check){
                reqLable.setVisible(false);
                return true;
            }else {
                reqLable.setVisible(true);
                reqLable.setText("Cant find patient");
                return false;
            }
        }
    }


}
